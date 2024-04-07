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

public class ComandoSalutaTest {

	public static String NOME = "Personaggio";
	
	public static String PRESENTAZIONE = new String("Presentazione");

	class Personaggio extends AbstractPersonaggio {
				
		public Personaggio() {
			super(ComandoSalutaTest.NOME, ComandoSalutaTest.PRESENTAZIONE);
		}
		
		@Override
		public String agisci(Partita partita) {
			return "";
		}

		@Override
		public String riceviRegalo(Attrezzo attrezzo) {
			// TODO Auto-generated method stub
			return null;
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
	public void tesSalutaInStanzaSenzaPersonaggio() {
		Stanza stanza = new Stanza("Stanza senza personaggio");
		Comando co = new ComandoSaluta();
		co.setIO(this.ioConsole);
		this.labirinto.setStanzaCorrente(stanza);
		co.esegui(this.partita);
		assertEquals(ComandoSaluta.MESSAGGIO_CHI, this.ioConsole.getUltimoMessaggio());
		
	}
	
	@Test
	public void testSalutaInStanzaConPersonaggio() {
		Stanza stanza = new Stanza("Stanza con personaggio");
		stanza.setPersonaggio(new Personaggio());
		this.labirinto.setStanzaCorrente(stanza);
		Comando co = new ComandoSaluta();
		co.setIO(this.ioConsole);
		co.esegui(partita);
		assertEquals(
			"Ciao, io sono " + ComandoSalutaTest.NOME + ". " +
					ComandoSalutaTest.PRESENTAZIONE,
			 this.ioConsole.getUltimoMessaggio()
		 );
	}

}
