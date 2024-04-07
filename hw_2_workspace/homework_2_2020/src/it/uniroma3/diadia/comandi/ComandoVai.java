package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	/**
	 * 
	 */
	private String nome = "vai";
	/**
	 * 
	 */
	private String direzione;
	/**
	 * 
	 */
	private IO ioConsole;

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;

		if(this.direzione==null) {
			this.ioConsole.mostraMessaggio("Dove vuoi andare?");
		} else {

			prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

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
		this.direzione = parametro;	
	}

	@Override
	public void setIO(IO ioConsole) {
		this.ioConsole = ioConsole;
	}

	@Override
	public boolean equals(Object o) {
		if ( o instanceof ComandoVai) {
			ComandoVai that = (ComandoVai) o;
			return this.getNome().equals(that.getNome()) && this.getParametro().equals(that.getParametro());
		} else {
			return false;
		}
	}

	public String getNome() {
		return this.nome;
	}

	public String getParametro() {
		return this.direzione;
	}
}
