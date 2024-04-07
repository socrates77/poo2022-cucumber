/**
 * 
 */
package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alessandro Manias
 *
 */
public class CaricatoreLabirintoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link it.uniroma3.diadia.CaricatoreLabirinto#carica()}.
	 */
	@Test
	public void testCaricaDueStanzeVuote() throws FormatoFileNonValidoException, FileNotFoundException {
		CaricatoreLabirinto cl = new CaricatoreLabirinto("./resources/tests/due_stanze_vuote.txt");
		cl.carica();
		assertEquals("INIZIALE", cl.getStanzaIniziale().getNome());
		assertEquals("FINALE", cl.getStanzaVincente().getNome());

	}


	/**
	 * Test method for {@link it.uniroma3.diadia.CaricatoreLabirinto#carica()}.
	 */
	@Test
	public void testCaricaDueStanzeVuote() throws FormatoFileNonValidoException, FileNotFoundException {
		CaricatoreLabirinto cl = new CaricatoreLabirinto("./resources/tests/due_stanze_vuote.txt");
		cl.carica();
		assertEquals("INIZIALE", cl.getStanzaIniziale().getNome());
		assertEquals("FINALE", cl.getStanzaVincente().getNome());

	}
	/**
	 * Test method for {@link it.uniroma3.diadia.CaricatoreLabirinto#getStanzaIniziale()}.
	 */
	@Test (expected=FormatoFileNonValidoException.class)
	public void testCaricaFileVuoto() throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto cl = new CaricatoreLabirinto("./resources/tests/file_vuoto.txt");
		cl.carica();
	}

	/**
	 * Test method for {@link it.uniroma3.diadia.CaricatoreLabirinto#getStanzaVincente()}.
	 */
	@Test
	public void testGetStanzaVincente() {
		fail("Not yet implemented");
	}

}
