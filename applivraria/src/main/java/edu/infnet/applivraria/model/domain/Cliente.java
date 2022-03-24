package edu.infnet.applivraria.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.infnet.applivraria.exceptions.CpfInvalidoException;
import edu.infnet.applivraria.exceptions.EmailInvalidoException;
import edu.infnet.applivraria.exceptions.NomeInvalidoException;
import edu.infnet.applivraria.exceptions.TelefoneInvalidoException;

@Entity
@Table(name = "TCliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	public Cliente() {
		
	}
	
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
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	};
	
	
	

}
