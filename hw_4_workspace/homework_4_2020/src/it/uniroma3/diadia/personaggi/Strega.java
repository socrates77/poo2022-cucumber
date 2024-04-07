/**
 * 
 */
package it.uniroma3.diadia.personaggi;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Alessandro Manias
 *
 */
public class Strega extends AbstractPersonaggio {
	class StanzaComparatorAscending implements Comparator<Stanza> {
		public int compare(Stanza o1, Stanza o2) {
			int value = o1.getAttrezzi().length - o2.getAttrezzi().length;
			if ( value > 0 ) {
				return 1;
			} else if (value < 0 ) {
				return -1;
			} else { 
				return 0;
			}
		}
	}

	class StanzaComparatorDescending implements Comparator<Stanza> {
		public int compare(Stanza o1, Stanza o2) {
			int value = o1.getAttrezzi().length - o2.getAttrezzi().length;
			if ( value < 0 ) {
				return 1;
			} else if (value > 0 ) {
				return -1;
			} else { 
				return 0;
			}
		}
	}

	private static String MESSAGGIO_TRASFERTA = "Ahahahah!!!";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Collection<Stanza> stanze;

		if ( this.haSalutato() ) {
			stanze = new TreeSet<Stanza>(new StanzaComparatorDescending());
		} else {
			stanze = new TreeSet<>(new StanzaComparatorAscending());
		}

		for (Direzione corrente: stanzaCorrente.getDirezioni()) {
			stanze.add(stanzaCorrente.getStanzaAdiacente(corrente));
		}
		
		if ( ! stanze.isEmpty() ) {
			partita.setStanzaCorrente((Stanza)stanze.toArray()[0]);
		}
		
		return Strega.MESSAGGIO_TRASFERTA;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo) {
		return "";
	}
}