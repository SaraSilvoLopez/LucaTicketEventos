package com.example.spring.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName Evento
 *
 * @author María Castro, Patricia García, Usoa Larrarte
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
@Document(collection = "eventos")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@MongoId(FieldType.OBJECT_ID)
	private String id;

	@Indexed
	private String nombre;

	@Indexed
	private String generoMusical;

	private Recinto recinto;
	private String descripcionCorta;
	private String descripcionExtendida;
	private String foto;
	private LocalDate fecha;
	private LocalTime hora;
	private double rangoPrecios;
	private String politicaAcceso;

}
