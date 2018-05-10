package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.EstoqueDAO;
import gui.Janela;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import model.Estoque;

public class ControleMenuDoFuncionario {
	
	@FXML
	private ChoiceBox<String> cbEstoques;
	
	@FXML
	public void initialize() {
		
		EstoqueDAO dao = new EstoqueDAO();
		ArrayList<Estoque> estoques = dao.listar();
		ArrayList<String> codigoEstoques = new ArrayList<>();
		
		for(int i = 0; i < estoques.size(); i++)
			codigoEstoques.add(estoques.get(i).getCodigo());
		
		cbEstoques.setItems(FXCollections.observableArrayList(codigoEstoques));
		cbEstoques.setValue(codigoEstoques.get(0));
	}
	
	@FXML
	public void menuSair() {
		Janela.mudarCena("menuPrincipal");
	}
	
	@FXML
	public void menuCadastrarEstoque() {
		Janela.mudarCena("telaCadastroEstoque");
	}
	
	@FXML
	public void menuCadastrarProduto() {
		Janela.mudarCena("telaCadastroProduto");
	}
	
	@FXML
	public void tabela() {
		//JOptionPane.showMessageDialog(null, cbEstoques.getValue(), "Teste", JOptionPane.INFORMATION_MESSAGE);
	}
}
