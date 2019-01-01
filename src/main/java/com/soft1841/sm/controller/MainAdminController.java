package com.soft1841.sm.controller;



import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.entity.Vip;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.service.VipService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.net.URL;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * 后台主界面 控制器
 * @author 杨晶
 * 2018-12-25
 */

public class MainAdminController implements Initializable {
    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private TypeService typeService  = ServiceFactory.getTypeServiceInstance();
    private VipService vipService = ServiceFactory.getVipDAOInstance();
    private List<Vip> vipList = new ArrayList<>();
    @FXML
    private FlowPane vipPane;



    @FXML
    private ImageView goodsImg;
    @FXML
    private StackPane mainContainer;

    String[] imgPath = {"1.jpg","bg1.jpg","dahai.jpg"};
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //循环读取图片线程
                    for (int i =0; i<imgPath.length; i++){
                        //用每个资源创建一个图片对象
                        Image image = new Image("/img/" + imgPath[i]);
                        //开启一个UI线程
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                //将创建的Image对象设置给ImageView
                                goodsImg.setImage(image);
                            }
                        });
                        try {
                            //休眠3秒
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //轮播到最后一张图的时候，回到第一张重新播放
                        if (i== imgPath.length){
                            i = 0 ;
                        }
                    }
                }
            }
        }).start();
    }
    public void listType() throws Exception {
        switchView("type.fxml");
    }
    public  void listGoods() throws  Exception{
        switchView("goods.fxml");
    }
    public  void listVip() throws  Exception{
        switchView("vip.fxml");
    }
        public  void  web() throws  Exception{
            Stage stage = new Stage();
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            webEngine.load("https://www.baidu.com/?tn=64075107_1_dg");
            Scene scene = new Scene(webView);
            stage.setScene(scene);
            stage.show();
        }
    public  void  taobao() throws  Exception{
        Stage stage = new Stage();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://www.taobao.com/");
        Scene scene = new Scene(webView);
        stage.setScene(scene);
        stage.show();
    }

    public  void  jingdong() throws  Exception{
        Stage stage = new Stage();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://www.jd.com/");
        Scene scene = new Scene(webView);
        stage.setScene(scene);
        stage.show();
    }
        public  void shouye() throws Exception {
        switchView("default.fxml");
        }

    public void newGoodsStage() throws Exception {
        Stage addGoodsStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_goods.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        AddGoodsController addBookController = fxmlLoader.getController();
        addBookController.setGoodsData(goodsData);
        addGoodsStage.setTitle("新增商品界面");
        //界面大小不可变
        addGoodsStage.setResizable(false);
        addGoodsStage.setScene(scene);
        addGoodsStage.show();
    }

    public void addType() {
        //创建一个输入对话框
        TextInputDialog dialog = new TextInputDialog("新类别");
        dialog.setTitle("商品类别");
        dialog.setHeaderText("新增商品类别");
        dialog.setContentText("请输入商品类别名称:");
        Optional<String> result = dialog.showAndWait();

        //确认输入了内容
        if (result.isPresent()) {
            //获得输入的内容
            String typeName = result.get();
            //创建一个Type对象，插入数据库，并返回主键
            Type type = new Type();
            type.setTypeName(typeName);
            long id = 0;
            id = typeService.addType(type);
            type.setId(id);
            //加入ObservableList，刷新模型视图，不用重新查询数据库也可以立刻看到结果
            typeData.add(type);
        }
    }


    private void showVip(List<Vip> vipList) {
        //移除之前的记录
        vipPane.getChildren().clear();
        for (Vip vip : vipList) {
            HBox hBox = new HBox();
            hBox.setPrefSize(300, 300);
            hBox.getStyleClass().add("box");
            hBox.setSpacing(30);
            // 垂直盒子
            VBox rightBox = new VBox();
            rightBox.setSpacing(15);
            Label nameLabel = new Label(vip.getName());
            nameLabel.getStyleClass().add("font-title");
            Label sexLabel = new Label(vip.getSex());
            Label mobileLabel = new Label(vip.getMobile());
            Label numberLabel = new Label(vip.getVipNumber());
            Label dateLabel = new Label(vip.getJoinDate().toString());
            Button delBtn = new Button("删 除");
            delBtn.getStyleClass().add("warning-theme");
            rightBox.getChildren().addAll(nameLabel, sexLabel, mobileLabel, numberLabel, dateLabel);
            hBox.getChildren().addAll(rightBox);
            vipPane.getChildren().add(hBox);
            //删除按钮事件
            delBtn.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setContentText("确定要删除这行记录吗? ");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    long id = vip.getId();
                    //删除掉这行记录
                    vipService.deleteVip(id);
                    //从流式面板移除当前这个人的布局
                    vipPane.getChildren().remove(hBox);
                }
            });
        }
    }




    private void switchView(String fileName) throws Exception {
        //清除主面板之前内容
        ObservableList<Node> list = mainContainer.getChildren();
        mainContainer.getChildren().removeAll(list);
        //读取新的布局文件加入主面板
        AnchorPane anchorPane =  new FXMLLoader(getClass().getResource("/fxml/" +fileName)).load();
        mainContainer.getChildren().add(anchorPane);

    }

}



