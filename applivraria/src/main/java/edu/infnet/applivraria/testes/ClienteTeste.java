package edu.infnet.applivraria.testes;

import edu.infnet.applivraria.domain.Cliente;
import edu.infnet.applivraria.exceptions.CpfInvalidoException;
import edu.infnet.applivraria.exceptions.EmailInvalidoException;
import edu.infnet.applivraria.exceptions.NomeInvalidoException;
import edu.infnet.applivraria.exceptions.TelefoneInvalidoException;

public class ClienteTeste {

	public static void main(String[] args) {
		try {
			Cliente cliente = new Cliente("Rafaela","021999999999","rafaela@gmail.com","123.456.789-10");
			System.out.println(cliente);
		} catch (NomeInvalidoException | TelefoneInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			Cliente cliente = new Cliente(null,"021999999999","rafaela@gmail.com","123.456.789-10");
			System.out.println(cliente);
		} catch (NomeInvalidoException | TelefoneInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Cliente cliente = new Cliente("Rafaela",null,"rafaela@gmail.com","123.456.789-10");
			System.out.println(cliente);
		} catch (NomeInvalidoException | TelefoneInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

}
