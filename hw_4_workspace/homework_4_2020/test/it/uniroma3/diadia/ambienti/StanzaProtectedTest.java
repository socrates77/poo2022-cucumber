package it.uniroma3.diadia.ambienti;
/**
 * 
 */


import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Alessandro Manias
 *
 */
public class StanzaProtectedTest {
	
	private StanzaProtected impostaStanzeAdiacenti(String[] direzioni, StanzaProtected[] adiacenti) {
		StanzaProtected stanza = new StanzaProtected("stanza");
		for(int i = 0; i < direzioni.length; i++) {
			stanza.impostaStanzaAdiacente(direzioni[i], adiacenti[i]);
		}
		return stanza;
	}

	private StanzaProtected addAttrezzi(Attrezzo... attrezzi) {
		StanzaProtected stanza = new StanzaProtected("Stanza di prova attrezzi");
		for(int i = 0; i < attrezzi.length; i++) {
			stanza.addAttrezzo(attrezzi[i]);
		}
		
		return stanza;
	}
	@Test
	public void testStanzaAdiacenteImpostata() {
		assertTrue(new StanzaProtected("Stanza").impostaStanzaAdiacente("nord", new StanzaProtected("Adiacente a nord")));
	}

	@Test
	public void testSovrascriviStanzaAdiacente() {
		StanzaProtected stanza = this.impostaStanzeAdiacenti(
				new String[] {"nord", "sud"},
				new StanzaProtected[] {new StanzaProtected("Adiacente a nord"), new StanzaProtected("Adiacente a sud")}
			);
		assertTrue("Stanza adiacente a nord sovrascritta", stanza.impostaStanzaAdiacente("nord", new StanzaProtected("Nuova Stanza adiacente a nord")));
	}

	@Test
	public void testImpostaStanzaAdiacenteFallisce() {
		StanzaProtected stanza = this.impostaStanzeAdiacenti(
				new String[] {"nord", "sud", "ovest", "est"},
				new StanzaProtected[] {
						new StanzaProtected("Adiacente a nord"),
						new StanzaProtected("Adiacente a sud"),
						new StanzaProtected("Adiacente a ovest"),
						new StanzaProtected("Adiacente a est")
						}
			);
		assertFalse("Stanza adiacente in alto impostata?", stanza.impostaStanzaAdiacente("alto", new StanzaProtected("Nuova Stanza adiacente in alto")));
	}
	
	@Test
	public void testAggiungiUnAttrezzo() {
		assertTrue(new StanzaProtected("Test aggiungi un attrezzo").addAttrezzo(new Attrezzo("Clava", 1)));
	}

	@Test
	public void testAggiungiPiuDiDieciAttrezzi() {
		StanzaProtected stanza = this.addAttrezzi(				
			new Attrezzo("Clava", 1),
			new Attrezzo("Clava", 2),
			new Attrezzo("Clava", 3),
			new Attrezzo("Clava", 4),
			new Attrezzo("Clava", 5),
			new Attrezzo("Clava", 6),
			new Attrezzo("Clava", 7),
			new Attrezzo("Clava", 8),
			new Attrezzo("Clava", 9),
			new Attrezzo("Clava", 10)
		);
		assertFalse("Attrezzo aggiunto? ma sono più di dieci!", stanza.addAttrezzo(new Attrezzo("Clava", 11)));
	}

	@Test
	public void testRimuoviAttrezzoPresente() {
		Attrezzo attrezzo = new Attrezzo("Clava", 1);
		StanzaProtected stanza = this.addAttrezzi(attrezzo);
		assertTrue(stanza.removeAttrezzo(attrezzo));
	}
	
	@Test
	public void testRimuoviAttrezzoNonPresente() {
		StanzaProtected stanza = this.addAttrezzi(new Attrezzo("Clava", 1));
		assertFalse(stanza.removeAttrezzo(new Attrezzo("Spadone authentico", 3)));
	}
	
	@Test
	public void testRimuoviAttrezzoDaListaVuota() {
		StanzaProtected stanza = this.addAttrezzi();
		assertFalse(stanza.removeAttrezzo(new Attrezzo("Spadone authentico", 3)));
	}
	
	@Test
	public void testLaStanzaNonHaStanzeAdiacenti() {
		assertNull("La stanza non esiste", new StanzaProtected("Non ha stanza adiacenti").getStanzaAdiacente("nord"));
	}
}
