package teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.EstoqueDAO;
import dao.ProdutoDAO;
import model.Estoque;
import model.Produto;

public class ProdutoDAOTest {

	ProdutoDAO produtoDao = new ProdutoDAO();
	EstoqueDAO estoqueDao = new EstoqueDAO();
	
	Estoque estoque = new Estoque("jjj", "Refrigerantes", "Alimentos", 18);
	Produto produto = new Produto("jjjj", "Coca", 15, "Refrigerantes", 10, "15/06/2019", "jjj");
	
	@Before
	public void setUp() throws Exception {
		estoqueDao.salvar(estoque);
	}

	@After
	public void tearDown() throws Exception {
		estoqueDao.deletar(estoque);
	}

	@Test
	public void testSalvar() {
		
		if(produtoDao.salvar(produto))
			System.out.println("produto salvo");
		else
			fail("Erro ao salvar produto");
	}
	
	@Test
	public void testAtualizar() {
		
		produto.setPreco(15.5);
		
		if(produtoDao.atualizar(produto))
			System.out.println("produto atualizado");
		else
			fail("Erro ao atualizar produto");
	}
	
	@Test
	public void testDeletar() {
		
		if(produtoDao.deletar(produto))
			System.out.println("produto deletado");
		else
			fail("Erro ao deletar produto");
	}

}
