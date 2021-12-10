package edu.infnet.applivraria.testes;

import edu.infnet.applivraria.domain.Livro;
import edu.infnet.applivraria.exceptions.ValorInvalidoException;

public class LivroTeste {
	public static void main(String[] args) {
		try {
			Livro livro = new Livro("A Casa na Montanha", "King Steph", 450, 70);
			
			livro.setGenero("Terror");
			livro.setClassificacaoEtaria(18);
			livro.setIlustrado(false);
			
			System.out.println(livro);
			System.out.println(livro.calcularValorFinal());
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Livro livro = new Livro("A Casa na Montanha", "King Steph", 450, -70);
			
			livro.setGenero("Terror");
			livro.setClassificacaoEtaria(18);
			livro.setIlustrado(false);
			
			System.out.println(livro);
			System.out.println(livro.calcularValorFinal());
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
