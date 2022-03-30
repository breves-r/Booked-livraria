package edu.infnet.applivraria.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.infnet.applivraria.model.domain.Compra;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository compraRepository;
	
	public Collection<Compra> obterLista(Usuario usuario){		
		return (Collection<Compra>) compraRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "data"));
	}

	public Collection<Compra> obterLista(){		
		return (Collection<Compra>) compraRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}

	public Compra incluir(Compra compra){
		return compraRepository.save(compra);
	}

	public void excluir(Integer id) {
		compraRepository.deleteById(id);
	}

	public Compra obterPorId(Integer id) {
		return compraRepository.findById(id).orElse(null);
	}
	
	public Integer obterQtde() {
		return (int) compraRepository.count();
	}

}
