/**
 * 
 */
package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

/**
 * Class Labirinto Test - Test della Class Labirinto.
 * 
 * @author Alessandro Manias
 *
 */
public class LabirintoTest {

	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
	}
	
	@Test
	public void testStanzaIniziale() {
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		labirinto.setStanzaCorrente(labirinto.getStanzaCorrente().getStanzaAdiacente("ovest"));
		assertEquals("Laboratorio Campus", labirinto.getStanzaCorrente().getNome());
	}
}
