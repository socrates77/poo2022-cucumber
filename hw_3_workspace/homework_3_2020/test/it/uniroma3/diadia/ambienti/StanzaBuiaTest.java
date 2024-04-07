/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Alessandro Manias
 *
 */
public class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;

	@Before
	public void setUp() {
		this.stanzaBuia = new StanzaBuia("Stanza Buia", "Lanterna");	
	}

	@Test
	public void testDescrizioneStanzaBuia() {
		assertEquals("Qui c'è buio pesto", this.stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testDescrizioneConOggettoAttivatore() {
		this.stanzaBuia.addAttrezzo(new Attrezzo("Lanterna", 1));
		assertEquals("Stanza Buia\nUscite: \nAttrezzi nella stanza: Lanterna (1kg) ", this.stanzaBuia.getDescrizione());
	}
	
}
