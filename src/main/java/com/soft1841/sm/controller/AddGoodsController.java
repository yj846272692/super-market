package com.soft1841.sm.controller;

import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 增加商品的Controller
 * @author 杨晶
 * 2018-12-26
 */

public class AddGoodsController  implements Initializable {
    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();
    public ObservableList<Goods> getGoodsData() {
        return goodsData;
    }
    public void setGoodsData(ObservableList<Goods> goodsData) {
        this.goodsData = goodsData;
    }
    @FXML
    private ComboBox<Type> goodsType;
    @FXML
    private TextField goodsName,goodsBarcode,goodsPrice,goodsPicture;
    @FXML
    private TextArea goodsDescription;

    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private GoodsService goodsService = ServiceFactory.getGoodsServiceInstance();
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    private List<Type> typeList = null;
    private Long typeId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeList = typeService.getAllTypes();
        typeData.addAll(typeList);
        goodsType.setItems(typeData);
        goodsType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            typeId = newValue.getId();
        }
        );
    }

    public void addGoods() {
        String name = goodsName.getText();
        String barCode =goodsBarcode.getText();
        String price = goodsPrice.getText();
        String picture = goodsPicture.getText();
        String description = goodsDescription.getText();
        Goods goods = new Goods();
        goods.setTypeId(typeId);
        goods.setName(name);
        goods.setBarCode(barCode);
        goods.setPrice(Double.parseDouble(price));
        goods.setPicture(picture);
        goods.setDescription(description);
        long id = goodsService.addGoods(goods);
        goods.setId(id);
        this.getGoodsData().add(goods);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("新增图书成功!");
        alert.showAndWait();
        Stage stage = (Stage) goodsName.getScene().getWindow();
        stage.close();


    }
}
