module com.euroclinic.hellenicclinic {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.euroclinic.hellenicclinic.util to javafx.graphics, javafx.fxml;
    exports com.euroclinic.hellenicclinic.util;

    opens com.euroclinic.hellenicclinic.controller to javafx.fxml;
    exports com.euroclinic.hellenicclinic.controller;

    opens com.euroclinic.hellenicclinic.models to javafx.base;
    exports com.euroclinic.hellenicclinic.models;
}