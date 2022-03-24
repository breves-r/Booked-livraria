package edu.infnet.applivraria.model.repository;

import org.springframework.stereotype.Repository;

import edu.infnet.applivraria.model.domain.Cliente;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
	
	@Query("from Cliente c where c.usuario.id = :idUsuario")
	public List<Cliente> obterLista(Integer idUsuario, Sort sort);

}
