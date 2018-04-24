package model;

public class Produto {
	
	private String codigo;
	private String nome;
	private double preco;
	private String tipo;
	private int quantidade;
	private String validade;
	private String codigoEstoque;
	
	public Produto(String codigo, String nome, double preco, String tipo, int quantidade, String validade, String codigoEstoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.validade = validade;
		this.codigoEstoque = codigoEstoque;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getValidade() {
		return this.validade;
	}

	public String getCodigoEstoque() {
		return this.codigoEstoque;
	}
	
	

}
