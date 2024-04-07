package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {

	private FabricaDiComandi fabricaDiComandi;
	private IO ioConsole;
	
	@Before
	public void setUp() {
		this.fabricaDiComandi = new FabricaDiComandiFisarmonica();
		this.ioConsole = new IOConsole(new Scanner(System.in));
	}

	@Test
	public void testCostrisciComandoDaStringaVuota() {
		Comando c = fabricaDiComandi.costruisciComando("", this.ioConsole);
		Comando c1 = new ComandoNonValido();;
		assertEquals(c1.getClass(), c.getClass());
	}

	@Test
	public void testCostrisciComandoInestistente() {
		Comando c = fabricaDiComandi.costruisciComando("clona", this.ioConsole);
		Comando c1 = new ComandoNonValido();
		assertEquals(c1.getClass(), c.getClass());
	}

	@Test
	public void testCostruisciComandoAiuto() {
		Comando c = fabricaDiComandi.costruisciComando("aiuto", this.ioConsole);
		Comando c1 = new ComandoAiuto();
		assertEquals(c1.getClass(), c.getClass());
	}

	@Test
	public void testCostruisciComandoFine() {
		Comando c = fabricaDiComandi.costruisciComando("fine", this.ioConsole);
		Comando c1 = new ComandoFine();
		assertEquals(c1.getClass(), c.getClass());
	}
	
	@Test
	public void testCostruisciComandoGuarda() {
		Comando c = fabricaDiComandi.costruisciComando("guarda", this.ioConsole);
		Comando c1 = new ComandoGuarda();
		assertEquals(c1.getClass(), c.getClass());
	}

	@Test
	public void testCostruisciComandoNonValido() {
		Comando c = fabricaDiComandi.costruisciComando("comando nonvalido", this.ioConsole);
		Comando c1 = new ComandoNonValido();
		assertEquals(c1.getClass(), c.getClass());
	}

	@Test
	public void testCostruisciComandoPosa() {
		Comando c = fabricaDiComandi.costruisciComando("posa osso", this.ioConsole);
		Comando c1 = new ComandoPosa();
		assertEquals(c1.getClass(), c.getClass());
	}

	@Test
	public void testCostruisciComandoPrendi() {
		Comando c = fabricaDiComandi.costruisciComando("prendi osso", this.ioConsole);
		Comando c1 = new ComandoPrendi();
		assertEquals(c1.getClass(), c.getClass());
	}

	@Test
	public void testCostrisciComandoVai() {
		Comando c = fabricaDiComandi.costruisciComando("vai nord", this.ioConsole);
		Comando c1 = new ComandoVai();
		assertEquals(c1.getClass(), c.getClass());
	}

	@Test
	public void testCostrisciComandoSaluta() {
		Comando c = fabricaDiComandi.costruisciComando("saluta", this.ioConsole);
		Comando c1 = new ComandoSaluta();
		assertEquals(c1.getClass(), c.getClass());
	}

	@Test
	public void testCostrisciComandoInteragisci() {
		Comando c = fabricaDiComandi.costruisciComando("interagisci", this.ioConsole);
		Comando c1 = new ComandoInteragisci();
		assertEquals(c1.getClass(), c.getClass());
	}
}
