package com.ironhack.peopleservice.dto;

import javax.validation.constraints.NotNull;

public class PeopleDto {

    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;

    public PeopleDto() {
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
