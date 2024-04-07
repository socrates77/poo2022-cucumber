/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoGuarda extends AbstractComando {

	public ComandoGuarda() {
		this.setNome("guarda");
	}

	@Override
	public void esegui(Partita partita) {
		String parametro = this.getParametro() == null ? "" : this.getParametro();
		switch(parametro.toLowerCase()) {
			case "":
				Stanza stanzaCorrente = partita.getStanzaCorrente();
				this.ioConsole.mostraMessaggio(stanzaCorrente.getDescrizione());
				break;
			case "borsa":
				Giocatore giocatore = partita.getGiocatore();
				this.ioConsole.mostraMessaggio(giocatore.getBorsa().toString());
				break;
			default:
				this.ioConsole.mostraMessaggio("Cosa vuoi guardare?");
				break;
		}
	}
}
