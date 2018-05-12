package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.EstoqueDAO;
import gui.Janela;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Estoque;

public class ControleTelaCadastroEstoque {
	
	@FXML
	private TextField campoCodigo;
	@FXML
	private TextField campoNome;
	@FXML
	private ChoiceBox<String> campoTipo;
	@FXML
	private TextField campoCapacidade;
	
	@FXML
	private void initialize() {
		
		String[] tipos = {"Eletrônicos", "Comidas"};
		
		campoTipo.setItems(FXCollections.observableArrayList(tipos));
		campoTipo.setValue(tipos[0]);
	}
	
	@FXML
	public void btnCadastrarEstoque() {
		
		if(campoCodigo.getText().isEmpty() || campoNome.getText().isEmpty() || campoTipo.getValue().isEmpty() ||
				campoCapacidade.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Estoque", JOptionPane.ERROR_MESSAGE);
		
		else {
			boolean cadastro = true;
			String codigo = campoCodigo.getText();
			String nome = campoNome.getText();
			String tipo = campoTipo.getValue();
			int capacidade = Integer.parseInt(campoCapacidade.getText());
			
			EstoqueDAO dao = new EstoqueDAO();
			
			ArrayList<Estoque> estoques = dao.listar();
			
			for(int i = 0; i < estoques.size(); i++) {
				if(estoques.get(i).getCodigo().equals(codigo)) {
					cadastro = false;
					break;
				}
			}
			
			if(cadastro) {
				Estoque estoque = new Estoque(codigo, nome, tipo, capacidade);
				dao.salvar(estoque);
				
				JOptionPane.showMessageDialog(null, nome + " cadastrado!", "Estoque", JOptionPane.INFORMATION_MESSAGE);
				int resposta = JOptionPane.showConfirmDialog(null, "Continuar cadastrando", "Estoque", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				
				if(resposta == 1)
					Janela.mudarCena("menuFuncionario");
				
				limpar();
			}
			else
				JOptionPane.showMessageDialog(null, "Estoque já estava cadastrado", "Produto", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void limpar() {
		campoCodigo.setText("");
		campoNome.setText("");
		campoCapacidade.setText("");
	}
}
