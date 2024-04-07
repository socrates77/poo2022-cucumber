package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOTester;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class MagoTest {

	Partita partita;
	Labirinto labirinto;
	IOTester ioConsole;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		this.ioConsole = new IOTester();
	}
	
	@Test
	public void testAgisci() {
		Attrezzo attrezzi[] = { new Attrezzo("Tappeto Volante", 2) };
		AbstractPersonaggio personaggio = new Mago("Mago", "Io sono il mago", new Attrezzo("Tappeto Volante", 2));
		Stanza stanza = new Stanza("Stanza con mago");
		stanza.setPersonaggio(personaggio);
		this.labirinto.setStanzaCorrente(stanza);
		assertEquals(Mago.MESSAGGIO_DONO, personaggio.agisci(this.partita));
		assertEquals(new Attrezzo("Tappeto Volante", 2), stanza.getAttrezzo("Tappeto Volante"));
		assertArrayEquals(attrezzi, stanza.getAttrezzi());
		assertEquals(Mago.MESSAGGIO_SCUSE, personaggio.agisci(partita));
		assertArrayEquals(attrezzi, stanza.getAttrezzi());
	}

}
