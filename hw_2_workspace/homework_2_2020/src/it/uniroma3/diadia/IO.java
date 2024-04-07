/**
 * 
 */
package it.uniroma3.diadia;

/**
 * Interfaccia per disaccoppiare l'input e l'output.
 * 
 * @author Alessandro Manias
 *
 */
public interface IO {
	/**
	 * 
	 * @param messaggio
	 */
	public void mostraMessaggio(String messaggio);
	/**
	 * 
	 * @return
	 */
	public String leggiRiga();
}
