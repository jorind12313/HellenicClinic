package com.euroclinic.hellenicclinic.controller;

import com.euroclinic.hellenicclinic.models.ClinicManager;
import com.euroclinic.hellenicclinic.models.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatientController {


    @FXML private TextField nameField;
    @FXML private TextField phoneField;
    @FXML private TextField historyField;

    private ClinicManager manager;

    public void setManager(ClinicManager manager) {
        this.manager = manager;
    }

    @FXML
    public void handleSavePatient() {

        String name = nameField.getText();
        String phone = phoneField.getText();
        String history = historyField.getText();

        if (name.isEmpty() || phone.isEmpty()) {
            System.out.println("Please fill in the Name and Phone!");
            return;
        }

        String uniqueId = "PAT-" + System.currentTimeMillis();

        Patient newPatient = new Patient(uniqueId, name, phone, history);

        manager.addPatient(newPatient);
        System.out.println("Patient Saved: " + name + " (ID: " + uniqueId + ")");

        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}