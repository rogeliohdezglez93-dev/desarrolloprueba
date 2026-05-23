package com.example.pruebatecnica.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.pruebatecnica.model.ClientResponsePet;

@Component
public class ClientPet {
	
	private static final Logger log = LoggerFactory.getLogger(ClientPet.class);

	private final RestTemplate restTemp;
	public ClientPet(RestTemplate restTemp) {
		this.restTemp = restTemp;
	}
	
	
	public ClientResponsePet servicePetGet(Integer id) {
		
		log.info("aqui paso el logg parte 2");
		
		String urlGet = "https://petstore.swagger.io/v2/pet/{id}";
		
		ClientResponsePet clientResponsePet = restTemp.getForObject(urlGet,ClientResponsePet.class,id);
		
		
		return clientResponsePet;
	} 

}
