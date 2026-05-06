package com.euroclinic.hellenicclinic.models;

import com.euroclinic.hellenicclinic.models.Patient;
import com.euroclinic.hellenicclinic.models.Doctor;
import com.euroclinic.hellenicclinic.models.Appointment;
import com.euroclinic.hellenicclinic.util.FileHandler; // Crucial: Import your utility package!

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClinicManager {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    public ClinicManager() {
        // Load existing data from files right when the application boots up!
        this.patients = FileHandler.loadPatients();
        this.doctors = FileHandler.loadDoctors();
        this.appointments = FileHandler.loadAppointments(this.doctors, this.patients);

        // Fallback to empty lists if files don't exist yet
        if (this.patients == null) this.patients = new ArrayList<>();
        if (this.doctors == null) this.doctors = new ArrayList<>();
        if (this.appointments == null) this.appointments = new ArrayList<>();
    }

    public List<Patient> getPatients() { return patients; }
    public List<Doctor> getDoctors() { return doctors; }
    public List<Appointment> getAppointments() { return appointments; }

    // Call this whenever a patient is added!
    public void addPatient(Patient patient) {
        patients.add(patient);
        // Cast or pass as a generic List depending on how your utility is typed
        FileHandler.savePatients(new ArrayList<>(patients));
        System.out.println("Data flushed to patients.csv");
    }

    // Call this whenever a doctor is added!
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        FileHandler.saveDoctors(new ArrayList<>(doctors));
        System.out.println("Data flushed to doctors.csv");
    }

    public boolean scheduleAppointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
        // Simple double-booking check validation loop
        for (Appointment appt : appointments) {
            if (appt.getDoctor().equals(doctor) && appt.getAppointmentDateTime().equals(dateTime)) {
                System.out.println("Booking failed: Double-booked slot!");
                return false;
            }
        }

        Appointment newApp = new Appointment(doctor, patient, dateTime);
        appointments.add(newApp);

        // Save to file!
        FileHandler.saveAppointments(new ArrayList<>(appointments));
        System.out.println("Data flushed to appointments.csv");
        return true;
    }
}