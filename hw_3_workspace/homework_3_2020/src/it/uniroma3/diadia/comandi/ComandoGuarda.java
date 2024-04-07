/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoGuarda implements Comando {
	/**
	 * 
	 */
	private String nome = "guarda";
	/**
	 * 
	 */
	private String parametro = "";
	/**
	 * 
	 */
	private IO ioConsole;

	@Override
	public void esegui(Partita partita) {
		String parametro = this.parametro == null ? "" : this.parametro;
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

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public void setIO(IO ioConsole) {
		this.ioConsole = ioConsole;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ComandoGuarda) {
			ComandoGuarda that = (ComandoGuarda) o;
			return this.getNome().equals(that.getNome());
		} else {
			return false;
		}
	}

	public String getNome() {
		return this.nome;
	}

	public String getParametro() {
		return this.parametro;
	}
}
