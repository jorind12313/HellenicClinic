package com.euroclinic.hellenicclinic.models;

import com.euroclinic.hellenicclinic.models.Patient;
import com.euroclinic.hellenicclinic.models.Doctor;
import com.euroclinic.hellenicclinic.models.Appointment;
import com.euroclinic.hellenicclinic.util.FileHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClinicManager {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    public ClinicManager() {
        this.patients = FileHandler.loadPatients();
        this.doctors = FileHandler.loadDoctors();
        this.appointments = FileHandler.loadAppointments(this.doctors, this.patients);

        if (this.patients == null) this.patients = new ArrayList<>();
        if (this.doctors == null) this.doctors = new ArrayList<>();
        if (this.appointments == null) this.appointments = new ArrayList<>();
    }

    public List<Patient> getPatients() { return patients; }
    public List<Doctor> getDoctors() { return doctors; }
    public List<Appointment> getAppointments() { return appointments; }

    public void addPatient(Patient patient) {
        patients.add(patient);
        FileHandler.savePatients(new ArrayList<>(patients));
        System.out.println("Data flushed to patients.csv");
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        FileHandler.saveDoctors(new ArrayList<>(doctors));
        System.out.println("Data flushed to doctors.csv");
    }

    public boolean scheduleAppointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
        for (Appointment appt : appointments) {
            if (appt.getDoctor().equals(doctor) && appt.getAppointmentDateTime().equals(dateTime)) {
                System.out.println("Booking failed: Double-booked slot!");
                return false;
            }
        }

        Appointment newApp = new Appointment(doctor, patient, dateTime);
        appointments.add(newApp);

        FileHandler.saveAppointments(new ArrayList<>(appointments));
        System.out.println("Data flushed to appointments.csv");
        return true;
    }
}