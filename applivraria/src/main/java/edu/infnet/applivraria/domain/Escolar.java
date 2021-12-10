package edu.infnet.applivraria.domain;

import edu.infnet.applivraria.exceptions.ValorInvalidoException;

public class Escolar extends Produto {
	private String disciplina;
	private int serie;
	private boolean temRespostas;

	public Escolar(String titulo, String autor, int qtdePaginas, float valor) throws ValorInvalidoException {
		super(titulo, autor, qtdePaginas, valor);
	}

	@Override
	public float calcularValorFinal() {
		return getValor() + (temRespostas ? getValor()*0.10f : 0);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(disciplina);
		sb.append(";");
		sb.append(serie);
		sb.append(";");
		sb.append(temRespostas);
		
		return sb.toString();
	};

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public boolean isTemRespostas() {
		return temRespostas;
	}

	public void setTemRespostas(boolean temRespostas) {
		this.temRespostas = temRespostas;
	}

}
