package com.soft1841.sm.controller;

import com.soft1841.sm.service.SellerService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
 public class LoginController {
     @FXML
     private TextField accountField;
     @FXML
     private PasswordField passwordField;

     private SellerService sellerService = ServiceFactory.getSellerServiceInstance();

     public void login() throws Exception {
         String account = accountField.getText().trim();
         String password = passwordField.getText().trim();
         //调用service的登录功能
         boolean flag = sellerService.login(account, password);
         if (flag) {
             Stage mainStage = new Stage();
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/seller.fxml"));
             BorderPane root = fxmlLoader.load();
             Scene scene = new Scene(root);
             mainStage.setTitle("supermarket system");
             mainStage.getIcons().add(new Image("/img/logo.png"));
             mainStage.setMaximized(true);
             mainStage.setScene(scene);
             mainStage.show();
             Stage loginStage = (Stage) accountField.getScene().getWindow();
             loginStage.close();
         } else {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("提示");
             alert.setContentText("账号或密码错误，登录失败!");
             alert.showAndWait();
         }
     }
 }