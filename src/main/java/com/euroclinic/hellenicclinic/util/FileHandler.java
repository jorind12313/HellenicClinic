package com.euroclinic.hellenicclinic.util;

import com.euroclinic.hellenicclinic.models.Appointment;
import com.euroclinic.hellenicclinic.models.Doctor;
import com.euroclinic.hellenicclinic.models.Patient;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileHandler {

    public void saveAppointments(ArrayList<Appointment> appointments) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("appointments.csv"));


            for (Appointment appt : appointments) {

                String line = appt.toCSV();
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            System.out.println("Appointments saved successfully!");

        }
        catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public ArrayList<Appointment> loadAppointments(ArrayList<Doctor> doctors, ArrayList<Patient> patients) {
        ArrayList<Appointment> loadedAppointments = new ArrayList<>();

        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("appointments.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String docId = parts[0];
            String patId = parts[1];
            java.time.LocalDateTime dateTime = java.time.LocalDateTime.parse(parts[2]);

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
            reader.close();
            System.out.println("Appointments loaded successfully!");

        }
        catch (java.io.FileNotFoundException e)  {
            System.out.println("Appointment file not found!");
        }
        catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    return loadedAppointments;}
}