package com.example.scenebuildercalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CalcApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalcApp.class.getResource("calc-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 413, 224);
        stage.getIcons().add(new Image(new File("images/calc_icon.png").toURI().toString()));
//        stage.setResizable(false);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}