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
public class ComandoPrendi extends AbstractComando {
	/**
	 * 
	 */
	private String nomeAttrezzo;
	/**
	 * 
	 */
	public ComandoPrendi() {
		this.setNome("prendi");
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Giocatore giocatore = partita.getGiocatore();
		Attrezzo attrezzo;

		if (nomeAttrezzo == null) {
			this.ioConsole.mostraMessaggio("Cosa vuoi prendere?");
		} else if (stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
			if (giocatore.addAttrezzo(attrezzo)) {
				stanzaCorrente.removeAttrezzo(attrezzo);
				this.ioConsole.mostraMessaggio("Hai preso "+nomeAttrezzo);
			} else {
				this.ioConsole.mostraMessaggio("Non puoi trasportare "+nomeAttrezzo);
			}
		} else {
			this.ioConsole.mostraMessaggio(nomeAttrezzo+" non c'è in questa stanza");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
}
