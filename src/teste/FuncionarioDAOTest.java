package teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.FuncionarioDAO;
import model.Funcionario;
import model.Produto;

public class FuncionarioDAOTest {
	
	FuncionarioDAO dao = new FuncionarioDAO();
	Funcionario funcionario = new Funcionario("78451358", "Zé", "999999999", "senha");
	private int tamanhoAnterior;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tamanhoAnterior = dao.listar().size();
	}

	@After
	public void tearDown() throws Exception {
		dao.deletar(funcionario);
	}

	@Test
	public void testSalvar() {
		dao.salvar(funcionario);
		assertNotEquals(tamanhoAnterior, dao.listar().size());
	}

}
