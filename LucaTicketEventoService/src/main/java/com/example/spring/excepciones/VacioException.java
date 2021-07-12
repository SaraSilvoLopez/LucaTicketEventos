package com.example.spring.excepciones;

/**
 * @Project LucaTicketUsuarioService
*
* @ClassName LucaTicketUsuarioServiceApplication
*
* @author Jennifer Pérez, Maria Castro y Sara Silvo
*
* @date 7 jul. 2021
* 
* @version 1.0
*/
 
public class VacioException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	/**
	 * Personaliza el mensaje de error cuando se deja un campo vacio
	 */
	
	public VacioException() {
		super("Se deben rellenar todos los campos");
	}
}