package edu.infnet.applivraria.domain;

import edu.infnet.applivraria.exceptions.ClassificacaoEtariaInvalidaException;
import edu.infnet.applivraria.exceptions.ValorInvalidoException;

public class Livro extends Produto {
	private String genero;
	private int classificacaoEtaria;
	private boolean ilustrado;

	public Livro(String titulo, String autor, int qtdePaginas, float valor) throws ValorInvalidoException {
		super(titulo, autor, qtdePaginas, valor);
	}

	@Override
	public float calcularValorFinal() {
		return getValor() + (getQtdePaginas()>300 ? getValor()*0.15f : 0) + (ilustrado ? this.getValor()*0.25f : 0);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(genero);
		sb.append(";");
		sb.append(classificacaoEtaria);
		sb.append(";");
		sb.append(ilustrado);
		
		return sb.toString();
	};
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isIlustrado() {
		return ilustrado;
	}

	public void setIlustrado(boolean ilustrado) {
		this.ilustrado = ilustrado;
	}

	public int getClassificacaoEtaria() {
		return classificacaoEtaria;
	}

	public void setClassificacaoEtaria(int classificacaoEtaria) throws ClassificacaoEtariaInvalidaException {
		if(classificacaoEtaria<0) {
			throw new ClassificacaoEtariaInvalidaException("A classificação etária não pode ser negativa!");
		}
		
		this.classificacaoEtaria = classificacaoEtaria;
	}

}
