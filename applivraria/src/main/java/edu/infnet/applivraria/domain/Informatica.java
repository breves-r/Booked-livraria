package edu.infnet.applivraria.domain;

import edu.infnet.applivraria.exceptions.ValorInvalidoException;

public class Informatica extends Produto {
	private String area;
	private boolean ehProgramacao;
	private boolean ehAvancado;
	

	public Informatica(String titulo, String autor, int qtdePaginas, float valor) throws ValorInvalidoException {
		super(titulo, autor, qtdePaginas, valor);
	}

	@Override
	public float calcularValorFinal() {
		return getValor() + (ehProgramacao ? getValor()*0.10f : 0) + (ehAvancado ? this.getValor()*0.25f : 0);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(area);
		sb.append(";");
		sb.append(ehProgramacao);
		sb.append(";");
		sb.append(ehAvancado);
		
		return sb.toString();
	};

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public boolean getEhProgramacao() {
		return ehProgramacao;
	}

	public void setEhProgramacao(boolean ehProgramacao) {
		this.ehProgramacao = ehProgramacao;
	}

	public boolean getEhAvancado() {
		return ehAvancado;
	}

	public void setEhAvancado(boolean ehAvancado) {
		this.ehAvancado = ehAvancado;
	}

}
