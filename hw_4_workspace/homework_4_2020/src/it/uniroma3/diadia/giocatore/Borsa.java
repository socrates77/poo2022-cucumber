/**
 * 
 */
package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;

/**
 * Class Borsa - Contiene gli attrezzi del giocatore.
 * 
 * @author docente di POO
 *
 */
public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoAttuale;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.pesoAttuale += attrezzo.getPeso();
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}

	public int getPesoMax() {
		return this.pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoTrovato = null;
		
		attrezzoTrovato = this.attrezzi.get(nomeAttrezzo);
		
		return attrezzoTrovato;
	}

	public int getPeso() {
		return this.pesoAttuale;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoAttuale = this.getAttrezzo(nomeAttrezzo);
		if (attrezzoAttuale!=null) {
			this.pesoAttuale -= attrezzoAttuale.getPeso();
			this.attrezzi.remove(attrezzoAttuale.getNome());
		}
		return attrezzoAttuale;
	}
	
	/**
	 * Restituisce la lista degli attrezzi nella borsa ordinati per peso e 
	 * quindi, a parità di peso, per nome.
	 * 
	 * @return
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> attrezziOrdinati = new ArrayList<>(this.attrezzi.values());
		Collections.sort(attrezziOrdinati);
		
		return attrezziOrdinati;
	}
	/**
	 * Restituisce l'insieme degli attrezzi nella borsa ordinati per nome.
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		TreeSet<Attrezzo> attrezziOrdinati = new TreeSet<Attrezzo>(new ComparatorePerNome());
		attrezziOrdinati.addAll(this.attrezzi.values());
		return attrezziOrdinati;
	}
	/**
	 * restituisce una mappa che associa un intero (rappresentante un peso)
	 * con l’insieme (comunque non vuoto) degli attrezzi di tale peso.
	 */
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		HashMap<Integer, Set<Attrezzo>> attrezziPerPeso = new HashMap<>();
		Set<Attrezzo> attrezzi;
		for(Attrezzo a:this.attrezzi.values()) {
			attrezzi = attrezziPerPeso.get(a.getPeso());
			if(attrezzi==null) {
				attrezzi = new HashSet<>();
			}
			attrezzi.add(a);
			attrezziPerPeso.put(a.getPeso(), attrezzi);
		}

		return attrezziPerPeso; 
	}
	/**
	 * Restituisce l'insieme gli attrezzi nella borsa
	 * ordinati per peso e quindi, a parità di peso, per nome.
	 * 
	 */
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.getContenutoOrdinatoPerPeso());
		}
		else {
			s.append("Borsa vuota");
		}
		
		return s.toString();
	}
}