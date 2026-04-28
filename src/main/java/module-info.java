module com.euroclinic.hellenicclinic {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.euroclinic.hellenicclinic to javafx.fxml;
    exports com.euroclinic.hellenicclinic;
}