/**
 * 
 */
package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Alessandro Manias
 *
 */
public class DiaDiaTest {

	private DiaDia diadia;
	
	@Before
	public void setUp() {
		this.diadia = new DiaDia();
		this.diadia.equals(this.diadia);
	}
	
    @Test
	public void testVuotoDiSuccesso() {
    	assertTrue(true);
    }
	
}
