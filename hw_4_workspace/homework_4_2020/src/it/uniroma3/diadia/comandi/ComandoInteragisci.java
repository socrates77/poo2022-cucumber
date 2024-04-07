/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoInteragisci extends AbstractComando {

	public static String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?...";

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Stanza stanza = partita.getStanzaCorrente();
		AbstractPersonaggio personaggio = stanza.getPersonaggio();
		
		if (personaggio!=null) {
			this.ioConsole.mostraMessaggio(personaggio.agisci(partita));
		} else {
			this.ioConsole.mostraMessaggio(MESSAGGIO_CON_CHI);
		}
	}
}
