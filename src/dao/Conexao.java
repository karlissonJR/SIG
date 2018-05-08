package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Connection conexao;
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sig";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	private Conexao(){
		
	}
	
	public static void iniciar(Connection conexao) {
		
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//return conexao;
	}
	
	public static void encerrar(Connection conexao) {
		if(conexao != null) {
			try {
				conexao.close();
				conexao = null;
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}