package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 管理员主程序
 * @author 杨晶
 */

public class AdminApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("管理员登陆");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/admin.fxml"));
        Parent root  = fxmlLoader.load();
        Scene scene = new Scene(root,550,600);
        scene.getStylesheets().addAll("/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
