package com.euroclinic.hellenicclinic.models;


public class Patient extends Person{
    private String medicalHistory;

    public Patient (String id, String name, String phone, String medicalHistory) {
      super(id, name, phone);
      this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }
}
