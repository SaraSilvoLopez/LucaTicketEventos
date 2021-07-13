package com.example.spring;

import static io.restassured.RestAssured.given;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

import io.restassured.http.ContentType;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName TestDeleteEvento
 *
 * @author María Castro, Patricia García, Usoa Larrarte,
 * Jennifer Pérez y Sara Silvo
 *
 * @date 13 jul. 2021
 * 
 * @version 1.0
 */
@SpringBootConfiguration
public class TestDeleteEvento {

	private static final Logger logger = Logger.getLogger("TestDeleteEvento.class");
	
	@Test
	public void deleteEventoTest() {
		
		logger.info("---- Se ha invocado el TestDeleteEvento");
		
		 given().log().all()
			.port(3333)
			.header("Content-type", "application/json")
			.and()
			.body("{\"id\":\"60edc98ca5997f3f9d0e553a\", \"nombre\":\"Viña Rock\",\"generoMusical\":\"Rock\", \"recinto\":{\"ciudad\":\"Sevilla\"}}")
		.when()
			.post("/eventos/add");
		
		given().log().all()
			.port(3333)
			.accept(ContentType.JSON)
			.delete("/eventos/delete/60edc98ca5997f3f9d0e553a")
		.then().log().all()
			.statusCode(200);
	}
}
