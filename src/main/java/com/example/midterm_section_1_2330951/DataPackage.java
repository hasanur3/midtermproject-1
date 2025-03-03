package com.example.midterm_section_1_2330951;

import java.time.LocalDate;

public class DataPackage {
    private String name;
    private float dataAmount;
    private String validity;
    private double price;
    private String availability;
    private LocalDate offerEnds;

    public DataPackage(String name, float dataAmount, String validity, double price, String availability, LocalDate offerEnds) {
        this.name = name;
        this.dataAmount = dataAmount;
        this.validity = validity;
        this.price = price;
        this.availability = availability;
        this.offerEnds = offerEnds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(float dataAmount) {
        this.dataAmount = dataAmount;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public LocalDate getOfferEnds() {
        return offerEnds;
    }

    public void setOfferEnds(LocalDate offerEnds) {
        this.offerEnds = offerEnds;
    }

    @Override
    public String toString() {
        return "DataPackage{" +
                "name='" + name + '\'' +
                ", dataAmount=" + dataAmount +
                ", validity='" + validity + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                ", offerEnds=" + offerEnds +
                '}';
    }
}
