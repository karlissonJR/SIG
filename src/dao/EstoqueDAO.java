package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Estoque;

public class EstoqueDAO {

	private Connection conexao;
	
	public void salvar(Estoque estoque) {
		
		String sql = "INSERT INTO estoque (codigo,nome,tipo,capacidade) VALUES (?,?,?,?)";	
		PreparedStatement stmt;
		
		conexao = Conexao.iniciar();
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, estoque.getCodigo());
			stmt.setString(2, estoque.getNome());
			stmt.setString(3, estoque.getTipo());
			stmt.setInt(4, estoque.getCapacidade());
			
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
		
	}
	
	public ArrayList<Estoque> listar(){
		
		String sql = "SELECT * FROM estoque";
		PreparedStatement stmt;
		ResultSet rs;
		
		ArrayList<Estoque> estoques = new ArrayList<>();
		
		conexao = Conexao.iniciar();
		
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				String codigo = rs.getString("codigo");
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo");
				int capacidade = rs.getInt("capacidade");
				
				Estoque estoque = new Estoque(codigo, nome, tipo, capacidade);
				estoques.add(estoque);
				
			}
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
		
		return estoques;
		
	}
	
	public ArrayList<Estoque> listarPorTipo(String tipoEscolhido){
		
		String sql = "SELECT * FROM estoque WHERE tipo = ?";
		PreparedStatement stmt;
		ResultSet rs;
		
		ArrayList<Estoque> estoques = new ArrayList<>();
		
		conexao = Conexao.iniciar();
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, tipoEscolhido);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				String codigo = rs.getString("codigo");
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo");
				int capacidade = rs.getInt("capacidade");
				
				Estoque estoque = new Estoque(codigo, nome, tipo, capacidade);
				estoques.add(estoque);
				
			}
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
		
		return estoques;
		
	}
	
	public void atualizar(Estoque estoque) {
		
		conexao = Conexao.iniciar();
		
		String sql = "UPDATE estoque SET nome = ?, tipo = ?, capacidade = ? WHERE codigo = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, estoque.getNome());
			stmt.setString(2, estoque.getTipo());
			stmt.setInt(3, estoque.getCapacidade());
			stmt.setString(4, estoque.getCodigo());
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
	}
	
	public void deletar(Estoque estoque) {
		
		conexao = Conexao.iniciar();
		
		String sql = "DELETE FROM estoque WHERE codigo = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, estoque.getCodigo());
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
	}
}
