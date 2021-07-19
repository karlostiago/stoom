package com.ctsousa.stoom.controller;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ctsousa.stoom.controller.input.AddressInput;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@TestMethodOrder(OrderAnnotation.class)
public class AddressControllerTest extends AbstractApplicationTest {
	
	@BeforeEach
	public void setup() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/v1/address";	
	}
	
	@Test
	@Order(1)
	public void shouldReturn201_WhenSave() {
		given()
			.body(getBody())
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(201);
	}
	
	@Test
	@Order(2)
	public void shouldReturn200_WhenUpdate() {
		
		AddressInput body = (AddressInput)getBody();
		body.setCity("São Paulo");
		
		given()
			.body(body)
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
		.when()
			.put("/{id}", 1L)
		.then()
			.statusCode(200);
	}
	
	@Test
	@Order(3)
	public void shouldReturn200_WhenSearchAll() {
		given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
		.when()
			.get()
		.then()
			.body("", Matchers.hasSize(1))
			.statusCode(200);
	}
	
	@Test
	@Order(4)
	public void shouldReturn200_WhenSearchById() {
		given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
		.when()
			.get("/{id}", 1L)
		.then()
			.statusCode(200);
	}
	
	@Test
	@Order(5)
	public void shouldReturn204_WhenDelete() {
		given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
		.when()
			.delete("/{id}", 1L)
		.then()
			.statusCode(204);
	}
	
	private Object getBody() {
		AddressInput body = new AddressInput();
		body.setCity("Fortaleza");
		body.setComplement("Complement");
		body.setCountry("Brasil");
		body.setNeighbourhood("Neighbourhood");
		body.setNumber("001");
		body.setState("Ceara");
		body.setStreetName("Rua 1");
		body.setZipCode("60758191");
		return body;
	}
}
