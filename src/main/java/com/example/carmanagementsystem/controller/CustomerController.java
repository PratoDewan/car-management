package com.example.carmanagementsystem.controller;

import com.example.carmanagementsystem.dto.CustomerUpdateDTO;
import com.example.carmanagementsystem.model.Customer;
import com.example.carmanagementsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Customer>> getCustomerById(@RequestParam int id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping("/add-customer")
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>("Successfully inserted!", HttpStatus.OK);
    }

    @DeleteMapping("/delete-customer")
    public ResponseEntity<String> deleteCustomer(@RequestParam int id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Successfully deleted!", HttpStatus.OK);
    }

    @PutMapping("/update-customer/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int id, @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        customerService.updateCustomer(id, customerUpdateDTO);
        return new ResponseEntity<>("Successfully updated!", HttpStatus.OK);
    }
    @PostMapping("/rent")
    public ResponseEntity<String> rentCar(@RequestParam int carId, @RequestParam int customerId)
         throws NoSuchFieldException {
        customerService.rentCar(carId, customerId);
        return new ResponseEntity<>("Successfully rented!", HttpStatus.OK);
    }
}

