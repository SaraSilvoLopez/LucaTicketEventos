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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.spring.controller.EventoController;
import com.example.spring.model.Evento;
import com.example.spring.repository.EventoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName LucaTicketEventoService_updateEventoTest
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
public class LucaTicketEventoService_updateEventoTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EventoRepository repo;

	@Autowired
	ObjectMapper mapper;

	@Test
	void updateEventoTest1() throws Exception {

		Evento eventoOriginal = new Evento();
		eventoOriginal.setId("60e5de1ff2674135f1e554fb");
		Evento eventoActualizado = new Evento();
		eventoActualizado.setId("60e5de1ff2674135f1e554fb");
		eventoActualizado.setNombre("Festival Actualizado");

		Mockito.when(repo.findById(eventoOriginal.getId())).thenReturn(Optional.of(eventoOriginal));
		Mockito.when(repo.save(eventoActualizado)).thenReturn(eventoActualizado);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/eventos/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(eventoActualizado));

		mockMvc.perform(mockRequest).andExpect(status().is2xxSuccessful());
	}

	@Test
	void updateEventoTest2() throws Exception {

		Evento eventoOriginal = new Evento();
		eventoOriginal.setId("888888888888888888888888");
		Evento eventoActualizado = new Evento();
		eventoActualizado.setId("60e5de1ff2674135f1e554fb");
		eventoActualizado.setNombre("Festival Actualizado");

		Mockito.when(repo.findById(eventoOriginal.getId())).thenReturn(Optional.of(eventoOriginal));
		Mockito.when(repo.save(eventoActualizado)).thenReturn(eventoActualizado);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/eventos/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(eventoActualizado));

		mockMvc.perform(mockRequest).andExpect(status().isNotFound());
	}

	@Test
	void updateEventoTest3() throws Exception {

		Evento evento = new Evento();

		Mockito.when(repo.save(evento)).thenReturn(evento);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/eventos/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(evento));

		mockMvc.perform(mockRequest).andExpect(status().isNotFound());

	}
}
