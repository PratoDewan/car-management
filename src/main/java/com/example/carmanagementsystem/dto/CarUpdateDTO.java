package com.example.carmanagementsystem.dto;

public class CarUpdateDTO {
        private String brand;
        private String name;
        private String regiNo;
        private String availability;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegiNo() {
        return regiNo;
    }

    public void setRegiNo(String regiNo) {
        this.regiNo = regiNo;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
