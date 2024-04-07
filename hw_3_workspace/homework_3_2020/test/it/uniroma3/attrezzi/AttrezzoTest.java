/**
 * 
 */
package it.uniroma3.attrezzi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Alessandro Manias
 *
 */
public class AttrezzoTest {

	/**
	 * Test method for {@link it.uniroma3.diadia.attrezzi.Attrezzo#hashCode()}.
	 */
	@Test
	public void testHashCodeAttrezziUguali() {
		assertEquals((new Attrezzo("Clava", 1)).hashCode(), (new Attrezzo("Clava", 2)).hashCode());
	}
	/**
	 * Test method for {@link it.uniroma3.diadia.attrezzi.Attrezzo#hashCode()}.
	 */
	@Test
	public void testHashCodeAttrezziDiversi() {	
		assertNotEquals((new Attrezzo("Mazza", 1)).hashCode(), (new Attrezzo("Clava", 2)).hashCode());
	}
	/**
	 * Test method for {@link it.uniroma3.diadia.attrezzi.Attrezzo#hashCode()}.
	 */
	@Test(expected = AssertionError.class)
	public void testHashCodeWithString() {
		assertEquals("Clava", new Attrezzo("Clava", 1));
	}
	/**
	 * Test method for {@link it.uniroma3.diadia.attrezzi.Attrezzo#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsAttezziUguali() {
		assertEquals(new Attrezzo("Clavetas", 1), new Attrezzo("Clavetas", 3));
	}
	/**
	 * Test method for {@link it.uniroma3.diadia.attrezzi.Attrezzo#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsAttezziDiversi() {
		assertNotEquals(new Attrezzo("Clavetta", 1), new Attrezzo("Clavetas", 3));
	}
	/**
	 * Test method for {@link it.uniroma3.diadia.attrezzi.Attrezzo#equals(java.lang.Object)}.
	 */
	@Test
	public void testComparableCompareToUguale() {
		Attrezzo a = new Attrezzo("Clavetta", 1);
		Attrezzo b = new Attrezzo("Clavetta", 1);
		assertEquals(0, a.compareTo(b));
		assertEquals(0, b.compareTo(a));
	}
	@Test
	public void testComparableComparePrecedePerPeso() {
		Attrezzo a = new Attrezzo("Clavetta", 1);
		Attrezzo c = new Attrezzo("Clavetta", 2);
		assertTrue(a.compareTo(c) < 0);
		assertTrue(c.compareTo(a) > 0);
	}
	@Test
	public void testComparableComparePrecedePerNome() {
		Attrezzo a = new Attrezzo("Claveta", 1);
		Attrezzo c = new Attrezzo("Clavetta", 1);
		assertTrue(a.compareTo(c) < 0);
		assertTrue(c.compareTo(a) > 0);
	}
}
