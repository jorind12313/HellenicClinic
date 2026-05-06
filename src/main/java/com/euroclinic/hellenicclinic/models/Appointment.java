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

    // 1. This fixes the ClinicManager double-booking error!
    public java.time.LocalDateTime getAppointmentDateTime() {
        // Note: If your private variable at the top of this file is just named 'dateTime',
        // change this to: return this.dateTime;
        return this.dateTime;
    }
}

