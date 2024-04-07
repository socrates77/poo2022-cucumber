/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

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
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		this.ioConsole.mostraMessaggio(stanzaCorrente.getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {

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
