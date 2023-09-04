package com.example.carmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="car")
@Component
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id")
    private Integer carId;
    @Column(name="brand")
    private String brand;
    @Column(name="name")
    private String name;
    @Column(name="regi_no")
    private String regiNo;
    @Column(name="availability")
    private String availability;
    @JsonIgnoreProperties("rentedCars")
    @ManyToMany(mappedBy = "rentedCars")
    private List<Customer> customers=new ArrayList<>();
    public Car() {

    }


    public Car(int carId, String brand, String name, String regiNo, String availability) {
        this.carId = carId;
        this.brand = brand;
        this.name = name;
        this.regiNo = regiNo;
        this.availability = availability;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
