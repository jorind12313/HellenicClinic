package com.euroclinic.hellenicclinic.models;

public class Doctor extends Person{
    String specialty;

    public Doctor(String id, String name, String phone, String specialty){
        super(id, name, phone);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }
    @Override
    public String toString() {
        return "Dr. " + this.getName() + " (" + this.getSpecialty() + ")";
    }
}
