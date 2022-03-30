package edu.infnet.applivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.applivraria.model.domain.Informatica;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.InformaticaService;
import edu.infnet.applivraria.model.service.ProdutoService;

@Controller
public class InformaticaController {

	@Autowired
	private InformaticaService informaticaService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/informaticos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		model.addAttribute("informaticaLista", informaticaService.obterLista(usuario));
		return "informatica/lista";
	}

	@GetMapping(value = "/informatica")
	public String telaCadastro() {
		return "informatica/cadastro";
	}
	
	@PostMapping(value = "/informatica/incluir")
	public String incluir(Informatica informatica, @SessionAttribute("user") Usuario usuario) {
		
		informatica.setUsuario(usuario);
		
		produtoService.incluir(informatica);
		
		return "redirect:/informaticos";
	}
	
	@GetMapping(value = "/informatica/{id}/excluir")
	public String excluir(@PathVariable Integer id, @SessionAttribute("user") Usuario usuario, Model model) {

		
		Informatica informatica = (Informatica) produtoService.obterPorId(id);
		
		if(informatica != null) {
			try {
				produtoService.excluir(id);
			}catch(Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão. O livro está associado a um pedido"); 
				return telaLista(model, usuario);
			}
			
		}

		return "redirect:/informaticos";
	}
}
