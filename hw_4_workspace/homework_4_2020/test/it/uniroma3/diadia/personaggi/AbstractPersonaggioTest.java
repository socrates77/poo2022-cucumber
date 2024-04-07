package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class AbstractPersonaggioTest {
	class Personaggio extends AbstractPersonaggio {
		
		public Personaggio() {
			super("Personaggio", "Presentazione ufficiale");
		}
		@Override
		public String agisci(Partita partita) {
			return "";
		}
		@Override
		public String riceviRegalo(Attrezzo attrezzo) {
			return "";
		}
	}
	
	@Test
	public void testPrimaPresentazione() {
		AbstractPersonaggio personaggio = new Personaggio();
		assertFalse(personaggio.haSalutato());
		assertEquals("Ciao, io sono Personaggio. Presentazione ufficiale", personaggio.saluta());
		assertTrue(personaggio.haSalutato());
	}

	@Test
	public void testSecondaPresentazione() {
		AbstractPersonaggio personaggio = new Personaggio();
		assertFalse(personaggio.haSalutato());
		personaggio.saluta();
		assertTrue(personaggio.haSalutato());
		assertEquals("Ciao, io sono Personaggio. Ci siamo già presentati!", personaggio.saluta());
	}
	
	@Test
	public void testAttrezzo() {
		AbstractPersonaggio personaggio = new Personaggio();
		assertNull(personaggio.getAttrezzo());
		personaggio.setAttrezzo(new Attrezzo("Attrezzo", 1));
		assertEquals(new Attrezzo("Attrezzo", 1), personaggio.getAttrezzo());
	}
}
