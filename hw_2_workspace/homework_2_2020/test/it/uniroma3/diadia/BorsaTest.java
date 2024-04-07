/**
 * 
 */
package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe BorsaTest - Testa la Borsa con gli attrezzi del giocatore.
 * 
 * @author Alessandro Manias
 *
 */
public class BorsaTest {

	private Borsa borsa;

	@Before
	public void setUp() {
		this.borsa = new Borsa();
	}

	@Test
	public void testAggiungiAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(new Attrezzo("Clava", 1)));
	}

	@Test
	public void testAggiungiPiuDiDieciAttrezzi() {
		Attrezzo attrezzo;
		for(int i=1; i <= 10; i++) {
			attrezzo = new Attrezzo("Clava " + i, i);
			this.borsa.addAttrezzo(attrezzo);
		}
		assertFalse("Attrezzo aggiunto? ma sono più di dieci!", this.borsa.addAttrezzo(new Attrezzo("Clava 11", 11)));
	}

	@Test
	public void testRimuoviAttrezzo() {
		this.borsa.addAttrezzo(new Attrezzo("Clava", 1));
		assertEquals("Clava", this.borsa.removeAttrezzo("Clava").getNome());
	}

	@Test
	public void testRimuoviAttrezziFuoriOrdine() {
		this.borsa.addAttrezzo(new Attrezzo("Clava", 1));
		this.borsa.addAttrezzo(new Attrezzo("Spadone a due mani", 1));
		assertNotNull(this.borsa.removeAttrezzo("Clava"));
		assertNotNull(this.borsa.removeAttrezzo("Spadone a due mani"));
	}

	@Test
	public void testRimuoviAttrezzoNonPresente() {
		assertNull(this.borsa.removeAttrezzo("Clava"));
	}

	@Test
	public void testRimuoviAttrezzoDaBorsaVuota() {
		assertNull(this.borsa.removeAttrezzo("Clava"));
	}

	@Test
	public void testHaUnAttrezzoPresente() {
		this.borsa.addAttrezzo(new Attrezzo("Clava", 1));
		assertTrue(this.borsa.hasAttrezzo("Clava"));
	}

	@Test
	public void testHaUnAttrezzoNonPresente() {
		this.borsa.addAttrezzo(new Attrezzo("Clava", 1));
		assertFalse(this.borsa.hasAttrezzo("Spadone"));
	}

	@Test
	public void testHaUnAttrezzoLaBorsaVuota() {
		assertFalse(this.borsa.hasAttrezzo("Spadone"));
	}

	@Test
	public void testPrendiUnAttrezzoPresente() {
		this.borsa.addAttrezzo(new Attrezzo("Clava", 1));
		assertEquals("Clava", this.borsa.getAttrezzo("Clava").getNome());
	}

	@Test
	public void testGetAttrezzoFuoriOrdine() {
		this.borsa.addAttrezzo(new Attrezzo("Clava", 1));
		this.borsa.addAttrezzo(new Attrezzo("Spadone a due mani", 1));
		this.borsa.addAttrezzo(new Attrezzo("Sciabola", 1));
		assertEquals("Clava", this.borsa.getAttrezzo("Clava").getNome());
		this.borsa.removeAttrezzo("Spadone a due mani");
		assertNull(this.borsa.getAttrezzo("Spadone a due mani"));
		assertEquals("Sciabola", this.borsa.getAttrezzo("Sciabola").getNome());
	}

	@Test
	public void testPrendiUnAttrezzoNonPresente() {
		this.borsa.addAttrezzo(new Attrezzo("Clava", 1));
		assertNull(this.borsa.getAttrezzo("Spadone"));
	}

	@Test
	public void testPrendiUnAttrezzoDallaBorsaVuota() {
		assertNull(this.borsa.getAttrezzo("Clava"));
	}
}
