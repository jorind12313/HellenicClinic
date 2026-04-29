package com.euroclinic.hellenicclinic.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClinicManager {
  private ArrayList<Doctor> doctors;
  private ArrayList<Patient> patients;
  private ArrayList<Appointment> appointments;


  public ClinicManager(){
    doctors = new ArrayList<>();
    patients = new ArrayList<>();
    appointments = new ArrayList<>();
  }

  //getters
  public ArrayList<Doctor> getDoctors() {
        return doctors;
  }
  public ArrayList<Patient> getPatients(){
      return patients;
  }
  public ArrayList<Appointment> getAppointments() {
        return appointments;
  }

  //methods for arraylists
  public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
  }
  public void setPatients(ArrayList<Patient> patients) {
      this.patients = patients;
  }


  public boolean scheduleAppointment(Doctor doctor, Patient patient, LocalDateTime dateTime) {
      for (Appointment appointment : appointments) {
          if (appointment.getDoctor().equals(doctor) && appointment.getDateTime().equals(dateTime)) {
            return false;
          }
      }
      Appointment newAppt = new Appointment(doctor, patient, dateTime);

      appointments.add(newAppt);
      return true;
  }
}
