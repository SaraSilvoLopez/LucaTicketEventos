package com.example.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName EventoNotFoundException
 *
 * @author María Castro, Patricia García, Usoa Larrarte
 *
 * @date 10 jul. 2021
 * 
 * @version 1.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EventoNotFoundException() {
		super("No existe el evento");
	}

	public EventoNotFoundException(String id) {
		super("No existe el evento" + id);
	}

}
