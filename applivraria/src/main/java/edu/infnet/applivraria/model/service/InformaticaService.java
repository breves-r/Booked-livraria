package edu.infnet.applivraria.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.applivraria.model.domain.Informatica;
import edu.infnet.applivraria.model.repository.InformaticaRepository;

@Service
public class InformaticaService {

	@Autowired
	private InformaticaRepository informaticaRepository;
	
	public Collection<Informatica> obterLista() {
		return (Collection<Informatica>) informaticaRepository.findAll(); 
	}
}
