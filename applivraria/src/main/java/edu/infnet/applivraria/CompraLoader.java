package edu.infnet.applivraria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import edu.infnet.applivraria.model.domain.Cliente;
import edu.infnet.applivraria.model.domain.Compra;
import edu.infnet.applivraria.model.domain.Produto;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.CompraService;
import edu.infnet.applivraria.model.service.ProdutoService;

@Order(4)
@Component
public class CompraLoader implements ApplicationRunner{
	
	@Autowired
	private CompraService compraService;
	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<Produto> produtos = new ArrayList<Produto>(
				produtoService.obterLista()
			);

		Cliente cliente = new Cliente();
		cliente.setId(1);
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Compra compra = new Compra(cliente);
		compra.setFormaPagamento("Cartão");
		compra.setListaProdutos(produtos);
		compra.setUsuario(usuario);
		
		compraService.incluir(compra); 
		
	}

}
