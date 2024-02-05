package com.proyectoMicroservicios.usermicroService.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectoMicroservicios.usermicroService.model.Car;

@FeignClient(name = "car-microService", url = "http://localhost:8002/car")
public interface CarFeignClient {

	@PostMapping()
	Car save(@RequestBody Car car);
	

}