/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoPosa extends AbstractComando {
	/**
	 * 
	 */
	private String nomeAttrezzo;
	/**
	 * 
	 */
	public ComandoPosa() {
		this.setNome("posa");
	}
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Giocatore giocatore = partita.getGiocatore();
		Attrezzo attrezzo = null;

		if (this.nomeAttrezzo == null) {
			this.ioConsole.mostraMessaggio("Cosa vuoi posare?");
		} else if(giocatore.hasAttrezzo(nomeAttrezzo)) {
			attrezzo = giocatore.removeAttrezzo(nomeAttrezzo);
			stanzaCorrente.addAttrezzo(attrezzo);
			this.ioConsole.mostraMessaggio("Hai posato "+nomeAttrezzo);
		} else {
			this.ioConsole.mostraMessaggio(nomeAttrezzo+" non c'è nella tua borsa");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
}