package com.soft1841.sm.controller;


import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * 商品信息管理界面
 * @author 杨晶
 * 2018-12-26
 */

public class GoodsController implements Initializable {
//    布局文件中的表格视图对象，用来显示数据库中读取的所有商品信息
    @FXML
    private TableView<Goods> goodsTable;
    //布局文件中的下拉框组件对象，用来显示数据库中读取的所有商品类别
    @FXML
    private ComboBox<Type> typeComboBox;
    //布局文件中的输入文本框对象，用来输入搜索关键词
    @FXML
    private TextField keywordsField;
    //商品模型数据集合，可以实时相应数据变化，无需刷新
    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();
    //商品类型模型数据集合
    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    //商品Service对象，从Service工厂获得
    private GoodsService goodsService = ServiceFactory.getGoodsServiceInstance();

    //类别TypeService对象
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    //商品集合，存放数据库表t_goods各种查询的结果
    private List<Goods> goodsList = null;
    //类别集合，存放数据库类别表查询结果
    private List<Type> typeList = null;
    //表格中的编辑列
    private TableColumn<Goods ,Goods> editCol = new TableColumn<>("操作");
    //表格中的删除列
    private TableColumn<Goods ,Goods> delCol = new TableColumn<>("操作");

    /**
     * 初始化方法，通过调用对图书表格和列表下拉框的两个封装方法，实现数据初始化
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initComBox();
    }
    //表格初始化方法
    private void initTable() {
        //水平方向不显示滚动条，表格的列宽会均匀分布
        goodsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //1.调用查询所有图书的方法，
        goodsList = goodsService.getAllGoods();
        //将实体集合作为参数，调用显示数据的方法，可以在界面的表格中显示商品模型集合的值
        showGoodsData(goodsList);
        //2.编辑列的相关设置
        editCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        editCol.setCellFactory(param -> new TableCell<Goods, Goods>() {
            //通过ComponentUtil工具类的静态方法，传入按钮文字和样式，获得一个按钮对象
            private final Button editButton = ComponentUtil.getButton("编辑", "blue-theme");

            @Override
            protected void updateItem(Goods goods, boolean empty) {
                super.updateItem(goods, empty);
                if (goods == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(editButton);
                //点击编辑按钮，弹出窗口，输入需要修改的商品价格
                editButton.setOnAction(event -> {
                    TextInputDialog dialog = new TextInputDialog("请输入价格");
                    dialog.setTitle("商品修改界面");
                    dialog.setHeaderText(goods.getName());
                    dialog.setContentText("请输入新的价格:");
                    Optional<String> result = dialog.showAndWait();
                    //确认输入了内容，避免NPE
                    if (result.isPresent()) {
                        //获取输入的新价格并转化成Double数据
                        String priceString = result.get();
                        goods.setPrice(Double.parseDouble(priceString));
                        //更新图书信息
                        goodsService.updateGoods(goods);
                    }
                });
            }
        });
        //将编辑列加入商品表格
        goodsTable.getColumns().add(editCol);
        //3.删除列的相关设置
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Goods, Goods>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");

            @Override
            protected void updateItem(Goods goods, boolean empty) {
                super.updateItem(goods, empty);
                if (goods == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                //点击删除按钮，需要将这一行从表格移除，同时从底层数据库真正删除
                deleteButton.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认框");
                    alert.setHeaderText(goods.getName());
                    alert.setContentText("确定要删除这行记录吗?");
                    Optional<ButtonType> result = alert.showAndWait();
                    //点击了确认按钮，执行删除操作，同时移除一行模型数据
                    if (result.get() == ButtonType.OK) {
                        goodsData.remove(goods);
                        goodsService.deleteGoods(goods.getId());
                    }
                });
            }
        });
        //将删除列加入图书表格
        goodsTable.getColumns().add(delCol);
        //4.商品表格双击事件,双击弹出显示商品详情的界面
        goodsTable.setRowFactory(tv -> {
            TableRow<Goods> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                //判断鼠标双击了一行
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    //获得该行的商品ID属性
                    long id = row.getItem().getId();
                    //根据id查询到商品的完整信息
                    Goods goods = goodsService.getGoods(id);
                    //创建一个新的商品详情界面窗口
                    Stage goodsInfoStage = new Stage();
                    goodsInfoStage.setTitle("商品详情界面");
                    //用VBox显示具体商品信息
                    VBox vBox = new VBox();
                    vBox.setSpacing(10);
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setPrefSize(600, 400);
                    vBox.setPadding(new Insets(10, 10, 10, 10));
                    Label nameLabel = new Label(goods.getName());
                    nameLabel.getStyleClass().add("font-title");
                    Label barcodeLabel = new Label(goods.getBarCode());
                    ImageView goodsImgView = new ImageView(new Image(goods.getPicture()));
                    goodsImgView.setFitHeight(200);
                    goodsImgView.setFitWidth(200);
                    Label descriptionLabel = new Label(goods.getDescription());
                    descriptionLabel.setPrefWidth(400);
                    descriptionLabel.setWrapText(true);
                    descriptionLabel.getStyleClass().add("box");
                    descriptionLabel.setAlignment(Pos.CENTER);
                    vBox.getChildren().addAll(nameLabel, barcodeLabel, goodsImgView, descriptionLabel);
                    Scene scene = new Scene(vBox, 640, 480);
                    goodsInfoStage.setScene(scene);
                    goodsInfoStage.show();
                }
            });
            return row;
        });
    }

    //下拉框初始化方法
    private void initComBox() {
        //1.到数据库查询所有的类别
        typeList = typeService.getAllTypes();
        //2.将typeList集合加入typeData模型数据集合
        typeData.addAll(typeList);
        //3.将数据模型设置给下拉框
        typeComboBox.setItems(typeData);
        //4.下拉框选择事件监听，根据选择不同的类别，商品表格中会过滤出该类别的商品
        typeComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            //移除掉之前的数据
            goodsTable.getItems().removeAll(goodsData);
            //根据选中的类别查询该类别所有商品
            goodsList = goodsService.getGoodsByTypeId(newValue.getId());
            //重新显示数据
            showGoodsData(goodsList);
        }
        );
    }
    //显示商品表格数据的方法
    private void showGoodsData(List<Goods> goodsList) {
        goodsData.addAll(goodsList);
        goodsTable.setItems(goodsData);
    }
    //弹出新增商品界面方法
    public void newGoodsStage() throws Exception {
        Stage addGoodsStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_goods.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        AddGoodsController addBookController = fxmlLoader.getController();
        addBookController.setGoodsData(goodsData);
        addGoodsStage.setTitle("新增图书界面");
        //界面大小不可变
        addGoodsStage.setResizable(false);
        addGoodsStage.setScene(scene);
        addGoodsStage.show();
    }
    //根据关键词搜索方法
    public void search() {
        goodsTable.getItems().removeAll(goodsData);
        //获得输入的查询关键字
        String keywords = keywordsField.getText().trim();
        goodsList = goodsService.getGoodsLike(keywords);
        showGoodsData(goodsList);
    }






}
