package edu.infnet.applivraria.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.applivraria.model.domain.Informatica;

@Repository
public interface InformaticaRepository extends CrudRepository<Informatica, Integer>{
	
	@Query("from Informatica i where i.usuario.id = :idUsuario")
	Collection<Informatica> findAll(Integer idUsuario, Sort by);
	
	Collection<Informatica> findAll(Sort by);

}
