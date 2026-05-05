package com.euroclinic.hellenicclinic.controller;

import com.euroclinic.hellenicclinic.models.ClinicManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {

    private ClinicManager manager;

    @FXML
    public void initialize() {
        // This automatically triggers your file loading logic when the app starts!
        manager = new ClinicManager();
        System.out.println("Dashboard Loaded! ClinicManager is ready.");
    }

    @FXML
    public void openPatientForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/euroclinic/hellenicclinic/PatientForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 350, 400);

            // Hand the "brain" over to the popup window so it can save data
            PatientController popupController = fxmlLoader.getController();
            popupController.setManager(this.manager);

            Stage popupStage = new Stage();
            popupStage.setTitle("Add New Patient");
            popupStage.setScene(scene);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.showAndWait();

        } catch (Exception e) {
            System.out.println("Error loading Patient window: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void openDoctorForm() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/euroclinic/hellenicclinic/DoctorForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 350, 400);
            DoctorController popupController = fxmlLoader.getController();
            popupController.setManager(this.manager);
            Stage popupStage = new Stage();
            popupStage.setTitle("Add New Doctor");
            popupStage.setScene(scene);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.showAndWait();

        } catch (Exception e) {
            System.out.println("Error loading Doctor window: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void openAppointmentForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/euroclinic/hellenicclinic/AppointmentForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 450);

            Stage popupStage = new Stage();
            popupStage.setTitle("Book Appointment");
            popupStage.setScene(scene);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.showAndWait();

        } catch (Exception e) {
            System.out.println("Error loading Appointment window: " + e.getMessage());
            e.printStackTrace();
        }
    }
}