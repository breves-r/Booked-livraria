package edu.infnet.applivraria.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.applivraria.model.domain.Escolar;

@Repository
public interface EscolarRepository extends CrudRepository<Escolar, Integer>{

}
