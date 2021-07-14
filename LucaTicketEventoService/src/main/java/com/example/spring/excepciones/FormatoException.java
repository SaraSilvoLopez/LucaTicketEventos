package com.example.spring.excepciones;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName FormatoException
 *
 * @author Jennifer Pérez, Maria Castro y Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
public class FormatoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Personaliza el mensaje de error el formato introducido es erroneo
	 */
	public FormatoException() {
		super("El formato introducido en uno de los campos es erróneo");
	}

}
