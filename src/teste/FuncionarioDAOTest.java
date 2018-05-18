package teste;

import static org.junit.Assert.*;
import org.junit.Test;
import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioDAOTest {
	
	FuncionarioDAO dao = new FuncionarioDAO();
	Funcionario funcionario = new Funcionario("784513448", "Zé", "999999999", "senha");

	@Test
	public void testSalvar() {
		
		if(dao.salvar(funcionario))
			System.out.println("funcionário salvo");
		else 
			fail("Erro ao salvar funcionário");
	}

	@Test
	public void testAtualizar() {
		
		funcionario.setTelefone("88888887");
		
		if(dao.atualizar(funcionario)) 
			System.out.println("funcionário atualizado");
		else
			fail("Erro ao atualizar funcionário");
	}
	
	@Test
	public void testDeletar() {
		
		if(dao.deletar(funcionario))
			System.out.println("funcionário deletado");
		else 
			fail("Erro ao deletar funcionário");
		
	}
}
