/**
 * 
 */
package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

/**
 * @author Alessandro Manias
 *
 */
public class ComparatorePerNome implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
