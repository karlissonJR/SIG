package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Funcionario;

public class FuncionarioDAO {
	
	private Connection conexao;

	public void salvar(Funcionario funcionario) {
		
		conexao = Conexao.iniciar();
		
		String sql = "INSERT INTO funcionario (cpf,nome,telefone,senha) VALUES (?,?,?,?)";	
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getCpf());
			stmt.setString(2, funcionario.getNome());
			stmt.setString(3, funcionario.getTelefone());
			stmt.setString(4, funcionario.getSenha());
			
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
		
	}
	
	public ArrayList<Funcionario> listar(){
		
		conexao = Conexao.iniciar();
		
		String sql = "SELECT * FROM funcionario";
		PreparedStatement stmt;
		ResultSet rs;
		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		
		try {
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				String senha = rs.getString("senha");
				
				Funcionario funcionario = new Funcionario(cpf, nome, telefone, senha);
				funcionarios.add(funcionario);
				
			}
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
		
		return funcionarios;
		
	}
	
	public void atualizar(Funcionario funcionario) {
		
		conexao = Conexao.iniciar();
		
		String sql = "UPDATE funcionario SET nome = ?, telefone = ?, senha = ? WHERE cpf = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getTelefone());
			stmt.setString(3, funcionario.getSenha());
			stmt.setString(4, funcionario.getCpf());
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
	}
	
	public void deletar(Funcionario funcionario) {
		
		conexao = Conexao.iniciar();
		
		String sql = "DELETE FROM funcionario WHERE cpf = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getCpf());
			
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		finally {
			Conexao.encerrar(conexao);
		}
		
	}
	
}
