package edu.infnet.applivraria.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.applivraria.model.domain.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Integer>{
	
	@Query("from Compra c where c.usuario.id = :idUsuario")
	Collection<Compra> findAll(Integer idUsuario, Sort by);

	Collection<Compra> findAll(Sort by);

}
