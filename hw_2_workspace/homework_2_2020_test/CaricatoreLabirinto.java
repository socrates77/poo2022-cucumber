package it.uniroma3.diadia.ambienti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaricatoreLabirinto {
	private final String  STANZE   = "Stanze:";
	private final String  ATTREZZI = "Attrezzi:";
	private final String  USCITE   = "Uscite:";
	private final String  ESTREMI = "Estremi:";
	private BufferedReader reader;
	private Map<String, Stanza> nome2stanza;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private int numeroLinea;
	
	public CaricatoreLabirinto(String nomeFile) {
		this.nome2stanza = new HashMap<String,Stanza>();
		this.numeroLinea = 0;
		try {
			this.reader = new BufferedReader(new FileReader(nomeFile));
		} catch (FileNotFoundException e) {
			System.err.println("File " + nomeFile + " non trovato");
			e.printStackTrace();
		}
	}

	public void carica() {
		try {
			this.leggiStanze();
			this.leggiInizialeEvincente();
			this.leggiAttrezzi();
			this.leggiUscite();
		} catch (FormatoFileNonValidoException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private String leggiRiga(BufferedReader reader) throws FormatoFileNonValidoException {
		try {
			this.numeroLinea++;
			String riga = reader.readLine();
			System.err.println("Letta riga "+ this.numeroLinea + ": "+ riga);
			return riga;
		} catch (IOException e) {
				throw new FormatoFileNonValidoException("Problemi lettura file [" + this.numeroLinea + "]");
		}
	}
	
	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = null;
			nomeStanzaIniziale = this.leggiRiga(reader);
			if (!this.stanzaValida(nomeStanzaIniziale))
				throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]: stanza "+ nomeStanzaIniziale +" non definita");
			String nomeStanzaVincente = this.leggiRiga(reader);
			if (!this.stanzaValida(nomeStanzaVincente))
				throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]: stanza"+ nomeStanzaVincente+" non definita");
			String token = this.leggiRiga(reader);
			if (!token.equals(ATTREZZI))
				throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]:" +ATTREZZI +" non trovato");		
			this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
			this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
	}

	private void leggiStanze() throws FormatoFileNonValidoException  {
		String nomeStanza = null;
		nomeStanza = this.leggiRiga(reader);
		if (!nomeStanza.equals(STANZE))
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]"+": "+STANZE +" non trovato");
		nomeStanza = this.leggiRiga(reader);
		while (!nomeStanza.equals(ESTREMI)) {
			if (nomeStanza == null)
				throw new FormatoFileNonValidoException("Termine inaspettata del file [" + this.numeroLinea + "].");
			Stanza stanza = new Stanza(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanza);
			nomeStanza = this.leggiRiga(reader);
		}
	}

	private void posaAttrezzo(Stanza s, Attrezzo a) {
		s.addAttrezzo(a);
	}

	private void leggiAttrezzi() throws FormatoFileNonValidoException {
		String nomeAttrezzo = null;
		String pesoAttrezzo = null;
		String nomeStanza = null; 
		String definizioneAttrezzo = this.leggiRiga(reader);
		
		while (!definizioneAttrezzo.equals(USCITE)) {
			int peso;
			Scanner scannerLinea = new Scanner(definizioneAttrezzo);
			nomeAttrezzo = scannerLinea.next();
			if (nomeAttrezzo == null)
				throw new FormatoFileNonValidoException("Termine inaspettata del file [" + this.numeroLinea + "].");
			pesoAttrezzo = scannerLinea.next();
			try {
				peso = Integer.parseInt(pesoAttrezzo);
			}
			catch (NumberFormatException e) {
				throw new FormatoFileNonValidoException("Peso attrezzo "+nomeAttrezzo+" non valido [" + this.numeroLinea + "].");
			}
			nomeStanza = scannerLinea.next();
			if (!stanzaValida(nomeStanza))
				throw new FormatoFileNonValidoException("Definizione attrezzo "+ nomeAttrezzo+" errata [" + this.numeroLinea + "]" +": stanza" +nomeStanza+" inesistente");
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			posaAttrezzo(nome2stanza.get(nomeStanza), attrezzo);
			definizioneAttrezzo = this.leggiRiga(reader);
		}
	}

	private boolean stanzaValida(String nomeStanza) {
		return this.nome2stanza.containsKey(nomeStanza);
	}

	private void impostaUscita(String nomeUscita, String nomeStanzaPartenza, String nomeStanzaDestinazione) {
		Stanza sp = this.nome2stanza.get(nomeStanzaPartenza);
		Stanza sd = this.nome2stanza.get(nomeStanzaDestinazione);
		sp.impostaStanzaAdiacente(nomeUscita, sd);
	}

	private void leggiUscite() throws FormatoFileNonValidoException {
		String nomeStanzaPartenza = null;
		String nomeUscita = null;
		String nomeStanzaDestinazione = null;
		String datiUscita = this.leggiRiga(reader);
		while (datiUscita != null) {
			Scanner scannerDiLinea = new Scanner(datiUscita);			
			while (scannerDiLinea.hasNext()) {
				nomeStanzaPartenza = scannerDiLinea.next();
				nomeUscita = scannerDiLinea.next();
				nomeStanzaDestinazione = scannerDiLinea.next();
				if (!stanzaValida(nomeStanzaPartenza))
					throw new FormatoFileNonValidoException("Definizione errata uscita [" + this.numeroLinea + "]" + nomeUscita);
				if (!stanzaValida(nomeStanzaDestinazione))
					throw new FormatoFileNonValidoException("Definizione errata uscita [" + this.numeroLinea + "]" + nomeUscita);
				impostaUscita(nomeUscita, nomeStanzaPartenza, nomeStanzaDestinazione);
			}
			datiUscita = this.leggiRiga(reader);
		} 
	}

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
}