package com.euroclinic.hellenicclinic.controller;

import com.euroclinic.hellenicclinic.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppointmentController {

    @FXML private ComboBox<Doctor> doctorComboBox;
    @FXML private ComboBox<Patient> patientComboBox;
    @FXML private DatePicker datePicker;
    @FXML private TextField timeField; // e.g., where the user types "14:30"
    @FXML private Label statusLabel;   // To show "Success!" or "Double Booked!" text

    private ClinicManager manager;

    public void setManager(ClinicManager manager) {
        this.manager = manager;
    }
}