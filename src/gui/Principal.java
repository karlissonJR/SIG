package gui;

import dao.Conexao;

public class Principal {

	public static void main(String[] args) {
		Janela.run(args);
		Conexao.encerrar();
	}
	
}
