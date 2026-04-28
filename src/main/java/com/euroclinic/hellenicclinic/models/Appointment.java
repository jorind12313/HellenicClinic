package com.euroclinic.hellenicclinic.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {
    LocalDateTime dateTime;
    Doctor doctor;
    Patient patient;


    public Appointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
            this.doctor = doctor;
            this.patient = patient;
            this.dateTime = dateTime;
    }
}
