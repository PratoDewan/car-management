package com.example.carmanagementsystem.service;

import com.example.carmanagementsystem.dto.CarUpdateDTO;
import com.example.carmanagementsystem.dto.CustomerUpdateDTO;
import com.example.carmanagementsystem.model.Car;
import com.example.carmanagementsystem.model.Customer;
import com.example.carmanagementsystem.repository.CarRepository;
import com.example.carmanagementsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CarRepository carRepository;
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
    public Optional<Customer> getCustomerById(int id){
        if (id < 0) {
            throw new IllegalArgumentException();
        }

        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isEmpty()) {
            throw new NoSuchElementException("customer");
        }

        return customerOptional;
    }
    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void deleteCustomer(int id){
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isEmpty()) {
            throw new NoSuchElementException("customer");
        }
        carRepository.deleteById(id);
    }
    public void updateCustomer(int id, CustomerUpdateDTO customerUpdateDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            if(customerUpdateDTO.getFirstName()!=null) {
                customer.setFirstName(customerUpdateDTO.getFirstName());
            }
            if(customerUpdateDTO.getLastName()!=null) {
                customer.setLastName(customerUpdateDTO.getLastName());
            }
            if(customerUpdateDTO.getEmail()!=null) {
                customer.setEmail(customerUpdateDTO.getEmail());
            }
            if(customerUpdateDTO.getPhone()!=null) {
                customer.setPhone(customerUpdateDTO.getPhone());
            }
            customerRepository.save(customer);
        }
    }
    public void rentCar(int carId,int customerId ) throws NoSuchFieldException {
        Optional<Car> car = carRepository.findById(carId);
        if(carId<0 || customerId<0){
            throw new IllegalArgumentException();
        }
        if (car.isEmpty()) {
            throw new NoSuchElementException("car");
        }
        if(car.get().getAvailability().equals("rented")){
            throw new NoSuchFieldException();
        }
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new NoSuchElementException("customer");
        }

        car.get().getCustomers().add(customer.get());
        customer.get().getRentedCars().add(car.get());
        car.get().setAvailability("rented");
        customerRepository.save(customer.get());
        carRepository.save(car.get());
    }
}
