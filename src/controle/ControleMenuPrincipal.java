package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.FuncionarioDAO;
import gui.Janela;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Funcionario;

public class ControleMenuPrincipal {
	
	@FXML
	private TextField campoCpfLogin;
	@FXML
	private TextField campoSenhaLogin;
	@FXML
	private TextField campoCpfCadastro;
	@FXML
	private TextField campoNomeCadastro;
	@FXML
	private TextField campoTelefoneCadastro;
	@FXML
	private PasswordField campoSenhaCadastro;
	
	@FXML
	public void btnCadastrar() {
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		ArrayList<Funcionario> funcionarios = dao.listar();
		boolean cadastrado = false;
		
		String cpf = campoCpfCadastro.getText();
		String nome = campoNomeCadastro.getText();
		String telefone = campoTelefoneCadastro.getText();
		String senha = campoSenhaCadastro.getText();
		
		for(int i = 0; i < funcionarios.size(); i++) {
			if(funcionarios.get(i).getCpf().equals(cpf)) {
				cadastrado = true;
				break;
			}
		}
		
		
		if(campoCpfCadastro.getText().isEmpty() || campoNomeCadastro.getText().isEmpty() ||
				campoTelefoneCadastro.getText().isEmpty() || campoSenhaCadastro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(cadastrado) {
			JOptionPane.showMessageDialog(null, "Funcionário Já estava cadastrado", "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			Funcionario funcionario = new Funcionario(cpf, nome, telefone, senha);
			dao.salvar(funcionario);
		
			JOptionPane.showMessageDialog(null, "Funcionario(a) " + nome + " cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
			
			limparCadastro();
		}
		
	}
	
	@FXML
	public void btnEntrar() {
		
		FuncionarioDAO dao = new FuncionarioDAO();
		ArrayList<Funcionario> funcionarios = dao.listar();
		
		boolean login = false;
		
		String cpf = campoCpfLogin.getText();
		String senha = campoSenhaLogin.getText();
		
		for(int i = 0; i < funcionarios.size(); i++) {
			if(funcionarios.get(i).getCpf().equals(cpf)) {
				if(funcionarios.get(i).getSenha().equals(senha)) {
					login = true;
					break;
				}
			}
		}
		
		if(login) {
			Janela.mudarCena("menuFuncionario");
			limparLogin();
		}
		else
			JOptionPane.showMessageDialog(null, "CPF e/ou Senha inválidos","Login", JOptionPane.ERROR_MESSAGE);
	}
	
	private void limparCadastro() {
		campoCpfCadastro.setText("");
		campoNomeCadastro.setText("");
		campoTelefoneCadastro.setText("");
		campoSenhaCadastro.setText("");
	}
	
	private void limparLogin() {
		campoCpfLogin.setText("");
		campoSenhaLogin.setText("");
		limparCadastro();
	}

}
