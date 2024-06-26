package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	/**
	 * 
	 */
	private Direzione direzione;
	/**
	 * 
	 */
	public ComandoVai() {
		this.setNome("vai");
	}

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;

		if(this.getDirezione()==null) {
			this.ioConsole.mostraMessaggio("Dove vuoi andare?");
		} else {

			prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.getDirezione());

			if (prossimaStanza == null) {
				this.ioConsole.mostraMessaggio("Direzione inesistente");
			} else {
				partita.setStanzaCorrente(prossimaStanza);
				int cfu = partita.getCfu();
				cfu -= 1;
				partita.setCfu(cfu);
				this.ioConsole.mostraMessaggio(prossimaStanza.getDescrizione());
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		super.setParametro(parametro);
		this.setDirezione(Direzione.valueOf(parametro.toUpperCase()));
	}
	
	public void setDirezione(Direzione direzione) {
		this.direzione = direzione;
	}
	
	public Direzione getDirezione() {
		return this.direzione;
	}
}
