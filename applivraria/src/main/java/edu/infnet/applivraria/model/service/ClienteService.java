package edu.infnet.applivraria.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.infnet.applivraria.model.domain.Cliente;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Collection<Cliente> obterLista(Usuario usuario){		
		return (Collection<Cliente>) clienteRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public Collection<Cliente> obterLista(){
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente incluir(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Integer id){
		clienteRepository.deleteById(id);
 	}
	
	public Cliente obterPorId(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
}

