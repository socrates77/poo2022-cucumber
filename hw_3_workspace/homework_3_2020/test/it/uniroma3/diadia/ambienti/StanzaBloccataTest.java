package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaNord;

	@Before
	public void setUp() {
		this.stanzaBloccata = new StanzaBloccata("Stanza Bloccata", "nord", "osso");
		this.stanzaNord = new Stanza("Stanza nord");
		this.stanzaBloccata.impostaStanzaAdiacente("nord", this.stanzaNord);
	}
	
	@Test
	public void testStanzaBloccataSenzaAttrezzo() {
		assertEquals(
			this.stanzaBloccata,
			this.stanzaBloccata.getStanzaAdiacente("nord")
		);
	}
	
	@Test
	public void testStanzaBloccataConAttrezzo() {
		this.stanzaBloccata.addAttrezzo(new Attrezzo("osso", 1));
		assertEquals(this.stanzaNord, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}
}
