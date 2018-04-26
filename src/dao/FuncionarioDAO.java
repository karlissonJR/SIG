package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Funcionario;

public class FuncionarioDAO {

	public void salvar(Funcionario funcionario) {
		
		String sql = "INSERT INTO funcionario (cpf,nome,telefone,senha) VALUES (?,?,?,?)";	
		PreparedStatement stmt = null;
		
		try {
			stmt = Conexao.iniciar().prepareStatement(sql);
			
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
			Conexao.encerrar();
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
		finally {
			Conexao.encerrar();
		}
		
		return funcionarios;
		
	}
	
}
