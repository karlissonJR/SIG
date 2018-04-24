package model;

public class Estoque {
	
	private String codigo;
	private String nome;
	private String tipo;
	private int capacidade;
	
	public Estoque(String codigo, String nome, String tipo, int capacidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.capacidade = capacidade;
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

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCapacidade() {
		return this.capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

}
