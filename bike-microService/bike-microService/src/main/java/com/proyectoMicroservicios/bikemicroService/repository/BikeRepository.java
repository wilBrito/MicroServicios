package com.proyectoMicroservicios.bikemicroService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoMicroservicios.bikemicroService.entity.Bike;


@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer>{

	List<Bike> findByUserId(int userId);
}
