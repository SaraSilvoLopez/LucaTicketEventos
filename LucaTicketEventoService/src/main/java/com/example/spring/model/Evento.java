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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
/*
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
*/
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
	
	public Evento() {
	
	}

	public Evento(String id, String nombre, String generoMusical, Recinto recinto, String descripcionCorta,
			String descripcionExtendida, String foto, LocalDate fecha, LocalTime hora, double rangoPrecios,
			String politicaAcceso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.generoMusical = generoMusical;
		this.recinto = recinto;
		this.descripcionCorta = descripcionCorta;
		this.descripcionExtendida = descripcionExtendida;
		this.foto = foto;
		this.fecha = fecha;
		this.hora = hora;
		this.rangoPrecios = rangoPrecios;
		this.politicaAcceso = politicaAcceso;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionExtendida() {
		return descripcionExtendida;
	}

	public void setDescripcionExtendida(String descripcionExtendida) {
		this.descripcionExtendida = descripcionExtendida;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public double getRangoPrecios() {
		return rangoPrecios;
	}

	public void setRangoPrecios(double rangoPrecios) {
		this.rangoPrecios = rangoPrecios;
	}

	public String getPoliticaAcceso() {
		return politicaAcceso;
	}

	public void setPoliticaAcceso(String politicaAcceso) {
		this.politicaAcceso = politicaAcceso;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", generoMusical=" + generoMusical + ", recinto=" + recinto
				+ ", descripcionCorta=" + descripcionCorta + ", descripcionExtendida=" + descripcionExtendida
				+ ", foto=" + foto + ", fecha=" + fecha + ", hora=" + hora + ", rangoPrecios=" + rangoPrecios
				+ ", politicaAcceso=" + politicaAcceso + "]";
	}
	
}
