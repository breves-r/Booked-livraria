package edu.infnet.applivraria.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Compra {
	private LocalDateTime data;
	private Cliente cliente;
	private String formaPagamento;
	private List<Produto> listaProdutos;

	
	public Compra() {
		this.data = LocalDateTime.now();
		this.formaPagamento = "Dinheiro";
	}

	public String toString() {
		DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return String.format("%s;%s;%s;%d",
				this.data.format(formatacao),
				this.formaPagamento,
				this.cliente,
				listaProdutos.size());
		
	}

	public LocalDateTime getData() {
		return data;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
