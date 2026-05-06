package com.euroclinic.hellenicclinic.util;

import com.euroclinic.hellenicclinic.models.Appointment;
import com.euroclinic.hellenicclinic.models.Doctor;
import com.euroclinic.hellenicclinic.models.Patient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Define the exact path to your data folder so Java never gets lost!
    private static final String DATA_PATH = "src/main/java/com/euroclinic/hellenicclinic/data/";

    // ================= APPOINTMENTS =================

    public static void saveAppointments(List<Appointment> appointments) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_PATH + "appointments.csv"))) {
            for (Appointment appt : appointments) {
                writer.write(appt.toCSV());
                writer.newLine();
            }
            System.out.println("Appointments saved successfully!");
        } catch (Exception e) {
            System.out.println("Error saving appointments: " + e.getMessage());
        }
    }

    public static List<Appointment> loadAppointments(List<Doctor> doctors, List<Patient> patients) {
        List<Appointment> loadedAppointments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_PATH + "appointments.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                String docId = parts[0];
                String patId = parts[1];
                LocalDateTime dateTime = LocalDateTime.parse(parts[2]);

                Doctor foundDoctor = null;
                for (Doctor doc : doctors) {
                    if (doc.getId().equals(docId)) {
                        foundDoctor = doc;
                        break;
                    }
                }

                Patient foundPatient = null;
                for (Patient patient : patients) {
                    if (patient.getId().equals(patId)) {
                        foundPatient = patient;
                        break;
                    }
                }

                if (foundDoctor != null && foundPatient != null) {
                    Appointment appt = new Appointment(foundDoctor, foundPatient, dateTime);
                    loadedAppointments.add(appt);
                }
            }
            System.out.println("Appointments loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Appointment file not found, starting fresh.");
        } catch (Exception e) {
            System.out.println("Error loading appointments: " + e.getMessage());
        }
        return loadedAppointments;
    }

    // ================= PATIENTS =================

    public static void savePatients(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_PATH + "patients.csv"))) {
            for (Patient p : patients) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getPhone() + "," + p.getMedicalHistory());
                writer.newLine();
            }
            System.out.println("Patients saved successfully!");
        } catch (Exception e) {
            System.out.println("Error saving patients: " + e.getMessage());
        }
    }

    public static List<Patient> loadPatients() {
        List<Patient> loadedPatients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_PATH + "patients.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 4) continue;
                loadedPatients.add(new Patient(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Patients file not found, starting fresh.");
        } catch (Exception e) {
            System.out.println("Error loading patients: " + e.getMessage());
        }
        return loadedPatients;
    }

    // ================= DOCTORS =================

    public static void saveDoctors(List<Doctor> doctors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_PATH + "doctors.csv"))) {
            for (Doctor d : doctors) {
                writer.write(d.getId() + "," + d.getName() + "," + d.getSpecialty() + "," + d.getPhone());
                writer.newLine();
            }
            System.out.println("Doctors saved successfully!");
        } catch (Exception e) {
            System.out.println("Error saving doctors: " + e.getMessage());
        }
    }

    public static List<Doctor> loadDoctors() {
        List<Doctor> loadedDoctors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_PATH + "doctors.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 4) continue;
                loadedDoctors.add(new Doctor(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Doctors file not found, starting fresh.");
        } catch (Exception e) {
            System.out.println("Error loading doctors: " + e.getMessage());
        }
        return loadedDoctors;
    }
}