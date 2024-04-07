package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Interfaccia che modella un comando.
 * 
 * @author  Alessandro Manias
 * @version hw2
 */

public interface Comando {
	/**
	 * 
	 * @param partita
	 */
	public void esegui(Partita partita);
	/**
	 * 
	 * @param parametro
	 */
	public void setParametro(String parametro);
	/**
	 * 
	 * @param ioConsole
	 */
	public void setIO(IO ioConsole);
	/**
	 * @return String
	 */
	public String getNome();
	/**
	 * 
	 * @return String
	 */
	public String getParametro();
}
