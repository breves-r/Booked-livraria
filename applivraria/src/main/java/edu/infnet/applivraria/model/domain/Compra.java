package edu.infnet.applivraria.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.infnet.applivraria.exceptions.ClienteNuloException;
import edu.infnet.applivraria.exceptions.listaProdutosInvalidaException;

@Entity
@Table(name = "TCompra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime data;
	private String formaPagamento;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idcliente")	
	private Cliente cliente;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Produto> listaProdutos;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	
	public Compra() {
		this.data = LocalDateTime.now();
		this.formaPagamento = "Dinheiro";
	}

	public Compra(Cliente cliente) throws ClienteNuloException {
		this();
		
		if (cliente == null) {
			throw new ClienteNuloException("A compra precisa estar associada a um cliente!");
		}
		
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



}
