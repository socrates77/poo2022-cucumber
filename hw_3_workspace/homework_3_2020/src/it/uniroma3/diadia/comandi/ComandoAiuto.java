/**
 * 
 */
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoAiuto implements Comando {
	/**
	 * 
	 */
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine", "guarda"};
	/**
	 * 
	 */
	private String nome = "aiuto";
	/**
	 * 
	 */
	private String parametro = "";
	/**
	 * 
	 */
	private IO ioConsole;
	
	@Override
	public void esegui(Partita partita) {
		StringBuilder elencoComandi = new StringBuilder();

		for(int i=0; i<ComandoAiuto.elencoComandi.length; i++) {
			elencoComandi.append(ComandoAiuto.elencoComandi[i]+" ");
		}
		
		this.ioConsole.mostraMessaggio(elencoComandi.toString().trim());
	}

	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public void setIO(IO ioConsole) {
		this.ioConsole = ioConsole;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ComandoAiuto) {
			ComandoAiuto that = (ComandoAiuto) o;
			return this.getNome().equals(that.getNome());
		} else {
			return false;
		}
	}
	
	public String getNome() {	
		return this.nome;
	}

	public String getParametro() {
		return this.parametro;
	}
}
