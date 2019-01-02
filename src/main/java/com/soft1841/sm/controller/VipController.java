package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Vip;
import com.soft1841.sm.service.VipService;
import com.soft1841.sm.utils.ServiceFactory;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.net.URL;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * 会员管理 控制器
 */

public class VipController implements Initializable {

    private VipService vipService = ServiceFactory.getVipDAOInstance();
    private List<Vip> vipList = new ArrayList<>();
    @FXML
    private FlowPane vipPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vipList = vipService.getAllVip();
        showVip(vipList);
    }
    //新增会员方法
    public  void  addVip(){
        Vip vip = new Vip();
        Stage stage = new Stage();
        stage.setTitle("新增会员界面");
        //一个垂直布局 放各种组件
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10,10,10,10));
        Label infoLabel = new Label("请输入会员信息：");
        infoLabel.setPrefWidth(600);
        infoLabel.setMinHeight(60);
        infoLabel.setAlignment(Pos.CENTER);
        infoLabel.getStyleClass().addAll("gray-theme","font-title");
        TextField nameLabel = new TextField();
        nameLabel.setPromptText("请输入姓名");
        TextField mobileLabel = new TextField();
        mobileLabel.setPromptText("请输入手机号");
        TextField numberLabel = new TextField();
        numberLabel.setPromptText("请输入会员号");
        //性别选项
        HBox roleBox = new HBox();
        roleBox.setSpacing(20);
        ToggleGroup group = new ToggleGroup();
        RadioButton manButton = new RadioButton("男");
        manButton.setToggleGroup(group);
        manButton.setSelected(true);
        manButton.setUserData("男");
        RadioButton womenButton = new RadioButton("女");
        womenButton.setToggleGroup(group);
        womenButton.setUserData("女");
        roleBox.getChildren().addAll(manButton,womenButton);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                //设置选中的性别
                System.out.println(group.getSelectedToggle().getUserData().toString());
                vip.setSex(group.getSelectedToggle().getUserData().toString());
            }
        });
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        //新增按钮
        FlowPane flowPane = new FlowPane();
        Button addBtn =  new Button("新增");
        addBtn.setPrefWidth(150);
        addBtn.setAlignment(Pos.BOTTOM_CENTER);
        addBtn.getStyleClass().addAll("gray-theme" , "btn-radius");
        flowPane.getChildren().add(addBtn);
        flowPane.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(infoLabel,nameLabel,mobileLabel,numberLabel,roleBox,datePicker,addBtn);
        Scene scene =  new Scene(vBox ,450,400);
        scene.getStylesheets().add("css/style.css");
        stage.setScene(scene);
        stage.show();
        //点击增加 ,写入数据库
        addBtn.setOnAction(event -> {
            String nameString =  nameLabel.getText().trim();
            String mobileString =  mobileLabel.getText().trim();
            String numberString =  numberLabel.getText().trim();
            String dateString =  datePicker.getEditor().getText();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date joinDate = null;
            try {
                joinDate = df.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            vip.setName(nameString);
            vip.setVipNumber(numberString);
            vip.setMobile(mobileString);
            System.out.println(vip.getName()+vip.getSex()+vip.getMobile());
            vipService.addVip(vip);
            stage.close();
            //重新读取数据
            vipList = vipService.getAllVip();
            showVip(vipList);
        });
    }
    private void showVip(List<Vip> vipList) {
        //移除之前的记录
        vipPane.getChildren().clear();
        for (Vip vip : vipList) {
            HBox hBox = new HBox();
            hBox.setPrefSize(170, 20);
            hBox.getStyleClass().add("box");
            hBox.setSpacing(30);
            // 垂直盒子
            VBox rightBox = new VBox();
            rightBox.setSpacing(10);
            Label nameLabel = new Label(vip.getName());
            nameLabel.getStyleClass().add("font-title");
            Label sexLabel = new Label(vip.getSex());
            Label mobileLabel = new Label(vip.getMobile());
            Label numberLabel = new Label(vip.getVipNumber());
            Button delBtn = new Button("删除");
            delBtn.getStyleClass().add("gray-theme");
            delBtn.setAlignment(Pos.BOTTOM_CENTER);
            rightBox.getChildren().addAll(nameLabel, sexLabel, mobileLabel,numberLabel,delBtn);
            hBox.getChildren().addAll(rightBox);
            vipPane.getChildren().add(hBox);
            //删除按钮事件
            delBtn.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setContentText("确定要删除这行记录吗?");
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




}