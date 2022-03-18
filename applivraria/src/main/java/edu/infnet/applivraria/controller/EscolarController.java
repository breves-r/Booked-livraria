package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.infnet.applivraria.model.domain.Escolar;
import edu.infnet.applivraria.model.service.EscolarService;
import edu.infnet.applivraria.model.service.ProdutoService;

@Controller
public class EscolarController {

	@Autowired
	private EscolarService escolarService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/escolares")
	public String telaLista(Model model) {
		model.addAttribute("escolarLista", escolarService.obterLista());
		return "escolar/lista";
	}

	@GetMapping(value = "/escolar")
	public String telaCadastro() {
		return "escolar/cadastro";
	}
	
	@PostMapping(value = "/escolar/incluir")
	public String incluir(Escolar escolar) {
		produtoService.incluir(escolar);
		
		return "redirect:/escolares";
	}
	
	@GetMapping(value = "/escolar/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		produtoService.excluir(id);

		return "redirect:/escolares";
	}
}
