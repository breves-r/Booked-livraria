package edu.infnet.applivraria.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.infnet.applivraria.exceptions.ValorInvalidoException;


@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String autor;
	private int qtdePaginas;
	protected float valor;
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToMany(mappedBy = "listaProdutos")
	private List<Compra> compras;
	
	public Produto() {
	}
	
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
		sb.append(id);
		sb.append(";");
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setQtdePaginas(int qtdePaginas) {
		this.qtdePaginas = qtdePaginas;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	

}
