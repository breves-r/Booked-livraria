package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.infnet.applivraria.model.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/produtos")
	public String telaLista(Model model) {
		model.addAttribute("produtoLista", produtoService.obterLista());
		return "produto/lista";
	}

	@PostMapping(value = "/produto/incluir")
	public String incluir() {
		System.out.println("Inclusão realizada com sucesso!!!");

		return "redirect:/";
	}

	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		produtoService.excluir(id);

		return "redirect:/produtos";
	}
}
