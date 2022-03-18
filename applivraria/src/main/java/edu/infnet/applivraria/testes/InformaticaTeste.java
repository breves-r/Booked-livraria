package edu.infnet.applivraria.testes;

import edu.infnet.applivraria.exceptions.ValorInvalidoException;
import edu.infnet.applivraria.model.domain.Informatica;

public class InformaticaTeste {

	public static void main(String[] args) {
		try {
			Informatica informatica = new Informatica("Java: Guia Avançado", "Elberth", 450, 380);
			
			informatica.setArea("Java");
			informatica.setEhAvancado(true);
			informatica.setEhProgramacao(true);
			
			System.out.println(informatica);
			System.out.println(informatica.calcularValorFinal());
			
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Informatica informatica = new Informatica("Java: Guia Avançado", "Elberth", 450, -380);
			
			informatica.setArea("Java");
			informatica.setEhAvancado(true);
			informatica.setEhProgramacao(true);
			
			System.out.println(informatica);
			System.out.println(informatica.calcularValorFinal());
			
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

}
