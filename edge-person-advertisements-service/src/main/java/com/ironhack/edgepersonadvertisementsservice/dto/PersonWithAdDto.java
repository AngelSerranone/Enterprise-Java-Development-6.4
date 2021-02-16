package com.ironhack.edgepersonadvertisementsservice.dto;

import javax.validation.constraints.NotNull;

public class PersonWithAdDto {

    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String vendor;
    @NotNull
    private String text;

    public PersonWithAdDto() {
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
