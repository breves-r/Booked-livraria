package edu.infnet.applivraria.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.infnet.applivraria.model.domain.Informatica;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.repository.InformaticaRepository;

@Service
public class InformaticaService {

	@Autowired
	private InformaticaRepository informaticaRepository;
	
	public Collection<Informatica> obterLista(Usuario usuario) {
		return (Collection<Informatica>) informaticaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "titulo")); 
	}
	
	public Collection<Informatica> obterLista() {
		return (Collection<Informatica>) informaticaRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo")); 
	}
}
