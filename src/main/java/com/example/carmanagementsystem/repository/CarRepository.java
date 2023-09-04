package com.example.carmanagementsystem.repository;

import com.example.carmanagementsystem.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByBrand(String brand);
    List<Car> findByAvailability(String status);
    @Query("SELECT c FROM Car c WHERE c.brand = :brand AND c.availability = :status")
    List<Car> findByBrandAndAvailability(@Param("brand") String brand, @Param("status") String status);

}
