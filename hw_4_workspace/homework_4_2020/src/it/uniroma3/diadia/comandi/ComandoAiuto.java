/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoAiuto extends AbstractComando {
	/**
	 * 
	 */
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine", "guarda"};
	
	public ComandoAiuto() {
		this.setNome("aiuto");
	}

	@Override
	public void esegui(Partita partita) {
		StringBuilder elencoComandi = new StringBuilder();

		for(int i=0; i<ComandoAiuto.elencoComandi.length; i++) {
			elencoComandi.append(ComandoAiuto.elencoComandi[i]+" ");
		}
		
		this.ioConsole.mostraMessaggio(elencoComandi.toString().trim());
	}
}