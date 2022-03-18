package edu.infnet.applivraria.testes;

import java.util.ArrayList;
import java.util.List;

import edu.infnet.applivraria.exceptions.ClassificacaoEtariaInvalidaException;
import edu.infnet.applivraria.exceptions.ClienteNuloException;
import edu.infnet.applivraria.exceptions.CpfInvalidoException;
import edu.infnet.applivraria.exceptions.EmailInvalidoException;
import edu.infnet.applivraria.exceptions.NomeInvalidoException;
import edu.infnet.applivraria.exceptions.SerieInvalidaException;
import edu.infnet.applivraria.exceptions.TelefoneInvalidoException;
import edu.infnet.applivraria.exceptions.ValorInvalidoException;
import edu.infnet.applivraria.exceptions.listaProdutosInvalidaException;
import edu.infnet.applivraria.model.domain.Cliente;
import edu.infnet.applivraria.model.domain.Compra;
import edu.infnet.applivraria.model.domain.Escolar;
import edu.infnet.applivraria.model.domain.Informatica;
import edu.infnet.applivraria.model.domain.Livro;
import edu.infnet.applivraria.model.domain.Produto;

public class CompraTeste {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			Escolar escolar = new Escolar("Geografia geral e do Brasil", "Fulaninho",500, 350);
			escolar.setDisciplina("Geografia");
			escolar.setSerie(5);
			escolar.setTemRespostas(true);
			
			produtos.add(escolar);
		} catch (ValorInvalidoException | SerieInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			Informatica informatica = new Informatica("Java: Guia Avançado", "Elberth", 450, 380);
			
			informatica.setArea("Java");
			informatica.setEhAvancado(true);
			informatica.setEhProgramacao(true);
			
			produtos.add(informatica);
			
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Livro livro = new Livro("A Casa na Montanha", "King Steph", 450, 70);
			
			livro.setGenero("Terror");
			livro.setClassificacaoEtaria(18);
			livro.setIlustrado(false);
			
			produtos.add(livro);
		} catch (ValorInvalidoException | ClassificacaoEtariaInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		Cliente cliente = null;
		try {
			cliente = new Cliente("Rafaela","021999999999","rafaela@gmail.com","123.456.789-10");
			
		} catch (NomeInvalidoException | TelefoneInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
		

		try {
			Compra compra = new Compra(cliente);
			compra.setformaPagamento("Cartao");
			compra.setListaProdutos(produtos);
			
			compra.impressao();;
		} catch (ClienteNuloException | listaProdutosInvalidaException e) {
			System.out.println(e.getMessage());
		}

	}

}
