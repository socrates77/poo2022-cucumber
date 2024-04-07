package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static it.uniroma3.diadia.ambienti.Direzione.*;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaNord;

	@Before
	public void setUp() {
		this.stanzaBloccata = new StanzaBloccata("Stanza Bloccata", NORD, "osso");
		this.stanzaNord = new Stanza("Stanza nord");
		this.stanzaBloccata.impostaStanzaAdiacente(NORD, this.stanzaNord);
	}
	
	@Test
	public void testStanzaBloccataSenzaAttrezzo() {
		assertEquals(
			this.stanzaBloccata,
			this.stanzaBloccata.getStanzaAdiacente(NORD)
		);
	}
	
	@Test
	public void testStanzaBloccataConAttrezzo() {
		this.stanzaBloccata.addAttrezzo(new Attrezzo("osso", 1));
		assertEquals(this.stanzaNord, this.stanzaBloccata.getStanzaAdiacente(NORD));
	}
}
