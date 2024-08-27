package com.example.cadastro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.model.Cliente;
import com.example.cadastro.repository.ClienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteConrtoller {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	  @GetMapping("/{id}")
	    public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long clienteId) {
	        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
	        if (cliente.isPresent()) {
	            return ResponseEntity.ok().body(cliente.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long clienteId,
	                                                 @Valid @RequestBody Cliente clienteDetails) {
	        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
	        if (clienteOptional.isPresent()) {
	            Cliente cliente = clienteOptional.get();
	            cliente.setNome(clienteDetails.getNome());
	            cliente.setSobrenome(clienteDetails.getSobrenome());
	            cliente.setIdade(clienteDetails.getIdade());
	            cliente.setCpf(clienteDetails.getCpf());
	            cliente.setTelefone(clienteDetails.getTelefone());
	            cliente.setEmail(clienteDetails.getEmail());
	            cliente.setEndereco(clienteDetails.getEndereco());
	            final Cliente updatedCliente = clienteRepository.save(cliente);
	            return ResponseEntity.ok(updatedCliente);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCliente(@PathVariable(value = "id") Long clienteId) {
	        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
	        if (clienteOptional.isPresent()) {
	            clienteRepository.delete(clienteOptional.get());
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}
