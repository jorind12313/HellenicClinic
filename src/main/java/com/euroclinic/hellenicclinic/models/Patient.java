package com.euroclinic.hellenicclinic.models;


public class Patient extends Person{
    String medicalHistory;

    public Patient (String id, String name, String phone, String medicalHistory) {
      super(id, name, phone);
      this.medicalHistory = medicalHistory;
    }
}
