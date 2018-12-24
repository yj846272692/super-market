package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("管理员登陆");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/admin.fxml"));
        Parent root  = fxmlLoader.load();
        Scene scene = new Scene(root,1000,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
