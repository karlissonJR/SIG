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
	private int tamanhoAnterior = 0;
	
	String codigo = "jjj";
	String nome = "Refrigerantes";
	String tipo = "Alimentos";
	int capacidade = 18;
	
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
		dao.deletar(new Estoque(codigo, nome, tipo, capacidade));
	}

	@Test
	public void testSalvar() {
		dao.salvar(new Estoque(codigo, nome, tipo, capacidade));
		assertNotEquals(tamanhoAnterior, dao.listar().size());
	}

	@Test
	public void testListar() {
		
	}

	@Test
	public void testListarPorTipo() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAtualizar() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeletar() {
		//fail("Not yet implemented");
	}

}
