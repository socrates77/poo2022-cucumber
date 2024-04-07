package it.uniroma3.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.*;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandi fabbricaDiComandi;
	private IO ioConsole;
	
	@Before
	public void setUp() {
		this.fabbricaDiComandi = new FabbricaDiComandiFisarmonica();
		this.ioConsole = new IOConsole(new Scanner(System.in));
	}

	@Test
	public void testCostrisciComandoDaStringaVuota() {
		Comando c = fabbricaDiComandi.costruisciComando("", this.ioConsole);
		Comando c1 = new ComandoNonValido();
		assertEquals(c1, c);
	}

	@Test
	public void testCostrisciComandoInestistente() {
		Comando c = fabbricaDiComandi.costruisciComando("clona", this.ioConsole);
		Comando c1 = new ComandoNonValido();
		assertEquals(c1, c);
	}

	@Test
	public void testCostruisciComandoAiuto() {
		Comando c = fabbricaDiComandi.costruisciComando("aiuto", this.ioConsole);
		Comando c1 = new ComandoAiuto();
		assertEquals(c1, c);
	}

	@Test
	public void testCostruisciComandoFine() {
		Comando c = fabbricaDiComandi.costruisciComando("fine", this.ioConsole);
		Comando c1 = new ComandoFine();
		c1.setIO(ioConsole);
		assertEquals(c1, c);
	}
	
	@Test
	public void testCostruisciComandoGuarda() {
		Comando c = fabbricaDiComandi.costruisciComando("guarda", this.ioConsole);
		Comando c1 = new ComandoGuarda();
		c1.setIO(this.ioConsole);
		assertEquals(c1, c);
	}

	@Test
	public void testCostruisciComandoNonValido() {
		Comando c = fabbricaDiComandi.costruisciComando("test non valido", this.ioConsole);
		Comando c1 = new ComandoNonValido();
		c1.setIO(this.ioConsole);
		assertEquals(c1, c);
	}

	@Test
	public void testCostruisciComandoPosa() {
		Comando c = fabbricaDiComandi.costruisciComando("posa osso", this.ioConsole);
		Comando c1 = new ComandoPosa();
		c1.setIO(this.ioConsole);
		c1.setParametro("osso");
		assertEquals(c1, c);
	}

	@Test
	public void testCostruisciComandoPrendi() {
		Comando c = fabbricaDiComandi.costruisciComando("prendi osso", this.ioConsole);
		Comando c1 = new ComandoPrendi();
		c1.setIO(this.ioConsole);
		c1.setParametro("osso");
		assertEquals(c1, c);
	}

	@Test
	public void testCostrisciComandoVai() {
		Comando c = fabbricaDiComandi.costruisciComando("vai nord", this.ioConsole);
		Comando c1 = new ComandoVai();
		c1.setParametro("nord");
		c1.setIO(this.ioConsole);
		assertEquals(c1, c);
	}	
}
