package teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.EstoqueDAO;
import model.Estoque;

public class EstoqueDAOTest {
	
	EstoqueDAO dao = new EstoqueDAO();
	private int tamanhoAnterior;
	
	Estoque estoque = new Estoque("jjj", "Refrigerantes", "Alimentos", 18);
	
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
		dao.deletar(estoque);
	}

	@Test
	public void testSalvar() {
		dao.salvar(estoque);
		assertNotEquals(tamanhoAnterior, dao.listar().size());
	}


}
