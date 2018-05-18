package model;

public class Funcionario {

	private String cpf;
	private String nome;
	private String telefone;
	private String senha;
	
	public Funcionario(String cpf, String nome, String telefone, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.senha = senha;
	}
	
	public String getCpf() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return this.senha;
	}
}
