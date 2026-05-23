package com.example.pruebatecnica.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.pruebatecnica.clients.ClientPet;
import com.example.pruebatecnica.model.ClientResponsePet;

@Service
public class ServiceApp {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceApp.class);
	private ClientPet clientPet;
	
	public ServiceApp (ClientPet clientPet) {
		this.clientPet = clientPet;
	} 
	
	
	public ClientResponsePet getPet(Integer id) {
		log.info("aqui paso 1");
		return clientPet.servicePetGet(id);
	}

}
