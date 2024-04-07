/**
 * 
 */
package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static it.uniroma3.diadia.ambienti.Direzione.*;
/**
 * @author Alessandro Manias
 *
 */
public class StregaTest {

	private Partita partita;
	private Labirinto labirinto;
	private AbstractPersonaggio personaggio;
	private Stanza stanzaConUnAttrezzo;
	private Stanza stanzaConDueAttrezzi;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.personaggio = new Strega("Strega", "Strega Bacheca");
		Stanza stanzaMain = new Stanza("Main");
		this.stanzaConUnAttrezzo = new Stanza("Stanza con un attrezzo");
		this.stanzaConUnAttrezzo.addAttrezzo(new Attrezzo("Attrezzo 1", 1));
		this.stanzaConDueAttrezzi = new Stanza("Stanza con due attrezzi");
		this.stanzaConDueAttrezzi.addAttrezzo(new Attrezzo("Attrezzo 2", 1));
		this.stanzaConDueAttrezzi.addAttrezzo(new Attrezzo("Attrezzo 3", 1));
		stanzaMain.impostaStanzaAdiacente(NORD, this.stanzaConDueAttrezzi);
		stanzaMain.impostaStanzaAdiacente(SUD, this.stanzaConUnAttrezzo);
		this.labirinto = new Labirinto();
		this.labirinto.setStanzaCorrente(stanzaMain);
		this.partita = new Partita(this.labirinto);
	}

	/**
	 * Test method for {@link it.uniroma3.diadia.personaggi.Strega#agisci(it.uniroma3.diadia.Partita)}.
	 */
	@Test
	public void testAgisciPrimaDelSaluto() {
		Attrezzo[] attrezzi = { new Attrezzo("Attrezzo 1", 1) };
		assertEquals("Ahahahah!!!", this.personaggio.agisci(partita));
		assertEquals(this.stanzaConUnAttrezzo, this.partita.getStanzaCorrente());
		assertArrayEquals(attrezzi, this.partita.getStanzaCorrente().getAttrezzi());
	}
	
	/**
	 * Test method for {@link it.uniroma3.diadia.personaggi.Strega#agisci(it.uniroma3.diadia.Partita)}.
	 */
	@Test
	public void testAgisciDopoIlSaluto() {
		Attrezzo[] attrezzi = { new Attrezzo("Attrezzo 2", 1), new Attrezzo("Attrezzo 3", 1) };
		assertEquals("Ciao, io sono Strega. Strega Bacheca", this.personaggio.saluta());
		assertEquals("Ahahahah!!!", this.personaggio.agisci(partita));
		assertEquals(this.stanzaConDueAttrezzi, this.partita.getStanzaCorrente());
		assertArrayEquals(attrezzi, this.partita.getStanzaCorrente().getAttrezzi());
	}

}
