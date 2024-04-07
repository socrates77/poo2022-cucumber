package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOTester;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaneTest {

	Partita partita;
	Labirinto labirinto;
	IOTester ioConsole;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		this.ioConsole = new IOTester();
	}
	
	@Test
	public void testAgisci() {
		Stanza stanza = new Stanza("Stanza con cane");
		AbstractPersonaggio personaggio = new Cane("Pluto");
		stanza.setPersonaggio(personaggio);
		this.labirinto.setStanzaCorrente(stanza);
		assertEquals(20, partita.getCfu());
		assertEquals("Woof Woof GRRRR! Sei stato morso. Ora hai 19 CFU", personaggio.agisci(partita));
		assertEquals(19, partita.getCfu());
	}

	@Test
	public void testHaSalutato() {
		AbstractPersonaggio personaggio = new Cane("Pluto");
		assertFalse(personaggio.haSalutato());
		personaggio.saluta();
		assertTrue(personaggio.haSalutato());
	}

	@Test
	public void testSaluta() {
		AbstractPersonaggio personaggio = new Cane("Pluto");
		assertFalse(personaggio.haSalutato());
		assertEquals("Ciao, io sono Pluto. " + Cane.MESSAGGIO_PRESENTAZIONE, personaggio.saluta());
		assertTrue(personaggio.haSalutato());
	}

	@Test
	public void testIsPreferito() {
		Cane personaggio = new Cane("Pluto");
		personaggio.setAttrezzo(new Attrezzo("Osso", 1));
		assertTrue(personaggio.isPreferito(new Attrezzo("Osso", 1)));	
	}
	
	@Test
	public void testNotIsPreferito() {
		Cane personaggio = new Cane("Pluto");
		personaggio.setAttrezzo(new Attrezzo("Osso", 1));
		assertFalse(personaggio.isPreferito(new Attrezzo("Spada", 1)));	
	}

	@Test
	public void testRegaloCorretto() {
		AbstractPersonaggio personaggio = new Cane("Pluto");
		personaggio.setAttrezzo(new Attrezzo("Osso", 1));
		assertEquals("Woof Woof!", personaggio.riceviRegalo(new Attrezzo("Osso", 1)));
	}

	@Test
	public void testRegaloSbagliato() {
		AbstractPersonaggio personaggio = new Cane("Pluto");
		personaggio.setAttrezzo(new Attrezzo("Osso", 1));
		assertEquals("Woof Woof GRRR!!!", personaggio.riceviRegalo(new Attrezzo("Spada", 3)));
	}
	
}
