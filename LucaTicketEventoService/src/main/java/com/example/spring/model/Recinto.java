package com.example.spring.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName Recinto
 *
 * @author María Castro, Patricia García, Usoa Larrarte
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
/*
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
*/
public class Recinto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String lugar;
	private Integer aforo;
	private String ciudad;
	
	public Recinto() {

	}

	public Recinto(String nombre, String lugar, Integer aforo, String ciudad) {
		super();
		this.nombre = nombre;
		this.lugar = lugar;
		this.aforo = aforo;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Recinto [nombre=" + nombre + ", lugar=" + lugar + ", aforo=" + aforo + ", ciudad=" + ciudad + "]";
	}

}
