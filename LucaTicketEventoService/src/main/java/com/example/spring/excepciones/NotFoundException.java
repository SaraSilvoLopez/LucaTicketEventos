package com.example.spring.excepciones;

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
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Personalizan el mensaje de error cuando el evento no existe
	 */
	public NotFoundException() {
		super("No existe el evento");
	}

	public NotFoundException(String id) {
		super("No existe el evento" + id);
	}

}
