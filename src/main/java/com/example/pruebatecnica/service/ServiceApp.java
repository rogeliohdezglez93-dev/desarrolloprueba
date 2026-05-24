package com.example.pruebatecnica.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.pruebatecnica.clients.ClientPet;
import com.example.pruebatecnica.model.ClientResponsePet;
import com.example.pruebatecnica.model.RequestPetPost;
import com.example.pruebatecnica.model.ResponsePetServiceGet;
import com.example.pruebatecnica.model.ResponsePetServicePost;

@Service
public class ServiceApp {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceApp.class);
	private ClientPet clientPet;
	
	public ServiceApp (ClientPet clientPet) {
		this.clientPet = clientPet;
	} 
	
	
	public ResponsePetServiceGet getPet(Integer id) {
		log.info("consumo servicio get");
		ClientResponsePet clientResponsePet = clientPet.servicePetGet(id);
		log.info("respuesta servicio: {}",clientResponsePet);
		return new ResponsePetServiceGet(clientResponsePet);
	}
	


	public ResponsePetServicePost postPet(RequestPetPost request) {
		log.info("consumo servicio post");
		ClientResponsePet clientResponsePet = clientPet.servicePetPost(request);
		log.info("respuesta servicio: {}",clientResponsePet);
		return createResponsePost(request);	
	}


	private ResponsePetServicePost createResponsePost(RequestPetPost request) {
		
		log.info("crear respuesta servicio post");
		UUID uuid = UUID.randomUUID();
		String uuidString = uuid.toString();
		LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        String fechaResponse = fecha.format(formato);
        boolean status = (request.status().contains("available"))?true:false;
		return new ResponsePetServicePost(uuidString,fechaResponse,status,request.name());
		
	}

	
	
}
