package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.applivraria.model.domain.Livro;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.LivroService;
import edu.infnet.applivraria.model.service.ProdutoService;

@Controller
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/livros")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("livroLista", livroService.obterLista(usuario));
		return "livro/lista";
	}

	@GetMapping(value = "/livro")
	public String telaCadastro() {
		return "livro/cadastro";
	}
	
	@PostMapping(value = "/livro/incluir")
	public String incluir(Livro livro, @SessionAttribute("user") Usuario usuario) {
		
		livro.setUsuario(usuario);
		
		produtoService.incluir(livro);
		
		return "redirect:/livros";
	}
	
	@GetMapping(value = "/livro/{id}/excluir")
	public String excluir(@PathVariable Integer id, @SessionAttribute("user") Usuario usuario, Model model) {

		
		Livro livro = (Livro) produtoService.obterPorId(id);
		
		if(livro != null) {
			try {
				produtoService.excluir(id);
			}catch(Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão. O livro está associado a um pedido"); 
				return telaLista(model, usuario);
			}
			
		}

		return "redirect:/livros";
	}
}
