/**
 * 
 */
package it.uniroma3.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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

	private List<Attrezzo> creaListaAttrezzi(Attrezzo...attrezzi) {
		List<Attrezzo> listaAttrezzi = new ArrayList<>(attrezzi.length);

		for(Attrezzo attrezzo:attrezzi) {
			listaAttrezzi.add(attrezzo);
		}

		return listaAttrezzi;
	}

	private void aggiungiAttrezzi(List<Attrezzo> l) {
		for(Attrezzo a: l) {
			this.borsa.addAttrezzo(a);
		}
	}
	
	private Map<Integer, Set<Attrezzo>> creaRaggrupatiPerPeso(Attrezzo... attrezzi) {
		Map<Integer, Set<Attrezzo>> raggruppatiPerPeso = new HashMap<>();
		Set<Attrezzo> a;
		for(Attrezzo attrezzo:attrezzi) {
			a = raggruppatiPerPeso.get(attrezzo.getPeso());
			if (a==null) {
				a = new HashSet<>();
			}
			a.add(attrezzo);
			raggruppatiPerPeso.put(attrezzo.getPeso(), a);
		}
		
		return raggruppatiPerPeso;
	}

	private SortedSet<Attrezzo> creaSortedSetOrdinatoPerPeso(Attrezzo...attrezzi) {
		SortedSet<Attrezzo> ats = new TreeSet<>();
		for(Attrezzo attrezzo:attrezzi) {
			ats.add(attrezzo);
		}
		return ats;
	}
	
	@Test
	public void testAggiungiAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(new Attrezzo("Clava", 1)));
	}

	@Test
	public void testAggiungiPiuDiDieciAttrezzi() {
		Attrezzo attrezzo;
		int pesoAggiunto = 0;
		for(int i=1; i <= 12; i++) {
			attrezzo = new Attrezzo("Clava " + i, 1);
			if ( pesoAggiunto + attrezzo.getPeso() <= this.borsa.getPesoMax() ) {
				assertTrue("Attrezzo non inserito " + attrezzo.toString(), this.borsa.addAttrezzo(attrezzo));
				pesoAggiunto += attrezzo.getPeso();
			} else {
				assertFalse("Attrezzo inserito " + attrezzo.toString(), this.borsa.addAttrezzo(attrezzo));
			}
		}
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

	@Test
	public void testGetContenutoOrdinatoPerPeso() { 
		this.aggiungiAttrezzi(
				this.creaListaAttrezzi(
						new Attrezzo("Nome 4", 2),
						new Attrezzo("Nome 0", 1),
						new Attrezzo("Nome 1", 0),
						new Attrezzo("Nome 3", 0),
						new Attrezzo("Nome 2", 0)
						)
				);
		List<Attrezzo> listaOrdinata = this.borsa.getContenutoOrdinatoPerPeso();
		List<Attrezzo> listaDiConfronto = this.creaListaAttrezzi(
				new Attrezzo("Nome 1", 0),
				new Attrezzo("Nome 2", 0),
				new Attrezzo("Nome 3", 0),
				new Attrezzo("Nome 0", 1),
				new Attrezzo("Nome 4", 2)
				);
		assertEquals(listaDiConfronto, listaOrdinata);
		assertNotEquals(new ArrayList<Attrezzo>(), listaOrdinata);
	}

	@Test
	public void testGetContenutoOrdinatoPerNome() {
		this.aggiungiAttrezzi(
				this.creaListaAttrezzi(
						new Attrezzo("Nome 4", 2),
						new Attrezzo("Nome 0", 1),
						new Attrezzo("Nome 1", 0),
						new Attrezzo("Nome 2", 0),
						new Attrezzo("Nome 3", 0)
						)
				);
		List<Attrezzo> listaOrdinata = new ArrayList<>(this.borsa.getContenutoOrdinatoPerNome());
		List<Attrezzo> listaDiConfronto = this.creaListaAttrezzi(
				new Attrezzo("Nome 0", 1),
				new Attrezzo("Nome 1", 0),
				new Attrezzo("Nome 2", 0),
				new Attrezzo("Nome 3", 0),
				new Attrezzo("Nome 4", 2)
				);
		assertEquals(listaDiConfronto, listaOrdinata);
		assertNotEquals(new ArrayList<Attrezzo>(), listaOrdinata);
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		this.aggiungiAttrezzi(
				this.creaListaAttrezzi(
						new Attrezzo("Nome 4", 2),
						new Attrezzo("Nome 0", 1),
						new Attrezzo("Nome 1", 0),
						new Attrezzo("Nome 2", 0),
						new Attrezzo("Nome 3", 0)
						)
				);
		Map<Integer, Set<Attrezzo>> confronto = this.creaRaggrupatiPerPeso(
				new Attrezzo("Nome 4", 2),
				new Attrezzo("Nome 0", 1),
				new Attrezzo("Nome 1", 0),
				new Attrezzo("Nome 2", 0),
				new Attrezzo("Nome 3", 0)
				);
		Map<Integer, Set<Attrezzo>> raggruppatiPerPeso = this.borsa.getContenutoRaggruppatoPerPeso();
		assertEquals(confronto, raggruppatiPerPeso);
		assertNotEquals(new HashMap<Integer, Set<Attrezzo>>(), raggruppatiPerPeso);
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		this.aggiungiAttrezzi(
				this.creaListaAttrezzi(
						new Attrezzo("Nome 4", 2),
						new Attrezzo("Nome 0", 1),
						new Attrezzo("Nome 1", 0),
						new Attrezzo("Nome 2", 0),
						new Attrezzo("Nome 3", 0)
						)
				);
		SortedSet<Attrezzo> confronto = this.creaSortedSetOrdinatoPerPeso(
				new Attrezzo("Nome 4", 2),
				new Attrezzo("Nome 0", 1),
				new Attrezzo("Nome 1", 0),
				new Attrezzo("Nome 2", 0),
				new Attrezzo("Nome 3", 0)
				);
		SortedSet<Attrezzo> sortedSetOrdinatoPerPeso = this.borsa.getSortedSetOrdinatoPerPeso();
		assertEquals(confronto, sortedSetOrdinatoPerPeso);
		assertNotEquals(new TreeSet<Attrezzo>(), sortedSetOrdinatoPerPeso);
	}

	@Test
	public void testGetSortedSetOrdinatoPerPesoStessoPesoDiversoNome() {
		this.aggiungiAttrezzi(
				this.creaListaAttrezzi(
						new Attrezzo("Nome 4", 2),
						new Attrezzo("Nome 3", 2)
						)
				);
		SortedSet<Attrezzo> confronto = this.creaSortedSetOrdinatoPerPeso(
				new Attrezzo("Nome 4", 2),
				new Attrezzo("Nome 3", 2)
				);
		SortedSet<Attrezzo> sortedSetOrdinatoPerPeso = this.borsa.getSortedSetOrdinatoPerPeso();
		assertEquals(2, confronto.size());
		assertEquals(2, this.borsa.getSortedSetOrdinatoPerPeso().size());
		assertEquals(confronto, sortedSetOrdinatoPerPeso);
		assertNotEquals(new TreeSet<Attrezzo>(), sortedSetOrdinatoPerPeso);
	}
}
