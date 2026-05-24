package com.example.pruebatecnica.clients;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.pruebatecnica.model.Category;
import com.example.pruebatecnica.model.ClientRequestPost;
import com.example.pruebatecnica.model.ClientResponsePet;
import com.example.pruebatecnica.model.RequestPetPost;
import com.example.pruebatecnica.model.Tag;

@Component
public class ClientPet {
	
	private static final Logger log = LoggerFactory.getLogger(ClientPet.class);

	private final RestTemplate restTemp;
	public ClientPet(RestTemplate restTemp) {
		this.restTemp = restTemp;
	}
	
	
	public ClientResponsePet servicePetGet(Integer id) {
		
		log.info("consumo cliente pet get");		
		String urlGet = "https://petstore.swagger.io/v2/pet/{id}";
		ClientResponsePet clientResponsePet = restTemp.getForObject(urlGet,ClientResponsePet.class,id);
		
		return clientResponsePet;
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
