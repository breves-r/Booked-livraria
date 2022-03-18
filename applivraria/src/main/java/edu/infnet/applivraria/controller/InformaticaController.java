package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.infnet.applivraria.model.domain.Informatica;
import edu.infnet.applivraria.model.service.InformaticaService;
import edu.infnet.applivraria.model.service.ProdutoService;

@Controller
public class InformaticaController {

	@Autowired
	private InformaticaService informaticaService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/informaticos")
	public String telaLista(Model model) {
		model.addAttribute("informaticaLista", informaticaService.obterLista());
		return "informatica/lista";
	}

	@GetMapping(value = "/informatica")
	public String telaCadastro() {
		return "informatica/cadastro";
	}
	
	@PostMapping(value = "/informatica/incluir")
	public String incluir(Informatica informatica) {
		produtoService.incluir(informatica);
		
		return "redirect:/informaticos";
	}
	
	@GetMapping(value = "/informatica/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		produtoService.excluir(id);

		return "redirect:/informaticos";
	}
}