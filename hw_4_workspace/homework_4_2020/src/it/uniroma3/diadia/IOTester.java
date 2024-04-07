/**
 * 
 */
package it.uniroma3.diadia;

/**
 * @author Alessandro Manias
 *
 */
public class IOTester implements IO {

	private String ultimoMessaggio;
	@Override
	public void mostraMessaggio(String messaggio) {
		this.ultimoMessaggio = messaggio;
	}

	@Override
	public String leggiRiga() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUltimoMessaggio() {
		return this.ultimoMessaggio;
	}
}
