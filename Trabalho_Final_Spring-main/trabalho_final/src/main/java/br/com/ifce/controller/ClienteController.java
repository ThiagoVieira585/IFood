package br.com.ifce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifce.model.Cliente;
import br.com.ifce.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/cadastrar")
	public String cadastrarCliente(Cliente cliente){
		
		return "formularioCliente";
	}
	@RequestMapping("/salvar")
	public String salvarCliente(Cliente cliente) {
		clienteService.cadastrarCliente(cliente);
		return "home";
		
	}
	
	

	
}
