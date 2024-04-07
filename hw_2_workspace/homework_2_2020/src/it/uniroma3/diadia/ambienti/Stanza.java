package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private Stanza[] stanzeAdiacenti;
	private int indiceStanzeAdiacenti;
	private String[] direzioni;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.indiceStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 * @return boolean il metodo ha aggiornato la stanza adiacente.
	 */
	public boolean impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;

		for(int i=0; i<this.direzioni.length; i++) {
			if (direzione.equals(this.direzioni[i])) {
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}
		}
		
		if (!aggiornato) {
			if (this.indiceStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni[indiceStanzeAdiacenti] = direzione;
				this.stanzeAdiacenti[indiceStanzeAdiacenti] = stanza;
				this.indiceStanzeAdiacenti++;
				aggiornato = true;
			}
		}

		return aggiornato;
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		
		for(int i=0; i<this.indiceStanzeAdiacenti; i++) {
			if (this.direzioni[i].equals(direzione)) {
				stanza = this.stanzeAdiacenti[i];
			}
		}
		
		return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Attrezzo[] getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false altrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		boolean inserito = false;
		int i = 0;
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			while(!inserito && i < NUMERO_MASSIMO_ATTREZZI) {
				if (this.attrezzi[i]==null) {
					this.attrezzi[i] = attrezzo;
					this.numeroAttrezzi++;
					inserito=true;
				}
				i++;
			}
		}
		
		return inserito;
	}
	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		StringBuilder messaggioAttrezzi = new StringBuilder();

		risultato.append(this.nome);
		risultato.append("\n");
		risultato.append("Uscite: ");
		
		for (String direzione : this.direzioni) {
			if (direzione!=null) {
				risultato.append(" " + direzione);
			}
		}

		risultato.append("\n");
		
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null) {
				messaggioAttrezzi.append(attrezzo.toString()+" ");
			}
		}

		if ( messaggioAttrezzi.length() > 0 ) {
			risultato.append("Attrezzi nella stanza: ");
			risultato.append(messaggioAttrezzi.toString());
		}

		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo == null) {
				continue;
			}
			if (attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if ( attrezzo == null ) {
				continue;
			}
			if (attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		boolean rimosso = false;
		int i = 0;

		while(!rimosso && i < NUMERO_MASSIMO_ATTREZZI) {
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(attrezzo.getNome()) ) {
				this.numeroAttrezzi -= 1;
				this.attrezzi[i] = null;
				rimosso = true;
			}
			i++;
		}

		return rimosso;
	}

	/**
	 * Restituisce un array con le direzioni impostate per le stanze adiacenti.
	 * @return String[] 
	 */
	public String[] getDirezioni() {
		String[] direzioni = new String[this.indiceStanzeAdiacenti];
		for(int i=0; i<this.indiceStanzeAdiacenti; i++)
			direzioni[i] = this.direzioni[i];
		return direzioni;
	}
}