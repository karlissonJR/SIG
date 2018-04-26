package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
