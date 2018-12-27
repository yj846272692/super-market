package com.soft1841.sm.controller;

import com.soft1841.sm.service.AdminService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 管理员登陆界面
 * @author 杨晶
 * 208-12-24
 */

public class AdminController {
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    private AdminService adminService = ServiceFactory.getAdminServiceInstance();
    public void adminLogin()throws Exception {
        String account = user.getText().trim();
        String password1 =password.getText().trim();
        //调用Service登录功能
        boolean flag = adminService.login(account,password1);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        if (flag) {
            alert.setContentText("登录成功,欢迎进入666后台管理~");
            alert.showAndWait();
            Stage mainStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            BorderPane root = fxmlLoader.load();
            Scene scene =  new Scene(root);
            scene.getStylesheets().addAll("/css/style.css");
            mainStage.setTitle("超市管理系统");
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
