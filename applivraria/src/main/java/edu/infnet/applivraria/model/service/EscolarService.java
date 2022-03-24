package edu.infnet.applivraria.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.infnet.applivraria.model.domain.Escolar;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.repository.EscolarRepository;

@Service
public class EscolarService {

	@Autowired
	private EscolarRepository escolarRepository;
	
	public Collection<Escolar> obterLista(Usuario usuario) {
		return (Collection<Escolar>) escolarRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "titulo")); 
	}	
	
	public Collection<Escolar> obterLista() {
		return (Collection<Escolar>) escolarRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo")); 
	}
}
