package com.br.api.cliente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.api.cliente.model.Cliente;
import com.br.api.cliente.repository.ClienteRepository;
import com.br.api.cliente.service.ClienteServico;

@Service
public class ClienteServiceImpl implements ClienteServico {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1130555286700138028L;

	@Autowired
	public ClienteRepository clienteRepository;

	@Override
	public Cliente findById(Long id) {
		return this.clienteRepository.findOne(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente edit(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
		return cliente;
	}

	@Override
	public List<Cliente> findAll(Pageable pageable) {
		return this.clienteRepository.findAll(pageable).getContent();
	}

	@Override
	public String findByNome(String nome) {
		return this.clienteRepository.findByNome(nome);
	}

}
