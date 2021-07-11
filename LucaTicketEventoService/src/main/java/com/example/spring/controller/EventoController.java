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

	private static final Logger logger = Logger.getLogger("EventoController.class");

	@Autowired
	private EventoRepository eventoRepository;

	/**
	 * Método para añadir evento
	 * 
	 * @param evento
	 * @return ResponseEntity
	 */
	@PostMapping("/eventos/add")
	public ResponseEntity<?> addEvento(@RequestBody Evento evento) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/ADD");
		try {
			Evento eventoCreado = eventoRepository.save(evento);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(eventoCreado.getId()).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
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
	 * Método para buscar un evento por id
	 * 
	 * @param id
	 * @return Evento
	 */
	@GetMapping("/eventos/{id}")
	public Evento getEvento(@PathVariable String id) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/GETEVENTO");
		return eventoRepository.findById(id).orElseThrow(EventoNotFoundException::new);
	}

	/**
	 * Método para eliminar evento por id. Si no lo encuentra o hay una excepcion
	 * devuelte estado NOT FOUND
	 * 
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@DeleteMapping("/eventos/delete/{id}")
	public ResponseEntity<?> deleteEvento(@PathVariable("id") String id) {
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
	 * @return ResponseEntity<?>
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
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
	}

	/**
	 * Método para listar todos los eventos de un generoMusical
	 * 
	 * @param generoMusical
	 * @return List<Evento>
	 */
	@GetMapping("/eventos/bygeneromusical/{generoMusical}")
	public List<Evento> getEventosByGeneroMusical(@PathVariable String generoMusical) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/GETEVENTOSBYGENEROMUSICAL");
		return eventoRepository.findByGeneroMusical(generoMusical);
	}

	/**
	 * Método para listar todos los eventos que contengan el nombre indicado
	 * 
	 * @param nombreContains
	 * @return List<Evento>
	 */
	@GetMapping("/eventos/bynombre/{nombreContains}")
	public List<Evento> getEventosByNombre(@PathVariable String nombreContains) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/GETEVENTOSBYNOMBRE");
		return eventoRepository.findByNombreContaining(nombreContains);
	}

}
