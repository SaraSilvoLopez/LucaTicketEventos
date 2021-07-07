package com.example.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Evento;
import com.example.repository.EventoRepository;

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

	@PostMapping("/eventos/add")
	public Evento addEvento(@RequestBody Evento evento) {
		logger.info("---- Se ha invocado el microservicio EVENTOS/ADD");
		return eventoRepository.save(evento);
	}

	@GetMapping("/eventos")
	public List<Evento> getEventos() {
		logger.info("---- Se ha invocado el microservicio EVENTOS/GETEVENTOS");
		return eventoRepository.findAll();
	}

}
