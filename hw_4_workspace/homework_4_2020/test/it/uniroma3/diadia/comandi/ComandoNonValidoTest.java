/**
 * 
 */
package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoNonValidoTest {

	private Partita partita;
	private IOTester ioConsole;

	@Before
	public void setUp() {
		this.partita = new Partita();
		this.ioConsole = new IOTester();
	}

	@Test
	public void testGetNome() {
		Comando ca = new ComandoNonValido();

		assertEquals("comando non valido", ca.getNome());
	}

	@Test
	public void testEquals() {
		Comando ca = new ComandoNonValido();
		Comando cb = new ComandoNonValido();
		
		assertTrue(ca.equals(cb));
		assertTrue(cb.equals(cb));
		assertEquals(ca, cb);
	}

	@Test
	public void testHashCode() {
		Comando ca = new ComandoNonValido();
		Comando cb = new ComandoNonValido();
		
		assertEquals(ca.hashCode(), cb.hashCode());
	}

	@Test
	public void testEsegui() {
		Comando ca = new ComandoNonValido();
		ca.setIO(this.ioConsole);
		ca.esegui(this.partita);
		assertEquals("Comando sconosciuto", this.ioConsole.getUltimoMessaggio());
	}
}
