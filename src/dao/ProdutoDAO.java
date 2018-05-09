package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;

public class ProdutoDAO {
	
	private Connection conexao;

	public void salvar(Produto produto) {
		
		conexao = Conexao.iniciar();
		
		String sql = "INSERT INTO produto (codigo,nome,tipo,quantidade,preco,validade,codigo_estoque) "
				+ "VALUES (?,?,?,?,?,?,?)";	
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, produto.getCodigo());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getTipo());
			stmt.setInt(4, produto.getQuantidade());
			stmt.setDouble(5, produto.getPreco());
			stmt.setString(6, produto.getValidade());
			stmt.setString(7, produto.getCodigoEstoque());
			
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
		
	}
	
	public ArrayList<Produto> listar(){
		
		conexao = Conexao.iniciar();
		
		String sql = "SELECT * FROM produto";
		PreparedStatement stmt;
		ResultSet rs;
		
		ArrayList<Produto> produtos = new ArrayList<>();
		
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				String codigo = rs.getString("codigo");
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo");
				int quantidade = rs.getInt("quantidade");
				double preco = rs.getDouble("preco");
				String validade = rs.getString("validade");
				String codigoEstoque = rs.getString("codigo_estoque");
				
				Produto produto = new Produto(codigo, nome, preco, tipo, quantidade, validade, codigoEstoque);
				produtos.add(produto);
				
			}
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
		
		return produtos;
		
	}
	
	public void atualizar(Produto produto) {
		
		conexao = Conexao.iniciar();
		
		String sql = "UPDATE produto SET nome = ?, tipo = ?, quantidade = ?, preco = ? WHERE codigo = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getTipo());
			stmt.setInt(3, produto.getQuantidade());
			stmt.setDouble(4, produto.getPreco());
			stmt.setString(5, produto.getCodigo());
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
	}
	
	public void deletar(Produto produto) {
		
		conexao = Conexao.iniciar();
		
		String sql = "DELETE FROM produto WHERE codigo = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, produto.getCodigo());
			
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
