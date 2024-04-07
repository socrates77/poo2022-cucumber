/**
 * 
 */
package it.uniroma3.diadia;

/**
 * Interfaccia utilizzata per l'ingresso uscita dal DiaDia.
 * 
 * @author Alessandro Manias
 *
 */
public interface IO {
	/**
	 * @param String messaggio inviato da {@code}DiaDia
	 * 
	 */
	public void mostraMessaggio(String msg);
	/**
	 * 
	 * @return String Ultima riga letta.
	 * 
	 */
	public String leggiRiga();
}
