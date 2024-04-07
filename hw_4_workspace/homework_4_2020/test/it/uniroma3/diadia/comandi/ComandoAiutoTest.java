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
public class ComandoAiutoTest {

	private Partita partita;
	private IOTester ioConsole;

	@Before
	public void setUp() {
		this.partita = new Partita();
		this.ioConsole = new IOTester();
	}

	@Test
	public void testGetNome() {
		Comando ca = new ComandoAiuto();

		assertEquals("aiuto", ca.getNome());
	}

	@Test
	public void testEquals() {
		Comando ca = new ComandoAiuto();
		Comando cb = new ComandoAiuto();
		
		assertTrue(ca.equals(cb));
		assertTrue(cb.equals(cb));
		assertEquals(ca, cb);
	}

	@Test
	public void testHashCode() {
		Comando ca = new ComandoAiuto();
		Comando cb = new ComandoAiuto();
		
		assertEquals(ca.hashCode(), cb.hashCode());
	}

	@Test
	public void testEsegui() {
		Comando ca = new ComandoAiuto();
		ca.setIO(this.ioConsole);
		ca.esegui(this.partita);
		assertEquals("vai prendi posa aiuto fine guarda", this.ioConsole.getUltimoMessaggio());
	}
}
