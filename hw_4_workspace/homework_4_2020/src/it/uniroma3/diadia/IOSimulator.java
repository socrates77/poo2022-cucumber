/**
 * 
 */
package it.uniroma3.diadia;

/**
 * @author Alessandro Manias
 *
 */
public class IOSimulator implements IO {
	/**
	 * 
	 */
	private String[] righeDaLeggere;
	/**
	 * 
	 */
	private int indiceRigheLette;
	/**
	 * 
	 */
	private String[] messaggiRicevuti;
	/**
	 * 
	 */
	private int indiceMessaggiRicevuti;
	/**
	 * 
	 */
	private int indiceMessaggiLetti;
	/**
	 * 
	 * @param righeDaLeggere
	 */
	public IOSimulator(String[] righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.messaggiRicevuti = new String[100];
		this.indiceRigheLette = 0;
		this.indiceMessaggiRicevuti = 0;
		this.indiceMessaggiLetti = 0;
	}
	/**
	 * 
	 */
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiRicevuti[this.indiceMessaggiRicevuti] = messaggio;
		this.indiceMessaggiRicevuti++;
	}

	@Override
	public String leggiRiga() {
		String rigaLetta = this.righeDaLeggere[this.indiceRigheLette];
		this.indiceRigheLette++;
		return rigaLetta;
	}
	/**
	 * 
	 */
	public String nextMessaggio() {
		String messaggio = this.messaggiRicevuti[this.indiceMessaggiLetti];
		this.indiceMessaggiLetti++;
		return messaggio; 
	}
	/**
	 * 
	 */
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiLetti < this.indiceMessaggiRicevuti;
	}
}
