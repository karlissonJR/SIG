package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.EstoqueDAO;
import model.Estoque;

public class EstoqueDAOTest {
	
	EstoqueDAO dao = new EstoqueDAO();	
	Estoque estoque = new Estoque("jjj", "Refrigerantes", "Alimentos", 18);


	@Test
	public void testSalvar() {
		if(dao.salvar(estoque))
			System.out.println("estoque salvo");
		else
			fail("Erro ao salvar estoque");
	}

	@Test
	public void testAtualizar() {
		
		estoque.setCapacidade(21);
		
		if(dao.atualizar(estoque))
			System.out.println("estoque atualizado");
		else
			fail("Erro ao atualizar estoque");
	}
	
	@Test
	public void testDeletar() {
		if(dao.deletar(estoque))
			System.out.println("estoque deletado");
		else
			fail("Erro ao deletar estoque");
	}
}
