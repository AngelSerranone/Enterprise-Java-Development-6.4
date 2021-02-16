package com.ironhack.advertisementsservice.dto;

import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AdvertisementDto {

    @NotNull
    private String vendor;

    @NotNull
    private String text;

    public AdvertisementDto() {
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
