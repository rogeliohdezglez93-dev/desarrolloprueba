package com.example.pruebatecnica.clients;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.example.pruebatecnica.model.Category;
import com.example.pruebatecnica.model.ClientRequestPost;
import com.example.pruebatecnica.model.ClientResponsePet;
import com.example.pruebatecnica.model.RequestPetPost;
import com.example.pruebatecnica.model.Tag;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ClientPet {
	
	private static final Logger log = LoggerFactory.getLogger(ClientPet.class);

	private final RestTemplate restTemp;
	public ClientPet(RestTemplate restTemp) {
		this.restTemp = restTemp;
	}
	
	
	public ClientResponsePet servicePetGet(Integer id) {
		
		try {
			log.info("consumo cliente pet get");		
			String urlGet = "https://petstore.swagger.io/v2/pet/{id}";
			ClientResponsePet clientResponsePet = restTemp.getForObject(urlGet,ClientResponsePet.class,id);
			//ResponseEntity<String> response = restTemp.exchange(urlGet,HttpMethod.GET,null,String.class,id);
			log.info("respuestaa {}",clientResponsePet.toString());
			return clientResponsePet;
		} catch (HttpClientErrorException.NotFound e) {
			log.error("exception {}",e.getResponseBodyAsString());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"pet no encontrado");
		}		

		
		
	}
	
	
	public ClientResponsePet servicePetPost(RequestPetPost requestPost) {

		log.info("consumo cliente pet post");

		String varString = "string";
		ArrayList<String> listStr = new ArrayList<String>();
		ArrayList<Tag> listTag = new ArrayList<Tag>();
		Tag tag = new Tag();
		tag.setId(0);
		tag.setName(varString);
		listStr.add(varString);
		listTag.add(tag);
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setId(requestPost.id());
		clientRequestPost.setCategory(new Category());
		clientRequestPost.getCategory().setId(0);
		clientRequestPost.getCategory().setName(varString);
		clientRequestPost.setName(requestPost.name());
		clientRequestPost.setPhotoUrls(listStr);
		clientRequestPost.setTags(listTag);
		clientRequestPost.setStatus(requestPost.status());
		String urlPost = "https://petstore.swagger.io/v2/pet";

		ClientResponsePet clientResponsePet = restTemp.postForObject(urlPost,clientRequestPost,ClientResponsePet.class);

		return clientResponsePet;
	}

}
