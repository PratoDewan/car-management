package com.example.carmanagementsystem.service;

import com.example.carmanagementsystem.dto.CarUpdateDTO;
import com.example.carmanagementsystem.model.Car;
import com.example.carmanagementsystem.model.Customer;
import com.example.carmanagementsystem.repository.CarRepository;
import com.example.carmanagementsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public List<Car> getAllCar(){
        return carRepository.findAll();
    }
    public Optional<Car> getCarById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }

        Optional<Car> carOptional = carRepository.findById(id);

        if (carOptional.isEmpty()) {
            throw new NoSuchElementException("car");
        }

        return carOptional;
    }
    public void saveCar(Car car){
        carRepository.save(car);
    }
    public void deleteCar(int id){
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        Optional<Car> carOptional = carRepository.findById(id);

        if (carOptional.isEmpty()) {
            throw new NoSuchElementException("car");
        }
        carRepository.deleteById(id);
    }
    public void updateCar(int id, CarUpdateDTO carUpdateDTO) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            if(carUpdateDTO.getBrand()!=null) {
                car.setBrand(carUpdateDTO.getBrand());
            }
            if(carUpdateDTO.getName()!=null){
                car.setName(carUpdateDTO.getName());
            }
            if(carUpdateDTO.getRegiNo()!=null) {
                car.setRegiNo(carUpdateDTO.getRegiNo());
            }
            if(carUpdateDTO.getAvailability()!=null) {
                car.setAvailability(carUpdateDTO.getAvailability());
            }
            carRepository.save(car);
        }
    }
    public List<Car> findCarByBrand(String brand){
        List<Car> carList = carRepository.findByBrand(brand);
        if(carList.isEmpty()){
            throw new EmptyResultDataAccessException("No Data",1);
        }
        return carList;
    }
    public List<Car> findCarByAvailability(String status){
        List<Car> carList = carRepository.findByAvailability(status);
        if(carList.isEmpty()){
            throw new EmptyResultDataAccessException("No Data",1);
        }
        return carList;
    }
    public List<Car> findCarByBrandAndAvailability(String brand, String status){
        List<Car> carList = carRepository.findByBrandAndAvailability(brand,status);
        if(carList.isEmpty()){
            throw new EmptyResultDataAccessException("No Data",1);
        }
        return carList;
    }
}
