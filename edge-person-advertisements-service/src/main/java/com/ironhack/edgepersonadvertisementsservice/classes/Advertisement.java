package com.ironhack.edgepersonadvertisementsservice.classes;

public class Advertisement {

    private Integer id;
    private String vendor;
    private String text;

    public Advertisement() {
    }

    public Advertisement(String vendor, String text) {
        setVendor(vendor);
        setText(text);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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