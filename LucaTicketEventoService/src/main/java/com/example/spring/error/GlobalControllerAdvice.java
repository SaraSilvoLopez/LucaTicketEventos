
package com.example.spring.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.spring.excepciones.FormatoException;
import com.example.spring.excepciones.VacioException;


@RestControllerAdvice
public class GlobalControllerAdvice {
	
	//La anotación @ExceptionHandler se encargará de anotar un método como el 
	//encargado de realizar acciones en caso de que se lance una excepción.
	//handleJasonMappingException, maneja los errores de parseo de valores al crear/editar
	//un usuario (JsonMappingException).
	
		
	@ExceptionHandler(VacioException.class)
	public ResponseEntity<ApiError> VacioException(VacioException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	@ExceptionHandler(FormatoException.class)
	public ResponseEntity<ApiError> FormatoException(VacioException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	
}
