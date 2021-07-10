package com.example.spring;

import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

import static io.restassured.RestAssured.given;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName TestGetEvento
 *
 * @author María Castro, Patricia García, Usoa Larrarte,
 * Jennifer Pérez y Sara Silvo
 *
 * @date 10 jul. 2021
 * 
 * @version 1.0
 */
@SpringBootConfiguration
public class TestGetEvento {

	@Test
	public void getEventoTest() {
		given().log().all()
			.port(3333)
			.get("/eventos/60e9a5de53125e04e28b32d6")
		.then().log().all()
			.statusCode(200)
			.body("id", is("60e9a5de53125e04e28b32d6"));
	}
	
}
