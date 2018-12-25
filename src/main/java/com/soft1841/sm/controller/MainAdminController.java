package com.soft1841.sm.controller;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainAdminController implements Initializable {
    @FXML
    private StackPane mainContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public void listType() throws Exception {
        switchView("type.fxml");
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



