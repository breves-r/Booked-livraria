package edu.infnet.applivraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import edu.infnet.applivraria.model.domain.Escolar;
import edu.infnet.applivraria.model.domain.Informatica;
import edu.infnet.applivraria.model.domain.Livro;
import edu.infnet.applivraria.model.domain.Usuario;
import edu.infnet.applivraria.model.service.ProdutoService;

@Order(3)
@Component
public class ProdutoLoader implements ApplicationRunner{

	@Autowired
	private ProdutoService produtoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Escolar escolar = new Escolar("Geografia geral e do Brasil", "Fulaninho",500, 350);
		escolar.setDisciplina("Geografia");
		escolar.setSerie(5);
		escolar.setTemRespostas(true);
		escolar.setUsuario(usuario);
		produtoService.incluir(escolar);
		
		Informatica informatica = new Informatica("Java: Guia Avançado", "Elberth", 450, 380);
		informatica.setArea("Java");
		informatica.setEhAvancado(true);
		informatica.setEhProgramacao(true);
		informatica.setUsuario(usuario);
		produtoService.incluir(informatica);
		
		Livro livro = new Livro("A Casa na Montanha", "King Steph", 450, 70);
		livro.setGenero("Terror");
		livro.setClassificacaoEtaria(18);
		livro.setIlustrado(false);
		livro.setUsuario(usuario);
		produtoService.incluir(livro);
		
	}

	
}
