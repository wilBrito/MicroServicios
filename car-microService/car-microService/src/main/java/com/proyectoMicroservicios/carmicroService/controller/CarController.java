package com.proyectoMicroservicios.carmicroService.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoMicroservicios.carmicroService.entity.Car;
import com.proyectoMicroservicios.carmicroService.service.CarService;


@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;
	
	@GetMapping
	public ResponseEntity<List<Car>> getAll(){
		List<Car> cars = carService.getAll();
		if(cars.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(cars);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> getById(@PathVariable("id") int id){
		Car car = carService.getCarById(id);
		if(car == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(car);
	}
	
	
	@PostMapping
	public ResponseEntity<Car> save(@RequestBody Car user){
		Car userNew = carService.save(user);
		return ResponseEntity.ok(userNew);
	}
	
	
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId){
		List<Car> cars = carService.findByUserId(userId);
		if(cars.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(cars);
	}
		
}
