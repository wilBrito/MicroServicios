package com.proyectoMicroservicios.usermicroService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectoMicroservicios.usermicroService.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
