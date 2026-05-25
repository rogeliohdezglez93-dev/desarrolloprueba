package com.example.pruebatecnica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.example.pruebatecnica.clients.ClientPet;
import com.example.pruebatecnica.model.Category;
import com.example.pruebatecnica.model.ClientRequestPost;
import com.example.pruebatecnica.model.ClientResponsePet;
import com.example.pruebatecnica.model.RequestPetPost;
import com.example.pruebatecnica.model.ResponsePetServiceGet;
import com.example.pruebatecnica.model.ResponsePetServicePost;
import com.example.pruebatecnica.model.Tag;
import com.example.pruebatecnica.service.ServiceApp;

@SpringBootTest
class PruebatecnicaApplicationTests {
	
	private RestTemplate restTemplate;
	private ServiceApp serviceApp;
	private ClientPet clientPet;
	private ClientResponsePet clientResponsePet;
	

	@BeforeEach
	void setUp() {
		
		restTemplate = Mockito.mock(RestTemplate.class);
		clientPet = new ClientPet(restTemplate);
		serviceApp = new ServiceApp(clientPet);
		clientResponsePet = new ClientResponsePet();
		Integer id = 10;
		String name = "name";
		String listUrl = "listUrl";
		String status = "available";
		ArrayList<String> listStr = new ArrayList<String>();
		ArrayList<Tag> listTag = new ArrayList<Tag>();
		Tag tag = new Tag();
		tag.setId(0);
		tag.setName(name);
		listStr.add(listUrl);
		listTag.add(tag);
		clientResponsePet.setId(id);
		clientResponsePet.setCategory(new Category());
		clientResponsePet.getCategory().setId(0);
		clientResponsePet.getCategory().setName(name);
		clientResponsePet.setName(name);
		clientResponsePet.setPhotoUrls(listStr);
		clientResponsePet.setTags(listTag);
		clientResponsePet.setStatus(status);
		
	}
	
	@Test
	void getPet() {
		String urlGet = "https://petstore.swagger.io/v2/pet/{id}";
		int id = 10;
		String status = "available";
		String name = "name";
		
		when(restTemplate.getForObject(urlGet, ClientResponsePet.class,id)).thenReturn(clientResponsePet);
		ResponsePetServiceGet responsePetServiceGet =serviceApp.getPet(id);
		assertEquals(id,responsePetServiceGet.id());
		assertEquals(status,responsePetServiceGet.status());
		assertEquals(name,responsePetServiceGet.name());

		
	}
	
	@Test
	void getPetNotFound() {
		String urlGet = "https://petstore.swagger.io/v2/pet/{id}";
		int id = 199;
		
		when(restTemplate.getForObject(urlGet, ClientResponsePet.class,id)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND,"pet no encontrado"));
		ResponseStatusException ex =assertThrows(ResponseStatusException.class,()->serviceApp.getPet(id));;
		assertEquals(404,ex.getBody().getStatus());

		
	}
	
	@Test
	void postPet() {
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		String urlPost = "https://petstore.swagger.io/v2/pet";
		Integer id = 10;
		String name = "name";
		String listUrl = "listUrl";
		String status = "available";
		RequestPetPost requestPetPost = new RequestPetPost(id,status,name);
		ArrayList<String> listStr = new ArrayList<String>();
		ArrayList<Tag> listTag = new ArrayList<Tag>();
		Tag tag = new Tag();
		tag.setId(0);
		tag.setName(name);
		listStr.add(listUrl);
		listTag.add(tag);
		clientRequestPost.setId(id);
		clientRequestPost.setCategory(new Category());
		clientRequestPost.getCategory().setId(0);
		clientRequestPost.getCategory().setName(name);
		clientRequestPost.setName(name);
		clientRequestPost.setPhotoUrls(listStr);
		clientRequestPost.setTags(listTag);
		clientRequestPost.setStatus(status);		
		when(restTemplate.postForObject(urlPost,clientRequestPost,ClientResponsePet.class)).thenReturn(clientResponsePet);
		ResponsePetServicePost responsePetServicePost =serviceApp.postPet(requestPetPost);
		assertEquals(true,responsePetServicePost.status());
		assertEquals("name",responsePetServicePost.name());

		
	}

}
