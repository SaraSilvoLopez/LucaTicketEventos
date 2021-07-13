package com.example.spring;

import static org.hamcrest.CoreMatchers.hasItems;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

import static io.restassured.RestAssured.given;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName TestGetEventosByCiudad
 *
 * @author María Castro, Patricia García, Usoa Larrarte,
 * Jennifer Pérez y Sara Silvo
 *
 * @date 11 jul. 2021
 * 
 * @version 1.0
 */
@SpringBootConfiguration
public class TestGetEventosByCiudad {
	
	private static final Logger logger = Logger.getLogger("TestGetEventosByCiudad.class");

	@Test
	public void getEventosByCiudadTest() {
		
		logger.info("---- Se ha invocado el TestGetEventosByCiudad");
		
		given().log().all()
			.port(3333)
			.get("/eventos/byciudad/Sevilla")
		.then().log().all()
			.statusCode(200)
			.body("recinto.ciudad", hasItems("Sevilla"));
	}
	
}
