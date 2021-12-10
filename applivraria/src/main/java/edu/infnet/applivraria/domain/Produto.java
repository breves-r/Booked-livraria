package edu.infnet.applivraria.domain;

import edu.infnet.applivraria.exceptions.ValorInvalidoException;

public abstract class Produto {
	
	private String titulo;
	private String autor;
	private int qtdePaginas;
	protected float valor;
	
	public Produto(String titulo, String autor, int qtdePaginas, float valor) throws ValorInvalidoException {
		if(valor<=0) {
			throw new ValorInvalidoException("O valor do produto não pode ser zerado ou negativo!");
		}
		
		this.titulo = titulo;
		this.autor = autor;
		this.qtdePaginas = qtdePaginas;
		this.valor = valor;
	}
	
	public abstract float calcularValorFinal();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(titulo);
		sb.append(";");
		sb.append(autor);
		sb.append(";");
		sb.append(qtdePaginas);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(this.calcularValorFinal());
		
		return sb.toString();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getQtdePaginas() {
		return qtdePaginas;
	}

	public float getValor() {
		return valor;
	}
	

}
