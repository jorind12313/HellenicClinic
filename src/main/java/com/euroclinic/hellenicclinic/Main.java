package com.euroclinic.hellenicclinic; // Ensure this matches your package declaration

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        // We will add your UI code here later!
        primaryStage.setTitle("Hellenic Clinic Management");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}