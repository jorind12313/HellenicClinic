package com.euroclinic.hellenicclinic.controller;

import com.euroclinic.hellenicclinic.models.ClinicManager;
import com.euroclinic.hellenicclinic.models.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatientController {

    // 1. The FXML variables (Must match Scene Builder exactly!)
    @FXML private TextField nameField;
    @FXML private TextField phoneField;
    @FXML private TextField historyField;

    // 2. A place to store the "Brain"
    private ClinicManager manager;

    public void setManager(ClinicManager manager) {
        this.manager = manager;
    }

    // 3. The method triggered by your Save Button
    @FXML
    public void handleSavePatient() {
        // Grab what the user typed
        String name = nameField.getText();
        String phone = phoneField.getText();
        String history = historyField.getText();

        // Check if they left things blank
        if (name.isEmpty() || phone.isEmpty()) {
            System.out.println("Please fill in the Name and Phone!");
            return; // Stops the method here so it doesn't save a blank patient
        }

        // Auto-Generate a unique ID using the current time in milliseconds!
        String uniqueId = "PAT-" + System.currentTimeMillis();

        // Create the new Patient object
        Patient newPatient = new Patient(uniqueId, name, phone, history);

        // Save them to our main ClinicManager list
        manager.addPatient(newPatient);
        System.out.println("Patient Saved: " + name + " (ID: " + uniqueId + ")");

        // Close the pop-up window automatically
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}