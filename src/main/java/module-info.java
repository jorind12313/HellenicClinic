module com.euroclinic.hellenicclinic {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.euroclinic.hellenicclinic.util to javafx.graphics, javafx.fxml;
    exports com.euroclinic.hellenicclinic.util;

    // 2. Allow JavaFX to connect your buttons to your controllers
    opens com.euroclinic.hellenicclinic.controller to javafx.fxml;
    exports com.euroclinic.hellenicclinic.controller;

    // 3. Allow the JavaFX TableView to read your data later!
    opens com.euroclinic.hellenicclinic.models to javafx.base;
    exports com.euroclinic.hellenicclinic.models;
}