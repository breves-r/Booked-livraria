package edu.infnet.applivraria.testes;

import edu.infnet.applivraria.exceptions.SerieInvalidaException;
import edu.infnet.applivraria.exceptions.ValorInvalidoException;
import edu.infnet.applivraria.model.domain.Escolar;

public class EscolarTeste {

	public static void main(String[] args) {
		try {
			Escolar escolar = new Escolar("Geografia geral e do Brasil", "Fulaninho",500, 350);
			escolar.setDisciplina("Geografia");
			escolar.setSerie(5);
			escolar.setTemRespostas(true);
			
			System.out.println(escolar);
			System.out.println(escolar.calcularValorFinal());
		} catch (ValorInvalidoException | SerieInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Escolar escolar = new Escolar("Geografia geral e do Brasil", "Fulaninho",500, 0);
			escolar.setDisciplina("Geografia");
			escolar.setSerie(5);
			escolar.setTemRespostas(true);
			
			System.out.println(escolar);
			System.out.println(escolar.calcularValorFinal());
		} catch (ValorInvalidoException | SerieInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Escolar escolar = new Escolar("Geografia geral e do Brasil", "Fulaninho",500, 350);
			escolar.setDisciplina("Geografia");
			escolar.setSerie(0);
			escolar.setTemRespostas(true);
			
			System.out.println(escolar);
			System.out.println(escolar.calcularValorFinal());
		} catch (ValorInvalidoException | SerieInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}
}
