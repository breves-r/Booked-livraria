package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.applivraria.model.domain.Cliente;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/cliente")
	public String telaCadastro() {
		return "cliente/cadastro";
	}
	
	@GetMapping(value = "/clientes")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("clienteLista", clienteService.obterLista(usuario));
		return "cliente/lista";
	}

	@PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente, Model model, @SessionAttribute("user") Usuario usuario){
		
		cliente.setUsuario(usuario);
		
		clienteService.incluir(cliente);
		
		model.addAttribute("mensagem", "O cliente " + cliente.getNome() + " foi incluído com sucesso!!!");

		return "redirect:/clientes";
		//return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/cliente/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Cliente cliente = clienteService.obterPorId(id);
		
		if(cliente != null) {
			try {
				clienteService.excluir(id);
			}catch(Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão. O cliente está associado a um pedido"); 
				return telaLista(model, usuario);
			}
			
		}
		
		return "redirect:/clientes";
		//return telaLista(model, usuario);
	} 

} 
