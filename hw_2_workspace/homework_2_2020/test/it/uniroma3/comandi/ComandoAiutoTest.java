/**
 * 
 */
package it.uniroma3.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.ComandoAiuto;

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
	public void testEsegui() {
		ComandoAiuto ca = new ComandoAiuto();
		ca.setIO(this.ioConsole);
		ca.esegui(this.partita);
		assertEquals("vai prendi posa aiuto fine guarda", this.ioConsole.getUltimoMessaggio());
	}
}
