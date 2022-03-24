package edu.infnet.applivraria.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.applivraria.model.domain.Escolar;

@Repository
public interface EscolarRepository extends CrudRepository<Escolar, Integer>{
	
	@Query("from Escolar e where e.usuario.id = :idUsuario")
	Collection<Escolar> findAll(Integer idUsuario, Sort by);
	
	Collection<Escolar> findAll(Sort by);
}
