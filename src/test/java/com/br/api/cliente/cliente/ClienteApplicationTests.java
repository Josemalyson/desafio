package com.br.api.cliente.cliente;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.api.cliente.controller.ClienteRestController;
import com.br.api.cliente.service.ClienteServico;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteRestController.class)
public class ClienteApplicationTests {

	@MockBean
	private ClienteServico clienteServico; 
	
	@Test
	public void contextLoads() {
		System.out.println(clienteServico.findById(1L));
	}

}
