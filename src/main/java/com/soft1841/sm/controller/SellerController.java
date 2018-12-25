package com.soft1841.sm.controller;

import com.soft1841.sm.service.AdminService;
import com.soft1841.sm.service.SellerService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SellerController {
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    private SellerService sellerService = ServiceFactory.getSellerServiceInstance();
    public void sellerLogin()throws Exception {
        String account = user.getText().trim();
        String password1 =password.getText().trim();
        //调用Service登录功能
        boolean flag = sellerService.login(account,password1);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        if (flag) {
            alert.setContentText("登录成功！");
            alert.showAndWait();
            Stage mainStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainseller.fxml"));
            AnchorPane root = fxmlLoader.load();
            Scene scene =  new Scene(root);
            mainStage.setTitle("收银员界面");
            mainStage.setMaximized(true);
            mainStage.setScene(scene);
            mainStage.show();
            Stage loginStage = (Stage) user.getScene().getWindow();
            loginStage.close();
        }else {
            alert.setContentText("账号密码错误，请重新登录！");
            alert.showAndWait();
        }
    }
}
