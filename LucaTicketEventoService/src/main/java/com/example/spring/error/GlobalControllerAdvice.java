package com.example.spring.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.spring.excepciones.FormatoException;
import com.example.spring.excepciones.VacioException;
import com.example.spring.excepciones.NotFoundException;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName GlobalControllerAdvice
 *
 * @author María Castro, Patricia García, Usoa Larrarte, Jennifer Pérez y Sara
 *         Silvo
 *
 * @date 12 jul. 2021
 * 
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalControllerAdvice {

	// La anotación @ExceptionHandler se encargará de anotar un método como el
	// encargado de realizar acciones en caso de que se lance una excepción.
	// handleJasonMappingException, maneja los errores de parseo de valores al
	// crear/editar
	// un usuario (JsonMappingException).

	@ExceptionHandler(VacioException.class)
	public ResponseEntity<ApiError> VacioException(VacioException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}

	@ExceptionHandler(FormatoException.class)
	public ResponseEntity<ApiError> FormatoException(FormatoException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiError> NotFoundException(NotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}

}
