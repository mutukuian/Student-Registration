package com.example.schoolsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SchoolManagement extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SchoolManagement.class.getResource("school-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 530, 400);
        stage.initStyle(StageStyle.UNDECORATED);
//        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}