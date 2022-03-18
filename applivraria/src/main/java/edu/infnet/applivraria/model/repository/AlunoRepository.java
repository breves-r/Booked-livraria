package edu.infnet.applivraria.model.repository;

import org.springframework.stereotype.Repository;

import edu.infnet.applivraria.model.domain.Aluno;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
	
	@Query("from Aluno a where a.usuario.id = :idUsuario")
	public List<Aluno> obterLista(Integer idUsuario);

}
