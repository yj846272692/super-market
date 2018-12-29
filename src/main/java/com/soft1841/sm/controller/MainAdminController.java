package com.soft1841.sm.controller;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.html.HTMLDocument;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * 后台主界面 控制器
 * @author 杨晶
 * 2018-12-25
 */

public class MainAdminController implements Initializable {
    @FXML
    private StackPane mainContainer;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    private void switchView(String fileName) throws Exception {
        //清除主面板之前内容
        ObservableList<Node> list = mainContainer.getChildren();
        mainContainer.getChildren().removeAll(list);
        //读取新的布局文件加入主面板
        AnchorPane anchorPane =  new FXMLLoader(getClass().getResource("/fxml/" +fileName)).load();
        mainContainer.getChildren().add(anchorPane);


    }
}



