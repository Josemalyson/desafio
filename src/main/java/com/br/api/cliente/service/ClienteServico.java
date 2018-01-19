package com.br.api.cliente.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.br.api.cliente.model.Cliente;

public interface ClienteServico extends Serializable {

	public Cliente findById(Long id);

	public Cliente save(Cliente cliente);

	public Cliente edit(Cliente cliente);

	public Cliente delete(Cliente cliente);

	public List<Cliente> findAll(Pageable pageable);

	public String findByNome(String nome);
}
