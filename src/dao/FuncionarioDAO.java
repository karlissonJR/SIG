package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Funcionario;

public class FuncionarioDAO {

	public boolean salvar(Funcionario funcionario) {
		
		String sql = "INSERT INTO funcionario (cpf,nome,telefone,senha) VALUES (?,?,?,?)";	
		PreparedStatement stmt;
		
		try {
			stmt = Conexao.iniciar().prepareStatement(sql);
			
			stmt.setString(1, funcionario.getCpf());
			stmt.setString(2, funcionario.getNome());
			stmt.setString(3, funcionario.getTelefone());
			stmt.setString(4, funcionario.getSenha());
			
			stmt.executeUpdate();
			
			return true;
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
	public ArrayList<Funcionario> listar(){
		
		String sql = "SELECT * FROM funcionario";
		PreparedStatement stmt;
		ResultSet rs;
		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		
		try {
			stmt = Conexao.iniciar().prepareStatement(sql);
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
		
		return funcionarios;
		
	}
	
	public boolean atualizar(Funcionario funcionario) {
		
		String sql = "UPDATE funcionario SET nome = ?, telefone = ?, senha = ? WHERE cpf = ?";
		PreparedStatement stmt;
		
		try {
			stmt = Conexao.iniciar().prepareStatement(sql);
			
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getTelefone());
			stmt.setString(3, funcionario.getSenha());
			stmt.setString(4, funcionario.getCpf());
			
			stmt.executeUpdate();
			
			return true;
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public boolean deletar(Funcionario funcionario) {
		
		String sql = "DELETE FROM funcionario WHERE cpf = ?";
		PreparedStatement stmt;
		
		try {
			stmt = Conexao.iniciar().prepareStatement(sql);
			
			stmt.setString(1, funcionario.getCpf());
			
			stmt.executeUpdate();
			
			return true;
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
}
