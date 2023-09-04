package com.example.carmanagementsystem.controller;

import com.example.carmanagementsystem.dto.CarUpdateDTO;
import com.example.carmanagementsystem.model.Car;
import com.example.carmanagementsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAll() {
        return new ResponseEntity<>(carService.getAllCar(), HttpStatus.OK);
    }
    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Car>> getCarById(@RequestParam int id)
            throws IllegalArgumentException{
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }
    @GetMapping("find-by-brand")
    public ResponseEntity<List<Car>> getCarByBrand(@RequestParam String brand) {
        return new ResponseEntity<>(carService.findCarByBrand(brand), HttpStatus.OK);
    }
    @GetMapping("find-by-availability")
    public ResponseEntity<List<Car>> getCarByAvailability(@RequestParam String status){
        return new ResponseEntity<>(carService.findCarByAvailability(status), HttpStatus.OK);
    }
    @GetMapping("find-by-brand-status")
    public ResponseEntity<List<Car>> getCarByBrandAndStatus(@RequestParam String brand, @RequestParam String status){
        return new ResponseEntity<>(carService.findCarByBrandAndAvailability(brand,status),HttpStatus.OK);
    }
    @PostMapping("/add-car")
    public ResponseEntity<String> saveCar(@RequestBody Car car){
        carService.saveCar(car);
        return new ResponseEntity<>("Successfully inserted!", HttpStatus.OK);
    }
    @DeleteMapping("/delete-car")
    public ResponseEntity<String> deleteCar(@RequestParam int id){
        carService.deleteCar(id);
        return new ResponseEntity<>("Successfully deleted!", HttpStatus.OK);
    }
    @PutMapping("/update-car/{id}")
    public ResponseEntity<String> updateCar(@PathVariable int id, @RequestBody CarUpdateDTO carUpdateDTO) {
        carService.updateCar(id, carUpdateDTO);
        return new ResponseEntity<>("Successfully updated!", HttpStatus.OK);
    }
}
