package br.com.ifce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/login/cliente")
	public ModelAndView loginCliente(Cliente cliente) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@GetMapping("/logar")
	public String loginCliente(Model model, Cliente cliente) {
		Cliente cli = this.clienteService.Login(cliente.getEmail(),cliente.getSenha());
		if(cli !=null) {
			return "redirect/home";
		}
		model.addAttribute("Erro", "Email ou senha invalido");
		return "login";
	}
	@GetMapping("/login")
	public ModelAndView login( Cliente cliente) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cliente", new Cliente());
		Cliente cliLogin = clienteService.Login(cliente.getEmail(), cliente.getSenha());
		if(cliLogin==null) {
			mv.addObject("msg","Usuario não encontrado");
		}
		else {
			return mv.addObject("msg", "Pqp");
		}
		return mv;
	}
	
}
