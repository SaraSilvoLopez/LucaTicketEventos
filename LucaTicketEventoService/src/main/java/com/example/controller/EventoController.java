package com.example.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Evento;
import com.example.repository.EventoRepository;

@RestController
public class EventoController {
	
	private static final Logger logger = Logger.getLogger("");
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@PostMapping("/eventos/add")
	public Evento addEvento(@RequestBody Evento evento){
		return eventoRepository.save(evento);
	}
	

}
