/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;

/**
 * @author Alessandro Manias
 *
 */
public class PartitaTest {

	Partita partita;
	Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.partita = new Partita();
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		this.partita.setLabirinto(labirinto);
	}
	
	@Test
	public void testPartitaNonFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testPartitaFinitaCfuEsauriti() {
		this.partita.setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testPartitaRaggiuntaLaStanzaFinale() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
}
