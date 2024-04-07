package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class IOConsole implements IO {

	private Scanner scannerDiLinee;
	private List<String> messaggiAccodati;
	private Iterator<String> messaggiDaLeggere;

	public IOConsole(Scanner scannerDiLinee) {
		this.scannerDiLinee = scannerDiLinee;
		this.messaggiAccodati = new ArrayList<String>();
	}
	public void mostraMessaggio(String msg) {
		this.messaggiAccodati.add(msg);
	}

	public String leggiRiga() {
//		String riga = scannerDiLinee.nextLine();
		return "1n";
	}
	
	public boolean hasNextMessaggio() {
		if (this.messaggiDaLeggere == null) {
			this.messaggiDaLeggere = this.messaggiAccodati.iterator();
		}
		return this.messaggiDaLeggere.hasNext();
	}
	
	public String nextMessaggio() {
		return this.messaggiDaLeggere.next();
	}
}