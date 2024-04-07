package it.uniroma3.comandi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import it.uniroma3.diadia.IOTester;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	private Partita partita;
	private IOTester ioConsole;

	@Before
	public void setUp() {
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		this.partita = new Partita();
		this.partita.setLabirinto(labirinto);
		this.ioConsole = new IOTester();
	}


	@Test
	public void testEseguiSenzaDirezione() {
		Comando comando = new ComandoVai();
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("Dove vuoi andare?", this.ioConsole.getUltimoMessaggio());
	}

	@Test
	public void testEseguiDirezioneInesistente() {
		Comando comando = new ComandoVai();
		comando.setParametro("sud");
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("Direzione inesistente", this.ioConsole.getUltimoMessaggio());
	}
	
	@Test
	public void testEseguiDirezioneCorretta() {
		Comando comando = new ComandoVai();
		comando.setParametro("nord");
		comando.setIO(this.ioConsole);
		comando.esegui(this.partita);
		assertEquals("Biblioteca\nUscite:  sud\n", this.ioConsole.getUltimoMessaggio());
	}
}
