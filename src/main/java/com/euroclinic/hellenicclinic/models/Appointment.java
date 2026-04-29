package com.euroclinic.hellenicclinic.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {
   private LocalDateTime dateTime;
   private Doctor doctor;
   private Patient patient;


    public Appointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
            this.doctor = doctor;
            this.patient = patient;
            this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {
        return patient;
    }

    public String toCSV() {
        return doctor.getId() + "," + patient.getId() + "," + dateTime.toString();
    }
}
