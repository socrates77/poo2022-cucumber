/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoNonValido implements Comando {
	/**
	 * 
	 */
	private String nome = "non valido";
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
		this.ioConsole.mostraMessaggio("Comando sconosciuto");
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
		if(o instanceof ComandoNonValido) {
			ComandoNonValido that = (ComandoNonValido) o;
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
