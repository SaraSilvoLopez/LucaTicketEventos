package com.example.spring.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * * @Project LucaTicketEventoService
 *
 * @ClassName ApiError
 *
 * @author Jennifer Pérez y Sara Silvo
 *
 * @date 8 jul. 2021
 * 
 * @version 1.0
 */

/**
 * Crea la clase ApiError Utiliza Lombok para crear los metodos get, set y los
 * constructores vacio y con argumentos
 *
 */
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class ApiError {

	@NonNull
	private HttpStatus estado;
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime fecha = LocalDateTime.now();
	@NonNull
	private String mensaje;

}