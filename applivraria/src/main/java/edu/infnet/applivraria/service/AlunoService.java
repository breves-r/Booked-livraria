package edu.infnet.applivraria.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.infnet.applivraria.domain.Aluno;
import edu.infnet.applivraria.domain.Usuario;
import edu.infnet.applivraria.repository.AlunoRepository;


@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	public Collection<Aluno> obterLista(Usuario usuario){		
		return (Collection<Aluno>) alunoRepository.obterLista(usuario.getId());
	}
	
	public Collection<Aluno> obterLista(){
		return (Collection<Aluno>) alunoRepository.findAll();
	}
	
	public Aluno incluir(Aluno aluno){
		return alunoRepository.save(aluno);
	}
	
	public void excluir(Integer id){
		alunoRepository.deleteById(id);
 	}
	
	public Aluno obterPorId(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}
}

