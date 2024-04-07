/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Alessandro Manias
 *
 */
public class StanzaMagica extends Stanza {
	/**
	 * 
	 */
	private int contatoreAttrezziPosati = 1;
	/**
	 * 
	 */
	private int sogliaMagica;
	/**
	 * 
	 */
	private static int SOGLIA_MAGICA_DEFAULT = 2;
	/**
	 * 
	 */
	public StanzaMagica(String nome) {
		this(nome, StanzaMagica.SOGLIA_MAGICA_DEFAULT);
	}
	/**
	 * 
	 */
	public StanzaMagica(String nome, int sogliaMagica) {
		super(nome);
		this.sogliaMagica = sogliaMagica;
	}
	/**
	 * 
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		int pesoX2 = attrezzo.getPeso()*2;
		StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
		
		return new Attrezzo(nomeInvertito.reverse().toString(), pesoX2);
	}
	/**
	 * 
	 */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.contatoreAttrezziPosati > this.sogliaMagica) {
			return super.addAttrezzo(this.modificaAttrezzo(attrezzo));
		} else {
			this.contatoreAttrezziPosati++;
			return super.addAttrezzo(attrezzo);
		}
	}
}
