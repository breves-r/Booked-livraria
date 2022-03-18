package edu.infnet.applivraria.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.applivraria.model.domain.Produto;
import edu.infnet.applivraria.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}

	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}

	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}

	public Collection<Produto> obterLista() {
		return (Collection<Produto>) produtoRepository.findAll(); 
	}
	
	
}
