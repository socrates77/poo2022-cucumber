package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import it.uniroma3.diadia.IOTester;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisciTest {

	public static String NOME = "Personaggio";
	
	public static String PRESENTAZIONE = "Presentazione";
	
	public static String AZIONE = "Azione";
	
	class Personaggio extends AbstractPersonaggio {
		/**
		 * 
		 */
		public Personaggio() {
			super(ComandoInteragisciTest.NOME, ComandoInteragisciTest.PRESENTAZIONE);
		}
		
		@Override
		public String agisci(Partita partita) {
			return ComandoInteragisciTest.AZIONE;
		}
		
		@Override
		public String riceviRegalo(Attrezzo attrezzo) {
			return "";
		}
	}
	
	private Partita partita;
	private IOTester ioConsole;
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		this.partita = new Partita();
		this.partita.setLabirinto(labirinto);
		this.ioConsole = new IOTester();
	}
	
	@Test
	public void testInteragisciStanzaSenzaPersonaggio() {
		Stanza stanza = new Stanza("Stanza senza personaggio");
		Comando co = new ComandoInteragisci();
		co.setIO(this.ioConsole);
		this.labirinto.setStanzaCorrente(stanza);
		co.esegui(this.partita);
		assertEquals(ComandoInteragisci.MESSAGGIO_CON_CHI, this.ioConsole.getUltimoMessaggio());
	}
	
	@Test
	public void testGetMessaggioStanzaConPersonaggio() {
		Stanza stanza = new Stanza("Stanza con personaggio");
		stanza.setPersonaggio(new Personaggio());
		this.labirinto.setStanzaCorrente(stanza);
		Comando co = new ComandoInteragisci();
		co.setIO(this.ioConsole);
		co.esegui(partita);
		assertEquals(ComandoInteragisciTest.AZIONE, this.ioConsole.getUltimoMessaggio());
	}

}
