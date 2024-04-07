package it.uniroma3.diadia.ambienti;
/**
 * Class Labirinto - Gestisce il labirinto
 * 
 * @author Alessandro Manias
 *
 */
public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
}
