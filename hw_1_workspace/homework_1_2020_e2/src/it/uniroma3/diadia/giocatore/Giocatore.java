/**
 * 
 */
package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Giocatore - Conta i Cfu e possiede una borsa in cui mettere attrezzi.
 * 
 * @author Alessandro Manias
 *
 */
public class Giocatore {

	private int cfu;
	private Borsa borsa;

	/**
	 * Costruisce una classe Giocatore con una borsa avuota.
	 * 
	 * @param cfu numero di cfu del Giocatore.
	 */
	public Giocatore(int cfu) {
		this.cfu = cfu;
		this.borsa = new Borsa();
	}
	
	/**
	 * Imposta i cfu del Giocatore.
	 * 
	 * @param cfu 
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	/**
	 * Ritorna il numero dei cfu del Giocatore.
	 * 
	 * @return
	 */
	public int getCfu() {
		return this.cfu;
	}
	
	/**
	 * Restituisce la Borsa del Giocatore.
	 * 
	 * @return Borsa la borsa del Giocatore
	 */
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	/**
	 * Aggiunge una attrezzo alla borsa del Giocatore.
	 * 
	 * @param attrezzo l'attrezzo dal mettere nella borsa.
	 * @return boolean L'attrezzo è stato messo in borsa?
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.borsa.addAttrezzo(attrezzo);
	}
	
	/**
	 * Rimuove l'attrezzo con nome nomeAtterezzo dalla borsa del giocatore
	 * se prensente. Restituisce null se l'attrezzo non c'è nella Borsa.
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo
	 * @return l'attrezzo rimosso dalla Borsa.
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo);
	}
	
	/**
	 * Il Giocatore ha l'attrezzo con nomeAttrezzo nella borsa?
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo cercato.
	 * @return boolean Il Giocatore ha l'attrezzo in Borsa.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.borsa.hasAttrezzo(nomeAttrezzo);
	}
	
	/**
	 * Prende l'attrezzo dalla borsa del Giocatore.
	 * @param nomeAttrezzo il nome dell'attrezzo da prendere.
	 * @return Attrezzo l'atterzzo preso dalla borsa.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.borsa.getAttrezzo(nomeAttrezzo);
	}
}
