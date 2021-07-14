package com.example.spring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
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
 * @ClassName LucaTicketEventoService_addEventoTest
 *
 * @author María Castro, Patricia García, Usoa Larrarte,
 * Jennifer Pérez y Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
@SpringBootConfiguration
@ExtendWith(SpringExtension.class)
@WebMvcTest(EventoController.class)
public class LucaTicketEventoService_addEventoTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EventoRepository repo;

	@Autowired
	ObjectMapper mapper;

	@Test
	void addEventoTest1() throws Exception {

		Evento evento = new Evento();
		evento.setNombre("El mejor festival");

		Mockito.when(repo.save(evento)).thenReturn(evento);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/eventos/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(evento));

		mockMvc.perform(mockRequest).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.nombre", is("El mejor festival")));

	}

	@Test
	void addEventoTest2() throws Exception {

		Evento evento = new Evento();

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/eventos/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(evento));

		mockMvc.perform(mockRequest).andExpect(status().isOk()).andExpect(jsonPath("$").doesNotExist());
	}
}
