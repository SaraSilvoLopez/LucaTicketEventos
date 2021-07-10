package com.example.spring;

import static org.hamcrest.CoreMatchers.hasItems;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

import static io.restassured.RestAssured.given;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName TestGetEventosByNombre
 *
 * @author María Castro, Patricia García, Usoa Larrarte,
 * Jennifer Pérez y Sara Silvo
 *
 * @date 10 jul. 2021
 * 
 * @version 1.0
 */
@SpringBootConfiguration
public class TestGetEventosByNombre {

	@Test
	public void getEventosTest() {
		given().log().all()
			.port(3333)
			.get("/eventos/bynombre/Interestellar")
		.then().log().all()
			.statusCode(200)
			.body("nombre", hasItems("Interestellar"));
	}
	
}
