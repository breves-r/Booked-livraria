package edu.infnet.applivraria.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.applivraria.model.domain.Livro;
import edu.infnet.applivraria.model.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public Collection<Livro> obterLista() {
		return (Collection<Livro>) livroRepository.findAll(); 
	}
}
