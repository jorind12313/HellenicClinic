package com.euroclinic.hellenicclinic.controller;

import com.euroclinic.hellenicclinic.models.ClinicManager;
import com.euroclinic.hellenicclinic.models.Doctor;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DoctorController {

    @FXML private TextField nameField;
    @FXML private TextField specialtyField;
    @FXML private TextField phoneField;

    private ClinicManager manager;

    public void setManager(ClinicManager manager) {
        this.manager = manager;
    }

    @FXML
    public void handleSaveDoctor() {
        String name = nameField.getText();
        String specialty = specialtyField.getText();
        String phone = phoneField.getText();

        if (name.isEmpty() || specialty.isEmpty()) {
            System.out.println("Please fill in Name and Specialty!");
            return;
        }

        // Auto-Generate a unique ID for the doctor
        String uniqueId = "DOC-" + System.currentTimeMillis();

        Doctor newDoctor = new Doctor(uniqueId, name, specialty, phone);
        // Replace: manager.getDoctors().add(newDoctor);
        // With this:
        manager.addDoctor(newDoctor);

        System.out.println("Doctor Saved: " + name + " (ID: " + uniqueId + ")");

        // Close the window
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}