/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * @author alessandro
 *
 */
public class ComandoSaluta extends AbstractComando {

	public static final String MESSAGGIO_CHI = "Chi dovrei salutare?...";
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.ioConsole.mostraMessaggio(personaggio.saluta());
		} else {
			this.ioConsole.mostraMessaggio(MESSAGGIO_CHI);
		}
	}
}