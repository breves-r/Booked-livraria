package edu.infnet.applivraria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.infnet.applivraria.model.domain.Compra;
import edu.infnet.applivraria.model.domain.Produto;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.ClienteService;
import edu.infnet.applivraria.model.service.CompraService;
import edu.infnet.applivraria.model.service.ProdutoService;

@Controller
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProdutoService produtoService;

	
	@GetMapping(value = "/compras")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("compraLista", compraService.obterLista(usuario));

		return "compra/lista";
	}
	
	@GetMapping(value = "/compra")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("clienteLista", clienteService.obterLista(usuario));

		model.addAttribute("produtoLista", produtoService.obterLista(usuario));

		return "compra/cadastro";
	}
	
	@PostMapping(value = "/compra/incluir")
	public String incluir(@RequestParam String[] idsProdutos, Compra compra, @SessionAttribute("user") Usuario usuario){

		List<Produto> produtos = new ArrayList<Produto>();

		for(String idProduto : idsProdutos) {

			Produto produto = produtoService.obterPorId(Integer.valueOf(idProduto));

			produtos.add(produto);
		}

		compra.setUsuario(usuario);

		compra.setListaProdutos(produtos);

		compraService.incluir(compra);

		return "redirect:/compras";
	}
	
	@GetMapping(value = "/compra/{id}/excluir")
	public String excluir(@PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Compra compra = compraService.obterPorId(id);

		if(compra != null) {			
			compraService.excluir(id);
		}

		return "redirect:/compras";
	}

	
	
}
