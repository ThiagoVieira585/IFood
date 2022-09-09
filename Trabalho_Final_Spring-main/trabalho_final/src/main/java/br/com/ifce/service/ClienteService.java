package br.com.ifce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifce.model.Cliente;
import br.com.ifce.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository; 
	
	public void cadastrarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	
}
