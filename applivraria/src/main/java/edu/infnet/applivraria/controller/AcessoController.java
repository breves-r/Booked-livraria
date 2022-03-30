 package edu.infnet.applivraria.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.ClienteService;
import edu.infnet.applivraria.model.service.CompraService;
import edu.infnet.applivraria.model.service.ProdutoService;
import edu.infnet.applivraria.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AcessoController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CompraService compraService;

	@GetMapping(value = "/")
	public String telaHome(Model model) {
		
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		
		mapa.put("Clientes", clienteService.obterQtde());
		mapa.put("Produtos", produtoService.obterQtde());
		mapa.put("Compras", compraService.obterQtde());
		
		model.addAttribute("mapa", mapa);
		
		return "home";		
	}
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";		
	} 
	
	@GetMapping(value = "/logout")
	public String logout(SessionStatus status, HttpSession session) {
		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/";		
	}


	@PostMapping(value = "/login")
	public String validar(Model model, @RequestParam String email, @RequestParam String senha){
		
		Usuario usuario = usuarioService.autenticacao(email, senha);

		if(usuario != null) {
			model.addAttribute("user", usuario);
			return "redirect:/";
		} else {
			model.addAttribute(
					"mensagem", 
					"As credenciais do usuário "+email+" estão incorretas!!!"
				);

			return telaLogin();
		}	

	}
} 
