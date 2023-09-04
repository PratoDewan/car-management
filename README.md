# Car Management System

A simple CRUD application for managing cars and customers with a many-to-many relationship and exception handling.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Usage](#usage)
- [Entities](#entities)
- [Endpoints](#endpoints)
- [Exception Handling](#exception-handling)

## Features

- **Car Management**: Create, read, update, and delete car records.
- **Customer Management**: Create, read, update, and delete customer records.
- **Rent Cars**: Associate customers with rented cars.
- **Search Cars**: Find cars by brand, availability, or both.
- **Global Exception Handling**: Handling of various exceptions for better error management.

## Prerequisites

- [Java Development Kit (JDK) Version 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL Database](https://www.mysql.com/)

## Usage

You can access the application through HTTP requests using API client (e.g., Postman).

## Entities

### Car Structure

The `Car` entity represents a car in the car management system. Here's a breakdown of its structure:

- **carId (Integer)**: The unique identifier for the car.
- **brand (String)**: The brand or manufacturer of the car.
- **name (String)**: The name or model of the car.
- **regiNo (String)**: The registration number of the car.
- **availability (String)**: The availability status of the car (e.g., "available," "rented").
- **customers (List of Customers)**: A list of customers who have rented this car.

### Customer Structure

The `Customer` entity represents a customer in the car management system. Here's a breakdown of its structure:

- **customerId (Integer)**: The unique identifier for the customer.
- **firstName (String)**: The first name of the customer.
- **lastName (String)**: The last name of the customer.
- **email (String)**: The email address of the customer.
- **phone (String)**: The phone number of the customer.
- **rentedCars (List of Cars)**: A list of cars rented by this customer.

## Endpoints

### Car Management

- **GET** `/car/all`: Retrieve all cars.
- **GET** `/car/find-by-id?id={carId}`: Retrieve a car by ID.
- **GET** `/car/find-by-brand?brand={brand}`: Find cars by brand.
- **GET** `/car/find-by-availability?status={status}`: Find cars by availability status.
- **GET** `/car/find-by-brand-status?brand={brand}&status={status}`: Find cars by brand and availability status.
- **POST** `/car/add-car`: Add a new car.
- **DELETE** `/car/delete-car?id={carId}`: Delete a car by ID.
- **PUT** `/car/update-car/{id}`: Update a car by ID.

### Customer Management

- **GET** `/customer/all`: Retrieve all customers.
- **GET** `/customer/find-by-id?id={customerId}`: Retrieve a customer by ID.
- **POST** `/customer/add-customer`: Add a new customer.
- **DELETE** `/customer/delete-customer?id={customerId}`: Delete a customer by ID.
- **PUT** `/customer/update-customer/{id}`: Update a customer by ID.

### Renting a Car

To rent a car, make a `POST` request to the `/car/rent` endpoint with the following parameters:

- `carId`: The unique identifier of the car you want to rent.
- `customerId`: The unique identifier of the customer who is renting the car.

Please note that there are some important considerations when renting a car:

- **Availability**: If the car you want to rent is already rented or marked as unavailable, attempting to rent it will result in a `NoSuchFieldException`. Ensure that the car is marked as available before attempting to rent it.

- **Exceptions**: The system is designed to handle exceptions gracefully. If an invalid `carId` or `customerId` is provided, or if there are any other issues during the rental process, the system will return an appropriate error message.

Here's an example of a `POST` request to rent a car:

- **POST**  `/customer/rent?carId=1&customerId=1`


## Exception Handling

The application handles various exceptions to provide informative error messages. These exceptions include:

### Built In Exceptions
- `IllegalArgumentException`: Negative id will throw this exception.
- `NoSuchElementException`: If no object is found with the id.
- `EmptyResultDataAccessException`: If database returns empty result.
- `NoSuchFieldException`: If the car is not available for renting.
- 
### Custom Exceptions
- `InvalidQueryException`: To handle IllegalArgumentException.
- `ObjectNotFoundException`: To handle NoSuchElementException.
- `EmptyResultFoundException`: To handle EmptyResultDataAccessException.
- `StatusException`: To handle NoSuchFieldException. 

