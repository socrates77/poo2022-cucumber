/**
 * 
 */
package it.uniroma3.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOTester;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoPosaTest {

	private Partita partita;
	private Giocatore giocatore;
	private IOTester ioConsole;

	@Before
	public void setUp() {
		this.partita = new Partita();
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
