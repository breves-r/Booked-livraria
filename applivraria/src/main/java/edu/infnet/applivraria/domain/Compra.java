package edu.infnet.applivraria.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import edu.infnet.applivraria.exceptions.ClienteNuloException;
import edu.infnet.applivraria.exceptions.listaProdutosInvalidaException;

public class Compra {
	private LocalDateTime data;
	private Cliente cliente;
	private String formaPagamento;
	private List<Produto> listaProdutos;

	public Compra(Cliente cliente) throws ClienteNuloException {
		if (cliente == null) {
			throw new ClienteNuloException("A compra precisa estar associada a um cliente!");
		}

		this.data = LocalDateTime.now();
		this.formaPagamento = "Boleto";
		this.cliente = cliente;
	}

	public String toString() {
		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		return String.format("%s;%s;%s;%d", this.data.format(formatacao), this.formaPagamento, this.cliente,
				listaProdutos.size());

	}

	public void impressao() throws listaProdutosInvalidaException {

		if (listaProdutos == null) {
			throw new listaProdutosInvalidaException("Não há produtos associados a compra!");
		}

		if (listaProdutos.size() == 0) {
			throw new listaProdutosInvalidaException("Não há produtos associados a compra!");
		}

		System.out.println("Relatório:");
		System.out.println(this);
		System.out.println("Produtos:");
		for (Produto p : listaProdutos) {
			System.out.println("- " + p);
		}
	}

	public float calcularValorCompra() {

		float valorTotal = 0;

		for (Produto p : listaProdutos) {
			valorTotal = valorTotal + p.calcularValorFinal();
		}

		return valorTotal;
	}

	public String obterLinhaGravacaoArquivo() {

		StringBuilder sb = new StringBuilder();
		sb.append(formaPagamento);
		sb.append(";");
		sb.append(cliente.getNome());
		sb.append(";");
		sb.append(listaProdutos.size());
		sb.append(";");
		sb.append(calcularValorCompra());
		sb.append("\r\n");

		return sb.toString();
	}

	public LocalDateTime getData() {
		return data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getformaPagamento() {
		return formaPagamento;
	}

	public void setformaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
