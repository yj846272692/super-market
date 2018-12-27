package com.soft1841.sm.controller;


import com.soft1841.sm.dao.SellerGoodsDAO;
import com.soft1841.sm.entity.Goods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSellerController implements Initializable {
    @FXML
    private TableView<Goods> sellerGoodsTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void listGoods(ActionEvent event) {


    }
}
