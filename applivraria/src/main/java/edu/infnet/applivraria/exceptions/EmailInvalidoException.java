package edu.infnet.applivraria.exceptions;

public class EmailInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmailInvalidoException(String mensagem) {
		super(mensagem);
	}
}

