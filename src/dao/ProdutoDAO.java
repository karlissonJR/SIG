package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;

public class ProdutoDAO {

	public void salvar(Produto produto) {
		
		String sql = "INSERT INTO produto (codigo,nome,tipo,quantidade,preco,validade,codigo_estoque) "
				+ "VALUES (?,?,?,?,?,?,?)";	
		PreparedStatement stmt;
		
		try {
			stmt = Conexao.iniciar().prepareStatement(sql);
			
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
			Conexao.encerrar();
		}
		
	}
	
	public ArrayList<Produto> listar(){
		
		String sql = "SELECT * FROM produto";
		PreparedStatement stmt;
		ResultSet rs;
		
		ArrayList<Produto> produtos = new ArrayList<>();
		
		try {
			stmt = Conexao.iniciar().prepareStatement(sql);
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
			Conexao.encerrar();
		}
		
		return produtos;
		
	}
	
}
