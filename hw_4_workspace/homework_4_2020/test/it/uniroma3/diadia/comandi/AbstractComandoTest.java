package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Test;
import it.uniroma3.diadia.Partita;

public class AbstractComandoTest {
	/**
	 * 
	 */
	@Test
	public void testHashCodeComandoVuoto() {
		class ComandoTest extends AbstractComando {
			@Override
			public void esegui(Partita partita) {
				
			}
		}
		Comando a = new ComandoTest();
		Comando b = new ComandoTest();
		
		assertEquals(a.hashCode(), b.hashCode());
	}

	@Test
	public void testHashCodeComandoConNome() {
		class ComandoTest extends AbstractComando {
			
			public ComandoTest() {
				this.setNome("comandotest");
			}
			
			@Override
			public void esegui(Partita partita) {
				
			}
		}
		Comando a = new ComandoTest();
		Comando b = new ComandoTest();
		
		assertNotNull(a.getNome());
		assertNotNull(b.getNome());
		assertEquals(a.hashCode(), b.hashCode());
	}
	
	@Test
	public void testEqualsRiflessivo() {
		class ComandoTest extends AbstractComando {
			
			public ComandoTest() {
				this.setNome("comandotest");
			}
			@Override
			public void esegui(Partita partita) {
				
			}
		}
		Comando a = new ComandoTest();
		
		assertTrue(a.equals(a));
	}

	@Test
	public void testEqualsSimmetrico() {

		class ComandoTest extends AbstractComando {
			
			public ComandoTest() {
				this.setNome("comandotest");
			}
			@Override
			public void esegui(Partita partita) {
				
			}
		}
		Comando a = new ComandoTest();
		Comando b = new ComandoTest();
		
		assertTrue(a.equals(b));
		assertTrue(b.equals(a));
	}

	@Test
	public void testEqualsTransitivo() {

		class ComandoTest extends AbstractComando {
			
			public ComandoTest() {
				this.setNome("comandotest");
			}

			@Override
			public void esegui(Partita partita) {
				
			}
		}

		Comando a = new ComandoTest();
		Comando b = new ComandoTest();
		Comando c = new ComandoTest();
		
		assertTrue(a.equals(b));
		assertTrue(b.equals(c));
		assertTrue(a.equals(c));
	}
	
	@Test
	public void testGetNome() {

		class ComandoTest extends AbstractComando {
			
			public ComandoTest() {
				this.setNome("comandotest");
			}
			@Override
			public void esegui(Partita partita) {
				
			}
		}

		Comando a = new ComandoTest();
		assertEquals("comandotest", a.getNome());
	}

	@Test
	public void testComandoConParametro() {
		Comando ca = new AbstractComando() {
			
			@Override
			public void esegui(Partita partita) {
			}
		};
		ca.setParametro("parametro");
		assertEquals("parametro", ca.getParametro());
	}

	@Test
	public void testComandoSenzaParametro() {
		Comando ca = new AbstractComando() {
			@Override
			public void esegui(Partita partita) {
			}
		};
		assertEquals(null, ca.getParametro());
	}

	@Test
	public void testGetParametro() {
		Comando ca = new AbstractComando() {
			@Override
			public void esegui(Partita partita) {
			}
		};
		ca.setParametro("parametro");
		assertEquals("parametro", ca.getParametro());
	}

}
