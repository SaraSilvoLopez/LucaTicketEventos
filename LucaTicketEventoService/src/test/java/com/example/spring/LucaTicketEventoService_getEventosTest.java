package com.example.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring.controller.EventoController;
import com.example.spring.repository.EventoRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LucaTicketEventoService_getEventosTest {
	
	@MockBean
	private EventoRepository evento;
	
	@Autowired
	private EventoController control;
	
	@Test
	public void getEventosTest1() throws Exception {
		when(evento.findAll()).thenReturn(new ArrayList<>());
		assertThat(control.getEventos().isEmpty());
		verify(evento, times(1)).findAll();
	}
	
}
