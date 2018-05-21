package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
	
	private static Connection conexao;
	private static Conexao instancia = null;
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sig";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	private Conexao(){		
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conexao iniciada");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static Connection iniciar() {
		
		if(instancia == null)
			instancia = new Conexao();
		
		return conexao;
	}
	
	public static void encerrar() {
		if(conexao != null) {
			try {
				conexao.close();
				System.out.println("Conexao encerrada");
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}