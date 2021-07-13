package com.example.spring;

import static io.restassured.RestAssured.given;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName TestAddEvento
 *
 * @author María Castro, Patricia García, Usoa Larrarte,
 * Jennifer Pérez y Sara Silvo
 *
 * @date 13 jul. 2021
 * 
 * @version 1.0
 */
@SpringBootConfiguration
public class TestAddEvento {
	
	private static final Logger logger = Logger.getLogger("TestAddEvento.class");
	
	@Test
	public void postRequest() {
		
		logger.info("---- Se ha invocado el TestAddEvento");
		
		given()
			.port(3333)
			.header("Content-type", "application/json")
			.and()
			.body("{\"nombre\":\"Viña Rock\", \"generoMusical\":\"Rock\", \"recinto\":{\"ciudad\":\"Sevilla\"}}")
		.when()
			.post("/eventos/add")
		.then().log().all()
			.statusCode(201);
	 }
}
