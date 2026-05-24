package com.example.pruebatecnica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebatecnica.model.RequestPetPost;
import com.example.pruebatecnica.model.ResponsePetServiceGet;
import com.example.pruebatecnica.model.ResponsePetServicePost;
import com.example.pruebatecnica.service.ServiceApp;


@RestController
@RequestMapping("/api/pet")
public class Controller {
	
	private ServiceApp serviceApp;
	private static final Logger log = LoggerFactory.getLogger(Controller.class);
	
	public Controller(ServiceApp serviceApp) {
		this.serviceApp = serviceApp;
	}

	@GetMapping("/{id}")
	public ResponsePetServiceGet serviceGet(@PathVariable("id") Integer id) {
		log.info("inicia endPoint servicio get");
		return serviceApp.getPet(id);
	}
	
	@PostMapping
	public ResponsePetServicePost servicePetPost(@RequestBody RequestPetPost requestPost) {
		log.info("inicia endPoint servicio post");
		return serviceApp.postPet(requestPost);
	}

}
