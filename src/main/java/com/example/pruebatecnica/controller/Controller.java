package com.example.pruebatecnica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/pet")
public class Controller {
	
	private static final Logger log = LoggerFactory.getLogger(Controller.class);
	@GetMapping
	public String decirHola() {
		return "Hola mundo";
	}
	
	@PostMapping
	public String decirHolau() {
		return "Hola mundou";
	}

}
