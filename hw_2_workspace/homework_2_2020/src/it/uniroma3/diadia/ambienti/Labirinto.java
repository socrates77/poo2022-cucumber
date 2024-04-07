package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Class Labirinto - Costruisce il labirinto
 * 
 * @author Alessandro Manias
 *
 */
public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	public Labirinto() {
		this.creaStanze();
	}
	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	private void creaStanze() {
	
		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo lanternino = new Attrezzo("lanternino",2);
		Attrezzo cratere = new Attrezzo("cratere",1);
		
		/* crea stanze del labirinto */
		Stanza atrio = new StanzaBloccata("Atrio", "sud", "osso");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new StanzaBuia("Aula N10", "lanterna");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza laboratorioIa = new StanzaMagica("Laboratorio IA");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		laboratorio.impostaStanzaAdiacente("sud", laboratorioIa);
		laboratorioIa.impostaStanzaAdiacente("nord", laboratorio);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
	
	    /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(lanternino);
		atrio.addAttrezzo(cratere);
	
		// il gioco comincia nell'atrio
	    stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

}
