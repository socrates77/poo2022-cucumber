/**
 * 
 */
package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
/**
 * @author Alessandro Manias
 *
 */
public class Cane extends AbstractPersonaggio {

	public static final String MESSAGGIO = "Woof Woof GRRRR!";
	
	public static final String MESSAGGIO_PRESENTAZIONE = "Woof Woof Woof GRRRRR! GRRRR!";

	public Cane(String nome) {
		super(nome, Cane.MESSAGGIO_PRESENTAZIONE);
	}
	
	@Override
	public String agisci(Partita partita) {
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1 );

		return Cane.MESSAGGIO + 
				" Sei stato morso. Ora hai " + giocatore.getCfu() + " CFU";
	}

	public boolean isPreferito(Attrezzo attrezzo) {
		Attrezzo attrezzoPreferito = this.getAttrezzo();
		return attrezzo.equals(attrezzoPreferito);
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo) {
		if ( this.isPreferito( attrezzo ) ) {
			return "Woof Woof!";
		} else {
			return "Woof Woof GRRR!!!";
		}
	}
}