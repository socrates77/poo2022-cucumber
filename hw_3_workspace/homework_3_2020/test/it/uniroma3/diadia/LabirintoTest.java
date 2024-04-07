/**
 * 
 */
package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

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
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Biblioteca")
				.getLabirinto();
	}

	@Test
	public void testStanzaIniziale() {
		assertEquals(new Stanza("Atrio"), labirinto.getStanzaCorrente());
	}

	@Test
	public void testStanzaVincente() {
		assertEquals(new Stanza("Biblioteca"), labirinto.getStanzaVincente());
	}

}
