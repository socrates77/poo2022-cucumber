/**
 * 
 */
package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Alessandro Manias
 *
 */
public class IOCucumber implements IO {
	/**
	 * 
	 */
	private Collection<String> righeDaLeggere;
	/**
	 * 
	 */
	private Iterator<String> iteratorDiRighe;
	/**
	 * 
	 */
	private Collection<String> messaggiRicevuti;
	/**
	 * 
	 */
	private Iterator<String> iteratorDiMessaggi;
	/**
	 * 
	 * @param righeDaLeggere
	 */
	public IOCucumber() {
		this.righeDaLeggere = new ArrayList<String>();
		this.messaggiRicevuti = new ArrayList<String>();
	}
	
	public void setRigheDaLeggere(Collection<String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.iteratorDiRighe = this.righeDaLeggere.iterator();
	}
	/**
	 * 
	 */
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiRicevuti.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		return this.iteratorDiRighe.next();
	}
	/**
	 * Crea un iteratore per scorrere la lista dei messaggi.
	 */
	public void messaggiIterator() {
		this.iteratorDiMessaggi = this.messaggiRicevuti.iterator();
	}
	/**
	 * 
	 */
	public String nextMessaggio() {
		return this.iteratorDiMessaggi.next(); 
	}
	/**
	 * 
	 */
	public boolean hasNextMessaggio() {
		return this.iteratorDiMessaggi.hasNext();
	}
}
