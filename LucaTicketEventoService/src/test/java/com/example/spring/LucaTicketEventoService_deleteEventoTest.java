package com.example.spring;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.spring.controller.EventoController;
import com.example.spring.model.Evento;
import com.example.spring.repository.EventoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName LucaTicketEventoService_deleteEventoTest
 *
 * @author María Castro, Patricia García, Usoa Larrarte,
 * Jennifer Pérez y Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(EventoController.class)
public class LucaTicketEventoService_deleteEventoTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EventoRepository repo;

	@Autowired
	ObjectMapper mapper;

	@Test
	void deleteEventoTest1() throws Exception {

		Evento evento = new Evento();
		evento.setId("60e5de1ff2674135f1e554fb");


	    Mockito.when(repo.findById(evento.getId())).thenReturn(Optional.of(evento));

	    mockMvc.perform(MockMvcRequestBuilders
	            .delete("/eventos/delete/60e5de1ff2674135f1e554fb")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}

	@Test
	void deleteEventoTest2() throws Exception {

		Mockito.when(repo.findById("888888888888888888888888")).thenReturn(null);

		mockMvc.perform(MockMvcRequestBuilders
	            .delete("/eventos/delete/888888888888888888888888")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNotFound());
	}

	@Test
	void deleteEventoTest3() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders
	            .delete("/eventos/delete/60e5")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNotFound());
	}
}
