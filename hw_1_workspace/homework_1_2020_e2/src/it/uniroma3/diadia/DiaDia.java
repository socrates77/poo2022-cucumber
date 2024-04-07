package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

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
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;
	private IOConsole ioConsole;

	public DiaDia(IOConsole ioConsole) {
		this.partita = new Partita();
		this.ioConsole = ioConsole;
	}
	
	public DiaDia() {
		this.partita = new Partita();
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
		Comando comandoDaEseguire = new Comando(istruzione);

		if ( comandoDaEseguire.getNome() == null ) {
			this.aiuto();
		} else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro());
		} else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
		} else {
			this.ioConsole.mostraMessaggio("Comando sconosciuto");
		}
		
		if (this.partita.isFinita()) {
			if (this.partita.vinta()) {
				this.ioConsole.mostraMessaggio("Hai vinto!");
				return true;
			} else {
				this.ioConsole.mostraMessaggio("Hai perso!");
				return true;
			}
		} else {
			return false;
		}
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		StringBuilder elencoComandi = new StringBuilder();
		for(int i=0; i< DiaDia.elencoComandi.length; i++) 
			elencoComandi.append(DiaDia.elencoComandi[i]+" ");
		this.ioConsole.mostraMessaggio(elencoComandi.toString());
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.ioConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.ioConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			cfu -= 1;
			this.partita.setCfu(cfu);
		}
		this.ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.ioConsole.mostraMessaggio("\n");
	}
	
	/**
	 * Comando "Prendi"
	 * @param nomeAttrezzo
	 */
	private void prendi(String nomeAttrezzo) {
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		Attrezzo attrezzo;
		if (nomeAttrezzo == null) {
			this.ioConsole.mostraMessaggio("Cosa vuoi prendere?");
			this.ioConsole.mostraMessaggio(stanzaCorrente.getDescrizione());
		} else if (stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
			stanzaCorrente.removeAttrezzo(attrezzo);
			this.partita.getGiocatore().addAttrezzo(attrezzo);
			this.ioConsole.mostraMessaggio("Hai preso "+nomeAttrezzo);
		} else {
			this.ioConsole.mostraMessaggio(nomeAttrezzo+" non c'è in questa stanza");
		}
	}
	
	private void posa(String nomeAttrezzo) {
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		Attrezzo attrezzo;
		if (nomeAttrezzo == null) {
			this.ioConsole.mostraMessaggio("Cosa vuoi posare?");
			this.ioConsole.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
		} else if(this.partita.getGiocatore().hasAttrezzo(nomeAttrezzo)) {
			attrezzo = this.partita.getGiocatore().removeAttrezzo(nomeAttrezzo);
			stanzaCorrente.addAttrezzo(attrezzo);
			this.ioConsole.mostraMessaggio("Hai posato "+nomeAttrezzo);
			this.ioConsole.mostraMessaggio(stanzaCorrente.getDescrizione());
		} else {
			this.ioConsole.mostraMessaggio(nomeAttrezzo+" non c'è nella tua borsa");
		}
	}
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole ioConsole = new IOConsole();
		DiaDia gioco = new DiaDia(ioConsole);
		gioco.gioca();
	}
}