package edu.infnet.applivraria.model.domain;

import edu.infnet.applivraria.exceptions.CpfInvalidoException;
import edu.infnet.applivraria.exceptions.EmailInvalidoException;
import edu.infnet.applivraria.exceptions.NomeInvalidoException;
import edu.infnet.applivraria.exceptions.TelefoneInvalidoException;

public class Cliente {
	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	
	public Cliente(String nome, String telefone, String email, String cpf) throws NomeInvalidoException, TelefoneInvalidoException, EmailInvalidoException, CpfInvalidoException {
		if(nome == null) {
			throw new NomeInvalidoException("O preenchimento do nome é obrigatório!");
		}
		
		if(telefone == null) {
			throw new TelefoneInvalidoException("O preenchimento do telefone é obrigatório!");
		}
		
		if(email == null) {
			throw new EmailInvalidoException("O preenchimento do email é obrigatório!");
		}
		
		if(cpf == null) {
			throw new CpfInvalidoException("O preenchimento do cpf é obrigatório!");
		}
		
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(telefone);
		sb.append(";");
		sb.append(email);
		sb.append(";");
		sb.append(cpf);
		
		return sb.toString();
	};
	
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}
	
	
	
	
	
	

}
