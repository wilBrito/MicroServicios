package com.proyectoMicroservicios.usermicroService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyectoMicroservicios.usermicroService.entity.User;
import com.proyectoMicroservicios.usermicroService.model.Bike;
import com.proyectoMicroservicios.usermicroService.model.Car;
import com.proyectoMicroservicios.usermicroService.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User save(User user) {
		User userNew = userRepository.save(user);
		return userNew;
	}
	
	
	public List<Car> getCars(int userId){
		List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/byUser/" + userId, List.class);
		return cars;
	}
	
	public List<Bike> getBikes(int userId){
		List<Bike> bikes = restTemplate.getForObject("http://localhost:8003/bike/byUser/" + userId, List.class);
		return bikes;
	}
	

}
