package com.example.spring;

import static org.hamcrest.CoreMatchers.hasItems;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

import static io.restassured.RestAssured.given;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName TestGetEventos
 *
 * @author María Castro, Patricia García, Usoa Larrarte,
 * Jennifer Pérez y Sara Silvo
 *
 * @date 10 jul. 2021
 * 
 * @version 1.0
 */
@SpringBootConfiguration
public class TestGetEventos {

	private static final Logger logger = Logger.getLogger("TestGetEventos.class");
	
	@Test
	public void getEventosTest() {
		
		logger.info("---- Se ha invocado el TestGetEventos");
		
		given().log().all()
			.port(3333)
			.get("/eventos")
		.then().log().all()
			.statusCode(200)
			.body("nombre", hasItems("Interestellar"));
	}
	
}
