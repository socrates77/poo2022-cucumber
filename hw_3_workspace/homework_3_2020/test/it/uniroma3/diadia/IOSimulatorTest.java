/**
 * 
 */
package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Alessandro Manias
 *
 */
public class IOSimulatorTest {
		
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testLeggiRigaVuoto() {
		String[] comandi = { };
		IOSimulator ioSimulator = new IOSimulator(comandi);
		assertEquals(null, ioSimulator.leggiRiga());
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testLeggiUnaRigaSola() {
		String[] comandi = { "riga uno" };
		IOSimulator ioSimulator = new IOSimulator(comandi);
		assertEquals("riga uno", ioSimulator.leggiRiga());
		assertEquals(null, ioSimulator.leggiRiga());
	}
	
	@Test
	public void testMessaggiProdottiVuoti() {
		String[] comandi = { };
		IOSimulator ioSimulator = new IOSimulator(comandi);
		assertFalse(ioSimulator.hasNextMessaggio());
		assertEquals(null, ioSimulator.nextMessaggio());
	}
	
	@Test
	public void testMessaggiProdottiNonVuoto() {
		String[] comandi = { };
		IOSimulator ioSimulator = new IOSimulator(comandi);
		ioSimulator.mostraMessaggio("un messaggio");
		assertTrue(ioSimulator.hasNextMessaggio());
		assertEquals("un messaggio", ioSimulator.nextMessaggio());
		assertFalse(ioSimulator.hasNextMessaggio());
	}
}
