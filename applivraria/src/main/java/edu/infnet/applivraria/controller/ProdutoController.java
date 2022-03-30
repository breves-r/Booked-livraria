package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.applivraria.model.domain.Produto;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/produtos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("produtoLista", produtoService.obterLista(usuario));
		return "produto/lista";
	}


	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(@PathVariable Integer id, @SessionAttribute("user") Usuario usuario, Model model) {
		
		Produto produto = produtoService.obterPorId(id);
		
		if(produto != null) {
			try {
				produtoService.excluir(id);
			}catch(Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão. O produto está associado a um pedido"); 
				return telaLista(model, usuario);
			}
			
		}

		return "redirect:/produtos";
	}
}
