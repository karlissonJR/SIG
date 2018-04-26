package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Conexao instancia = null;
	private static Connection conexao;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sig";
	private static final String USUARIO = "root";
	private static final String SENHA = "c8LcAG0rs";
	
	private Conexao(){
		
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			instancia = null;
		}
		
	}
	
	public static Conexao getConexao() {
		if(instancia == null)
			instancia = new Conexao();
		
		return instancia;
	}
	
	public static void encerrar() {
		if(conexao != null) {
			try {
				conexao.close();
				conexao = null;
				instancia = null;
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}