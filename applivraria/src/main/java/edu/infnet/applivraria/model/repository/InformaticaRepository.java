package edu.infnet.applivraria.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.infnet.applivraria.model.domain.Informatica;

@Repository
public interface InformaticaRepository extends CrudRepository<Informatica, Integer>{

}
