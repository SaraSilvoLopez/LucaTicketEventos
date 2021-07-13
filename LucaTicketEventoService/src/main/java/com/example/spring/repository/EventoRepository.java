package com.example.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.model.Evento;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName EventoRepository
 *
 * @author María Castro, Patricia García, Usoa Larrarte
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
public interface EventoRepository extends MongoRepository<Evento, String> {

	List<Evento> findByGeneroMusical(String generoMusical);

	List<Evento> findByNombreContaining(String nombreContains);
	
	List<Evento> findByRecintoCiudad(String ciudad);

}
