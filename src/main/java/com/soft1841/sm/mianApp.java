package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mianApp  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("控制空心");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root  = fxmlLoader.load();
        Scene scene = new Scene(root,1000,800);
        scene.getStylesheets().addAll("/css/stye.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
