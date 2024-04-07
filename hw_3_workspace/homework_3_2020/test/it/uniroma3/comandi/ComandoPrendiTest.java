/**
 * 
 */
package it.uniroma3.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOTester;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

/**
 * @author Alessandro Manias
 *
 */
public class ComandoPrendiTest {

	private Partita partita;
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private IOTester ioConsole;

	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 1)
				.addAttrezzo("osso pesante", 11)
				.getLabirinto();
		this.stanzaCorrente = this.labirinto.getStanzaCorrente();
		this.partita = new Partita(this.labirinto);
		this.ioConsole = new IOTester();
	}

	@Test
	public void testPrendiSenzaParametro() {
		Comando comando = new ComandoPrendi();
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("Cosa vuoi prendere?", this.ioConsole.getUltimoMessaggio());
	}

	@Test
	public void testPrendiAttezzoPresenteNellaStanza() {
		Comando comando = new ComandoPrendi();
		comando.setParametro("osso");
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("Hai preso osso", this.ioConsole.getUltimoMessaggio());
	}

	@Test
	public void testPrendiAttezzoTroppoPesante() {
		Comando comando = new ComandoPrendi();
		comando.setParametro("osso pesante");
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("Non puoi trasportare osso pesante", this.ioConsole.getUltimoMessaggio());
		assertTrue(this.stanzaCorrente.hasAttrezzo("osso pesante"));
	}

	@Test
	public void testPrendiAttrezzoNonPresenteNellaStanza() {
		Comando comando = new ComandoPrendi();
		comando.setParametro("carta");
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("carta non c'è in questa stanza", this.ioConsole.getUltimoMessaggio());
	}
}
