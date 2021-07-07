package com.example.spring.controller;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.spring.model.Evento;
import com.example.spring.repository.EventoRepository;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName EventoController
 *
 * @author María Castro, Patricia García, Usoa Larrarte
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
@RestController
public class EventoController {

	private static final Logger logger = Logger.getLogger("");

	@Autowired
	private EventoRepository eventoRepository;

	/**
	 * Método para añadir evento
	 * 
	 * @param evento
	 * @return Evento
	 */
	@PostMapping("/eventos/add")
	public Evento addEvento(@RequestBody Evento evento) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/ADD");
		return eventoRepository.save(evento);
	}

	/**
	 * Método para listar todos los eventos de la BBDDs
	 * 
	 * @return List<Evento>
	 */
	@GetMapping("/eventos")
	public List<Evento> getEventos() {
		logger.info("---- Se ha invocado el microservicio EVENTOS/GETEVENTOS");
		return eventoRepository.findAll();
	}

	/**
	 * Método para eliminar evento por id. Si no lo encuentra o hay una excepcion
	 * devuelte estado NOT FOUND
	 * 
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@DeleteMapping("/eventos/delete/{id}")
	public ResponseEntity<?> deleteEvento(@PathVariable String id) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/DELETE/{id}");
		try {
			if (eventoRepository.findById(id).isPresent()) {
				eventoRepository.deleteById(id);
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	/**
	 * Método para modificar evento por id. Si no lo encuentra o hay una excepcion
	 * devuelte estado NOT FOUND
	 * 
	 * @param evento
	 * @return
	 */
	@PutMapping("/eventos/update")
	public ResponseEntity<?> updateEvento(@RequestBody Evento evento) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/UPDATE");
		try {
			if (eventoRepository.findById(evento.getId()).isPresent()) {
				Evento eventoModificado = eventoRepository.save(evento);
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(eventoModificado.getId()).toUri();
				return ResponseEntity.created(location).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
