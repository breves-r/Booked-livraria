package edu.infnet.applivraria.testes;

import edu.infnet.applivraria.exceptions.ClassificacaoEtariaInvalidaException;
import edu.infnet.applivraria.exceptions.SerieInvalidaException;
import edu.infnet.applivraria.exceptions.ValorInvalidoException;
import edu.infnet.applivraria.model.domain.Escolar;
import edu.infnet.applivraria.model.domain.Informatica;
import edu.infnet.applivraria.model.domain.Livro;

public class ProdutoTeste {

	public static void main(String[] args) {
		try {
			Escolar escolar = new Escolar("Geografia geral e do Brasil", "Fulaninho",500, 350);
			escolar.setDisciplina("Geografia");
			escolar.setSerie(5);
			escolar.setTemRespostas(true);
			
			System.out.println(escolar);
		} catch (ValorInvalidoException | SerieInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			Informatica informatica = new Informatica("Java: Guia Avançado", "Elberth", 450, 380);
			
			informatica.setArea("Java");
			informatica.setEhAvancado(true);
			informatica.setEhProgramacao(true);
			
			System.out.println(informatica);
			
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			Livro livro = new Livro("A Casa na Montanha", "King Steph", 450, 70);
			
			livro.setGenero("Terror");
			livro.setClassificacaoEtaria(18);
			livro.setIlustrado(false);
			
			System.out.println(livro);
		} catch (ValorInvalidoException | ClassificacaoEtariaInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}

}
