package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Evento;

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

}
