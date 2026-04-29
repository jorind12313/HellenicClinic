package com.euroclinic.hellenicclinic.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {


    @FXML
    public void openPatientForm() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/euroclinic/hellenicclinic/PatientForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 350, 400);

            Stage popupStage = new Stage();
            popupStage.setTitle("Add New Patient");
            popupStage.setScene(scene);

            popupStage.initModality(Modality.APPLICATION_MODAL);

            popupStage.showAndWait();

        } catch (Exception e) {
            System.out.println("Could not load the window: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void openDoctorForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/euroclinic/hellenicclinic/DoctorForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 350, 400);

            Stage popupStage = new Stage();
            popupStage.setTitle("Add New Doctor");
            popupStage.setScene(scene);

            popupStage.initModality(Modality.APPLICATION_MODAL);

            popupStage.showAndWait();

        } catch (Exception e) {
            System.out.println("Could not load the Doctor window: " + e.getMessage());
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
            System.out.println("Could not load the Appointment window: " + e.getMessage());
            e.printStackTrace();
        }
    }
}