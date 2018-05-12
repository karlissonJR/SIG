package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.EstoqueDAO;
import dao.ProdutoDAO;
import gui.Janela;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Estoque;
import model.Produto;

public class ControleTelaCadastroProduto {

	@FXML
	private TextField campoCodigo;
	@FXML
	private TextField campoNome;
	@FXML
	private ChoiceBox<String> campoTipo;
	@FXML
	private TextField campoQuantidade;
	@FXML
	private TextField campoPreco;
	@FXML
	private TextField campoValidade;
	@FXML
	private ChoiceBox<String> campoEstoque;
	
	@FXML
	private void initialize() {
		String[] tipos = {"Eletrônicos", "Comidas"};
		EstoqueDAO dao = new EstoqueDAO();
		ArrayList<Estoque> estoques = dao.listarPorTipo("Eletrônicos");
		ArrayList<String> nomeEstoques = new ArrayList<>();
		
		for(int i = 0; i < estoques.size(); i++)
			nomeEstoques.add(estoques.get(i).getNome());
		
		campoTipo.setItems(FXCollections.observableArrayList(tipos));
		campoTipo.setValue(tipos[0]);
		
		if(nomeEstoques.size() > 0) {
			campoEstoque.setItems(FXCollections.observableArrayList(nomeEstoques));
			campoEstoque.setValue(nomeEstoques.get(0));
		}
	}
	
	@FXML
	public void choiceBoxCampoTipo() {
		EstoqueDAO dao = new EstoqueDAO();
		ArrayList<Estoque> estoques = dao.listarPorTipo(campoTipo.getValue());
		ArrayList<String> nomeEstoques = new ArrayList<>();
		
		for(int i = 0; i < estoques.size(); i++)
			nomeEstoques.add(estoques.get(i).getNome());
		
		if(nomeEstoques.size() > 0) {
			campoEstoque.setItems(FXCollections.observableArrayList(nomeEstoques));
			campoEstoque.setValue(nomeEstoques.get(0));
		}
	}
	
	@FXML
	public void btnCadastrarProduto() {
		
		String codigo = campoCodigo.getText();
		String nome = campoNome.getText();
		String tipo = campoTipo.getValue();
		int quantidade = Integer.parseInt(campoQuantidade.getText());
		double preco = Double.parseDouble(campoPreco.getText());
		String validade = campoValidade.getText();
		String nomeEstoque = campoEstoque.getValue();
		String estoque = "";
		
		EstoqueDAO estDao = new EstoqueDAO();
		ArrayList<Estoque> estoques = estDao.listarPorTipo(tipo);
		
		for(int i = 0; i < estoques.size(); i++) {
			if(estoques.get(i).getNome().equals(nomeEstoque)) {
				estoque = estoques.get(i).getCodigo();
				break;
			}
		}
		
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = new Produto(codigo, nome, preco, tipo, quantidade, validade, estoque);
		dao.salvar(produto);
		
		JOptionPane.showMessageDialog(null, nome + " cadastrado!", "Produto", JOptionPane.INFORMATION_MESSAGE);
		int resposta = JOptionPane.showConfirmDialog(null, "Continuar cadastrando", "Produto", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		if(resposta == 1)
			Janela.mudarCena("menuFuncionario");
		
		limpar();
	}
	
	private void limpar() {
		campoCodigo.setText("");
		campoNome.setText("");
		campoQuantidade.setText("");
		campoPreco.setText("");
		campoValidade.setText("");
	}
}