package edu.infnet.applivraria.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.applivraria.model.domain.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer>{
	
	@Query("from Livro l where l.usuario.id = :idUsuario")
	Collection<Livro> findAll(Integer idUsuario, Sort by);
	
	Collection<Livro> findAll(Sort by);

}
