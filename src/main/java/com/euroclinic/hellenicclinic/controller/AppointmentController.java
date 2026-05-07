package com.euroclinic.hellenicclinic.controller;

import com.euroclinic.hellenicclinic.models.ClinicManager;
import com.euroclinic.hellenicclinic.models.Doctor;
import com.euroclinic.hellenicclinic.models.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentController {

    @FXML private ComboBox<Doctor> doctorComboBox;
    @FXML private ComboBox<Patient> patientComboBox;
    @FXML private DatePicker datePicker;
    @FXML private TextField timeField;
    @FXML private Label statusLabel;

    private ClinicManager manager;

    public void setManager(ClinicManager manager) {
        this.manager = manager;
        populateDropdowns();
    }

    private void populateDropdowns() {
        if (manager != null) {
            doctorComboBox.getItems().addAll(manager.getDoctors());
            patientComboBox.getItems().addAll(manager.getPatients());
        }
    }

    @FXML
    public void handleScheduleAppointment() {
        Doctor selectedDoc = doctorComboBox.getValue();
        Patient selectedPat = patientComboBox.getValue();
        LocalDate date = datePicker.getValue();
        String timeRaw = timeField.getText();

        // 1. Validation check
        if (selectedDoc == null || selectedPat == null || date == null || timeRaw.isEmpty()) {
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText("Please fill out all fields!");
            return;
        }

        try {

            LocalTime time = LocalTime.parse(timeRaw, DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime appointmentDateTime = LocalDateTime.of(date, time);


            boolean success = manager.scheduleAppointment(selectedDoc, selectedPat, appointmentDateTime);

            if (success) {
                statusLabel.setStyle("-fx-text-fill: green;");
                statusLabel.setText("Appointment Booked Successfully!");


                timeField.clear();
                datePicker.setValue(null);
            } else {
                statusLabel.setStyle("-fx-text-fill: red;");
                statusLabel.setText("Double-booked! Time slot unavailable.");
            }

        } catch (Exception e) {
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText("Invalid Time format! Use HH:mm (e.g. 14:30)");
        }
    }
}