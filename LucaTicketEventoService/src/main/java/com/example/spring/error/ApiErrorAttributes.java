package com.example.spring.error;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName ApiErrorAttributes
 *
 * @author Jennifer Pérez y Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

/**
 * Crea la clase ApiErrorAttributes extendida de DefaultErrorAttributes de la
 * que herdara los atributos timestamp - la hora a la que se extrajeron los
 * errores status - el código de estado error - el motivo del error message - el
 * mensaje del error (cuando se configura)
 * 
 */
@Component
public class ApiErrorAttributes extends DefaultErrorAttributes {

	public Map<String, Object> getErrorAttributes(WebRequest webRequest) {

		Map<String, Object> allErrorAttributes = super.getErrorAttributes(webRequest, null);
		Map<String, Object> errorAttributes = new HashMap<>();

		int statusCode = (int) allErrorAttributes.get("status");

		errorAttributes.put("estado", HttpStatus.valueOf(statusCode));
		errorAttributes.put("fecha", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

		String mensaje = "";

		Throwable throwable = getError(webRequest);

		if (throwable instanceof ResponseStatusException) {
			ResponseStatusException responseStatusException = (ResponseStatusException) throwable;
			mensaje = responseStatusException.getReason() == null ? "" : responseStatusException.getReason();
		} else {
			if (throwable.getCause() != null)
				mensaje = throwable.getCause().getMessage() == null ? throwable.getCause().toString()
						: throwable.getCause().getMessage();
			else
				mensaje = throwable.toString();
		}

		errorAttributes.put("mensaje", mensaje);

		return errorAttributes;
	}

}