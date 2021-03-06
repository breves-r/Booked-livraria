package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.applivraria.model.domain.Escolar;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.EscolarService;
import edu.infnet.applivraria.model.service.ProdutoService;

@Controller
public class EscolarController {

	@Autowired
	private EscolarService escolarService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/escolares")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("escolarLista", escolarService.obterLista(usuario));
		return "escolar/lista";
	}

	@GetMapping(value = "/escolar")
	public String telaCadastro() {
		return "escolar/cadastro";
	}
	
	@PostMapping(value = "/escolar/incluir")
	public String incluir(Escolar escolar, @SessionAttribute("user") Usuario usuario) {
		
		escolar.setUsuario(usuario);
		
		produtoService.incluir(escolar);
		
		return "redirect:/escolares";
	}
	
	@GetMapping(value = "/escolar/{id}/excluir")
	public String excluir(@PathVariable Integer id,  @SessionAttribute("user") Usuario usuario, Model model) {

		
		Escolar escolar = (Escolar) produtoService.obterPorId(id);
		
		if(escolar != null) {
			try {
				produtoService.excluir(id);
			}catch(Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão. O livro está associado a um pedido"); 
				return telaLista(model, usuario);
			}
			
		}
		
		
		return "redirect:/escolares";
	}
}
