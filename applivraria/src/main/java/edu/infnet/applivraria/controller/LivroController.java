package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.infnet.applivraria.model.domain.Livro;
import edu.infnet.applivraria.model.service.LivroService;
import edu.infnet.applivraria.model.service.ProdutoService;

@Controller
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/livros")
	public String telaLista(Model model) {
		model.addAttribute("livroLista", livroService.obterLista());
		return "livro/lista";
	}

	@GetMapping(value = "/livro")
	public String telaCadastro() {
		return "livro/cadastro";
	}
	
	@PostMapping(value = "/livro/incluir")
	public String incluir(Livro livro) {
		produtoService.incluir(livro);
		
		return "redirect:/livros";
	}
	
	@GetMapping(value = "/livro/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		produtoService.excluir(id);

		return "redirect:/livros";
	}
}
