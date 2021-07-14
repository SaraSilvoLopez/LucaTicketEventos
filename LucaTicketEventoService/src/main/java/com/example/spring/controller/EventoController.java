package com.example.spring.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.excepciones.NotFoundException;
import com.example.spring.excepciones.FormatoException;
import com.example.spring.excepciones.VacioException;
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
	 * @return ResponseEntity<String>
	 */
	@PostMapping("/eventos/add")
	@Consumes({ MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addEvento(@RequestBody Evento evento) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/ADD");
		if (evento.getNombre() != null && evento.getGeneroMusical() != null
				&& evento.getRecinto().getCiudad() != null) {
			try {
				Evento eventoCreado = eventoRepository.save(evento);
				return new ResponseEntity<>("El evento se ha guardado correctamente \n" + eventoCreado.toString(),
						HttpStatus.CREATED);
			} catch (DataIntegrityViolationException ex) {
				throw new FormatoException();
			}
		} else {
			throw new VacioException();
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
		return eventoRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	/**
	 * Método para eliminar evento por id. Si no lo encuentra o hay una excepcion
	 * devuelte estado NOT FOUND
	 * 
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@DeleteMapping("/eventos/delete/{id}")
	public ResponseEntity<String> deleteEvento(@PathVariable("id") String id) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/DELETE/{id}");
		try {
			if (eventoRepository.findById(id).isPresent()) {
				eventoRepository.deleteById(id);
				return new ResponseEntity<>("El evento se ha eliminado correctamente \n", HttpStatus.OK);
			} else {
				throw new NotFoundException();
			}
		} catch (DataIntegrityViolationException e) {
			throw new NotFoundException();
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
	public ResponseEntity<String> updateEvento(@RequestBody Evento evento) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/UPDATE");
		try {
			if (eventoRepository.findById(evento.getId()).isPresent()) {
				Evento eventoModificado = eventoRepository.save(evento);
				return new ResponseEntity<>("El evento se ha modificado correctamente \n" + eventoModificado.toString(),
						HttpStatus.OK);
			} else {
				throw new NotFoundException();
			}
		} catch (DataIntegrityViolationException e) {
			throw new NotFoundException();
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

	/**
	 * Método para listar todos los eventos de una ciudad
	 * 
	 * @param ciudad
	 * @return List<Evento>
	 */
	@GetMapping("/eventos/byciudad/{ciudad}")
	public List<Evento> getEventosByCiudad(@PathVariable String ciudad) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/GETEVENTOSBYCIUDAD");
		return eventoRepository.findByRecintoCiudad(ciudad);
	}

}
