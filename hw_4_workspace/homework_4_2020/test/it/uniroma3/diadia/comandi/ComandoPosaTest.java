/**
 * 
 */
package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOTester;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoPosaTest {

	private Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private IOTester ioConsole;

	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.getLabirinto();
		this.partita = new Partita(this.labirinto);
		this.giocatore = partita.getGiocatore();
		this.giocatore.addAttrezzo(new Attrezzo("osso", 2));
		this.ioConsole = new IOTester();
	}

	@Test
	public void testPosaSenzaParametro() {
		Comando comando = new ComandoPosa();
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("Cosa vuoi posare?", this.ioConsole.getUltimoMessaggio());
	}
	@Test
	public void testPosaAttrezzoNonPresenteInBorsa() {
		Comando comando = new ComandoPosa();
		comando.setParametro("carta");
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("carta non c'è nella tua borsa", this.ioConsole.getUltimoMessaggio());
	}
	@Test
	public void testPosaAttrezzoPresenteInBorsa() {
		Comando comando = new ComandoPosa();
		comando.setParametro("osso");
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("Hai posato osso", this.ioConsole.getUltimoMessaggio());
	}
	
}
