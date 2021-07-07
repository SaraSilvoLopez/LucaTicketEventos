package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName LucaTicketEventoServiceApplication
 *
 * @author María Castro, Patricia García, Usoa Larrarte
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LucaTicketEventoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaTicketEventoServiceApplication.class, args);
	}

}
