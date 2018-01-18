package com.br.api.cliente.cliente;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.api.cliente.model.Cliente;
import com.br.api.cliente.repository.ClienteRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ClienteApplicationDataTests {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	public void contextLoads() {
		Cliente cliente = new Cliente();
		cliente.setCpf("000000");
		cliente.setEmail("email@gmail.com");
		cliente.setNome("jose");
		
		
		Cliente clienteBD = entityManager.persist(cliente);
		assertEquals(clienteRepository.findOne(clienteBD.getId()).getId(), clienteBD.getId());
	}

}
