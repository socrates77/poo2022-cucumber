package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.comandi.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	private Partita partita;
	private IO ioConsole;

	public DiaDia(IO ioConsole) {
		this.partita = new Partita();
		this.ioConsole = ioConsole;
	}
	
	public DiaDia() {
		this.partita = new Partita();
	}

	public void setIO(IO ioConsole) {
		this.ioConsole = ioConsole;
	}
	
	public void gioca() {
		String istruzione;

		ioConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = ioConsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		FabbricaDiComandi fabbricaDiComandi = new FabbricaDiComandiFisarmonica();
		Comando comandoDaEseguire = fabbricaDiComandi.costruisciComando(istruzione, this.ioConsole);

		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.isFinita()) {
			if (this.partita.vinta()) {
				this.ioConsole.mostraMessaggio("Hai vinto!");
				return true;
			} else if (false == this.partita.giocatoreIsVivo()) {
				this.ioConsole.mostraMessaggio("Hai perso!");
				return true;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}   

	public static void main(String[] argc) {
		IO ioConsole = new IOConsole(new Scanner(System.in));
		DiaDia gioco = new DiaDia(ioConsole);
		gioco.gioca();
	}
}