package com.example.pruebatecnica.model;

public record ResponsePetServiceGet(Integer id,String name,String status) {
	public ResponsePetServiceGet(ClientResponsePet clientResponsePet) {
		this(clientResponsePet.getId(),clientResponsePet.getName(),clientResponsePet.getStatus());
	}

}
