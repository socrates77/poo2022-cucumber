package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.finita = false;
		this.giocatore = new Giocatore(CFU_INIZIALI);
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}
    /**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.getStanzaVincente();
	}

	/**
	 * Restituisce la stanza corrente del giocatore.
	 * 
	 * @return Stanza la stanza in cui si trova il gocatore.
	 */
	public Stanza getStanzaCorrente() {
		return this.labirinto.getStanzaCorrente();
	}
	
	/**
	 * Restituisce la stanza vincente del labirinto.
	 * 
	 * @return Stanza è la stanza vincente del labirinto.
	 */
	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}

	/**
	 * Cambia la stanza corrente del giocatore.
	 * 
	 * @param stanzaCorrente è la nuova stanza corrente.
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.setStanzaCorrente(stanzaCorrente);
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.giocatore.getCfu();
	}

	public void setCfu(int cfu) {
		this.giocatore.setCfu(cfu);		
	}	
}
