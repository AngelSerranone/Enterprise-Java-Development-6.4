package com.ironhack.edgepersonadvertisementsservice.dto;

import javax.validation.constraints.NotNull;

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