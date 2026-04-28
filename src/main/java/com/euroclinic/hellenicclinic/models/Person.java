package com.euroclinic.hellenicclinic.models;

public class Person {
    String name;
    String phone;
    String id;
    public Person(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;

    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
}
