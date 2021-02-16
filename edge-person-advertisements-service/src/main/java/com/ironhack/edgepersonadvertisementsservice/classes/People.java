package com.ironhack.edgepersonadvertisementsservice.classes;

public class People {

    private Integer id;
    private String name;
    private String phoneNumber;

    public People() {
    }

    public People(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
