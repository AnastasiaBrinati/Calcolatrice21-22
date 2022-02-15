package com.example.calcolatrice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("calculator.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 350, 450);

        stage.setTitle("♡Calculator♡");
        stage.setScene(scene);

        stage.getIcons().add(new Image(MainClass.class.getResourceAsStream("heart.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
