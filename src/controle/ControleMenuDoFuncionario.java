package controle;

import java.util.ArrayList;

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
	private void initialize() {
		
		EstoqueDAO dao = new EstoqueDAO();
		ArrayList<Estoque> estoques = dao.listar();
		ArrayList<String> nomeEstoques = new ArrayList<>();
		
		for(int i = 0; i < estoques.size(); i++)
			nomeEstoques.add(estoques.get(i).getNome());
		
		cbEstoques.setItems(FXCollections.observableArrayList(nomeEstoques));
		cbEstoques.setValue(nomeEstoques.get(0));
	}
	
	@FXML
	public void menuSair() {
		Janela.mudarCena("menuPrincipal");
	}
	
	@FXML
	public void menuCadastrarEstoque() {
		Janela.mudarCena("telaCadastroEstoque");
	}
	
}
