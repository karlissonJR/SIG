package controle;

import javax.swing.JOptionPane;

import dao.EstoqueDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Estoque;

public class ControleTelaCadastroEstoque {
	
	@FXML
	private TextField campoCodigo;
	@FXML
	private TextField campoNome;
	@FXML
	private TextField campoTipo;
	@FXML
	private TextField campoCapacidade;
	
	@FXML
	public void btnCadastrarEstoque() {
		
		String codigo = campoCodigo.getText();
		String nome = campoNome.getText();
		String tipo = campoTipo.getText();
		int capacidade = Integer.parseInt(campoCapacidade.getText());
		
		EstoqueDAO dao = new EstoqueDAO();
		Estoque estoque = new Estoque(codigo, nome, tipo, capacidade);
		dao.salvar(estoque);
		
		JOptionPane.showMessageDialog(null, nome + " cadastrado!", "Estoque", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showConfirmDialog(null, "Continuar cadastrando", "Estoque", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		limpar();
	}
	
	private void limpar() {
		campoCodigo.setText("");
		campoNome.setText("");
		campoTipo.setText("");
		campoCapacidade.setText("");
	}
}
