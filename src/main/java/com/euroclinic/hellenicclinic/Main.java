package com.euroclinic.hellenicclinic.util;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/euroclinic/hellenicclinic/MainWindow.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        primaryStage.setTitle("Hellenic Clinic Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}