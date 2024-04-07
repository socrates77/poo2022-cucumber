package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
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

	public DiaDia(Labirinto labirinto, IO ioConsole) {
		this(ioConsole);
		this.partita = new Partita(labirinto);
	}
	
	public DiaDia(IO ioConsole) {
		this.partita = new Partita();
		this.ioConsole = ioConsole;
	}
	
	public DiaDia() {
		this.partita = new Partita();
	}

	public void setLabirinto(Labirinto labirinto) {
		this.partita.setLabirinto(labirinto);
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
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 1)
				.addAttrezzo("sasso", 1)
				.addStanzaVincente("Biblioteca")
				.addStanzaBloccata("Aula N11", "ovest", "osso")
				.addStanzaBuia("Aula N10", "lanterna")
				.addAttrezzo("lanterna", 3)
				.addStanza("Laboratorio Campus")
				.addStanzaMagica("Laboratorio IA")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Atrio", "Aula N10", "sud")
				.addAdiacenza("Atrio", "Aula N11", "est")
				.addAdiacenza("Atrio", "Laboratorio Campus", "ovest")
				.addAdiacenza("Aula N11", "Laboratorio Campus", "est")
				.addAdiacenza("Aula N11", "Atrio", "ovest")
				.addAdiacenza("Aula N10", "Atrio", "nord")
				.addAdiacenza("Aula N10", "Aula N11", "est")
				.addAdiacenza("Aula N10", "Laboratorio Campus", "ovest")
				.addAdiacenza("Laboratorio Campus", "Atrio", "est")
				.addAdiacenza("Laboratorio Campus", "Aula N11", "ovest")
				.addAdiacenza("Laboratorio Campus", "Laboratorio IA", "sud")
				.addAdiacenza("Laboratorio IA", "Laboratorio Campus", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, ioConsole);
		gioco.gioca();
	}
}