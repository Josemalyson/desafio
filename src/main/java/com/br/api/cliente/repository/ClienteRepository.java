package com.br.api.cliente.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.br.api.cliente.model.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

	String findByNome(String nome);

}
