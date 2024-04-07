package it.uniroma3.diadia;
/**
 * 
 */


import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Alessandro Manias
 *
 */
public class StanzaTest {
	
	private Stanza impostaStanzeAdiacenti(String[] direzioni, Stanza[] adiacenti) {
		Stanza stanza = new Stanza("stanza");
		for(int i = 0; i < direzioni.length; i++) {
			stanza.impostaStanzaAdiacente(direzioni[i], adiacenti[i]);
		}
		return stanza;
	}

	private Stanza addAttrezzi(Attrezzo... attrezzi) {
		Stanza stanza = new Stanza("Stanza di prova attrezzi");
		for(int i = 0; i < attrezzi.length; i++) {
			stanza.addAttrezzo(attrezzi[i]);
		}
		
		return stanza;
	}
	@Test
	public void testStanzaAdiacenteImpostata() {
		assertTrue(new Stanza("Stanza").impostaStanzaAdiacente("nord", new Stanza("Adiacente a nord")));
	}

	@Test
	public void testSovrascriviStanzaAdiacente() {
		Stanza stanza = this.impostaStanzeAdiacenti(
				new String[] {"nord", "sud"},
				new Stanza[] {new Stanza("Adiacente a nord"), new Stanza("Adiacente a sud")}
			);
		assertTrue("Stanza adiacente a nord sovrascritta", stanza.impostaStanzaAdiacente("nord", new Stanza("Nuova Stanza adiacente a nord")));
	}

	@Test
	public void testImpostaStanzaAdiacenteFallisce() {
		Stanza stanza = this.impostaStanzeAdiacenti(
				new String[] {"nord", "sud", "ovest", "est"},
				new Stanza[] {
						new Stanza("Adiacente a nord"),
						new Stanza("Adiacente a sud"),
						new Stanza("Adiacente a ovest"),
						new Stanza("Adiacente a est")
						}
			);
		assertFalse("Stanza adiacente in alto impostata?", stanza.impostaStanzaAdiacente("alto", new Stanza("Nuova Stanza adiacente in alto")));
	}
	
	@Test
	public void testAggiungiUnAttrezzo() {
		assertTrue(new Stanza("Test aggiungi un attrezzo").addAttrezzo(new Attrezzo("Clava", 1)));
	}

	@Test
	public void testAggiungiPiuDiDieciAttrezzi() {
		Stanza stanza = this.addAttrezzi(				
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
		assertFalse("Attrezzo aggiunto? ma sono più di dieci!", stanza.addAttrezzo(new Attrezzo("Clava", 12)));
	}

	@Test
	public void testRimuoviAttrezzoPresente() {
		Attrezzo attrezzo = new Attrezzo("Clava", 1);
		Stanza stanza = this.addAttrezzi(attrezzo);
		assertTrue(stanza.removeAttrezzo(attrezzo));
	}
	
	@Test
	public void testRimuoviAttrezzoNonPresente() {
		Stanza stanza = this.addAttrezzi(new Attrezzo("Clava", 1));
		assertFalse(stanza.removeAttrezzo(new Attrezzo("Spadone authentico", 3)));
	}
	
	@Test
	public void testRimuoviAttrezzoDaListaVuota() {
		Stanza stanza = this.addAttrezzi();
		assertFalse(stanza.removeAttrezzo(new Attrezzo("Spadone authentico", 3)));
	}
	
	@Test
	public void testLaStanzaNonHaStanzeAdiacenti() {
		assertNull("La stanza non esiste", new Stanza("Non ha stanza adiacenti").getStanzaAdiacente("nord"));
	}
}
