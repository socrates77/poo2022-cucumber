/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

/**
 * @author Alessandro Manias
 *
 */
public interface FabbricaDiComandi {
	/**
	 * 
	 * @param istruzione
	 * @param ioConsole 
	 * @return Comando
	 */
	public Comando costruisciComando(String istruzione, IO ioConsole);
}
