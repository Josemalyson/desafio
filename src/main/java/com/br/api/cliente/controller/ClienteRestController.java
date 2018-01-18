package com.br.api.cliente.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.cliente.model.Cliente;
import com.br.api.cliente.service.ClienteServico;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteRestController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1091191071262878519L;

	@Autowired
	private ClienteServico clienteServico;

	// http://localhost:8080/api/cliente/?page=0&size=5
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(Pageable pageable) {
		return new ResponseEntity<>(this.clienteServico.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Cliente> getId(@PathVariable("id") Long id) {
		return new ResponseEntity<>(this.clienteServico.findById(id), HttpStatus.OK);
	}

	@GetMapping("{id}/nome")
	public String getNome(@PathVariable("id") String id) {
		return id;
	}

	@PostMapping
	public ResponseEntity<Cliente> salveClient(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(this.clienteServico.save(cliente), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Cliente> editClient(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(this.clienteServico.edit(cliente), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable("id") Long id) {

		Cliente cliente = this.clienteServico.findById(id);

		if (cliente == null) {
			return new ResponseEntity<>(new Cliente(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(this.clienteServico.delete(cliente), HttpStatus.OK);
	}
}
