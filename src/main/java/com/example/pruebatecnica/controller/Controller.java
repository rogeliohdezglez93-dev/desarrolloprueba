package com.example.pruebatecnica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebatecnica.model.ClientResponsePet;
import com.example.pruebatecnica.service.ServiceApp;


@RestController
@RequestMapping("/api/pet")
public class Controller {
	
	@Autowired
	private ServiceApp serviceApp;
	private static final Logger log = LoggerFactory.getLogger(Controller.class);

	@GetMapping("/{id}")
	public ClientResponsePet decirHola(@PathVariable("id") Integer id) {
		log.info(id+"id");
		
		return serviceApp.getPet(id);
	}
	
	@PostMapping
	public String decirHolau() {
		log.info("zzz");
		return "Hola mundou";
	}

}
