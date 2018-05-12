package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.EstoqueDAO;
import dao.ProdutoDAO;
import gui.Janela;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import model.Estoque;
import model.Produto;

public class ControleMenuDoFuncionario {
	
	@FXML
	private ChoiceBox<String> cbEstoques;
	@FXML
	private TableView<Produto> tabelaProdutos;
	
	@FXML
	public void initialize() {
		
		EstoqueDAO dao = new EstoqueDAO();
		ArrayList<Estoque> estoques = dao.listar();
		ArrayList<String> nomeEstoques = new ArrayList<>();
		
		for(int i = 0; i < estoques.size(); i++)
			nomeEstoques.add(estoques.get(i).getNome());
		
		if(nomeEstoques.size() > 0) {
			cbEstoques.setItems(FXCollections.observableArrayList(nomeEstoques));
			cbEstoques.setValue(nomeEstoques.get(0));
		}
	}
	
	@FXML
	public void menuSair() {
		Janela.mudarCena("menuPrincipal");
		initialize();
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
		
		String nomeEstoque = cbEstoques.getValue();
		String codEstoque = "";
		
		EstoqueDAO estDao = new EstoqueDAO();
		ArrayList<Estoque> estoques = estDao.listar();
		
		for(int i = 0; i < estoques.size(); i++) {
			if(estoques.get(i).getNome().equals(nomeEstoque)) {
				codEstoque = estoques.get(i).getCodigo();
				break;
			}
		}
		
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> produtos = dao.listarPorCodigoEstoque(codEstoque);
		
		tabelaProdutos.setItems(FXCollections.observableArrayList(produtos));
	}
}
