package edu.infnet.applivraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.infnet.applivraria.model.domain.Aluno;
import edu.infnet.applivraria.model.service.AlunoService;

@Component
public class AlunoLoader implements ApplicationRunner{

	@Autowired
	private AlunoService alunoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		String[] disciplinas = {"java", "web", "poo"};
		
		Aluno aluno = new Aluno("Maria", "maria@maria");
		aluno.setIdade(20);
		aluno.setMensalidade(1000);
		aluno.setCurso("G");
		aluno.setRegiao("S");
		aluno.setDisciplinas(disciplinas);
		
		alunoService.incluir(aluno); 
		
	}

}
