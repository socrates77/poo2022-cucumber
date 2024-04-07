package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	@Test
	public void testComportamentoMagico() {
		Stanza stanza = new StanzaMagica("Stanza Magica", 0);
		Attrezzo attrezzo;
		String invertedName = new StringBuilder("Nome Attrezzo 3").reverse().toString(); 
		assertTrue(stanza.addAttrezzo(new Attrezzo("Nome Attrezzo 1", 1)));
		assertTrue(stanza.addAttrezzo(new Attrezzo("Nome Attrezzo 2", 1)));
		assertTrue(stanza.addAttrezzo(new Attrezzo("Nome Attrezzo 3", 1)));
		assertTrue(stanza.addAttrezzo(new Attrezzo("Nome Attrezzo 4", 1)));
		attrezzo = stanza.getAttrezzo(invertedName);
		assertEquals(invertedName, attrezzo.getNome());
		assertEquals(2, attrezzo.getPeso());
	}
	
	@Test
	public void testComportamentoMagicoRaddoppioPeso() {
		Stanza stanza = new StanzaMagica("Stanza Magica", 0);
		Attrezzo attrezzo;
		String nome = "Nome Attrezzo 1";
		String invertedName = new StringBuilder(nome).reverse().toString(); 

		assertTrue(stanza.addAttrezzo(new Attrezzo(nome, 1)));
		attrezzo = stanza.getAttrezzo(nome);
		assertNotNull(attrezzo);
		assertTrue(stanza.removeAttrezzo(attrezzo));
		assertEquals(attrezzo.getNome(), nome);
		assertEquals(1, attrezzo.getPeso());
		
		assertTrue(stanza.addAttrezzo(attrezzo));
		attrezzo = stanza.getAttrezzo(nome);
		assertNull(attrezzo);
		attrezzo = stanza.getAttrezzo(invertedName);
		assertEquals(invertedName, attrezzo.getNome());
		assertEquals(2, attrezzo.getPeso());
		assertTrue(stanza.removeAttrezzo(attrezzo));
		
		assertTrue(stanza.addAttrezzo(attrezzo));
		attrezzo = stanza.getAttrezzo(invertedName);
		assertNull(attrezzo);
		attrezzo = stanza.getAttrezzo(nome);
		assertEquals(nome, attrezzo.getNome());
		assertEquals(4, attrezzo.getPeso());
		assertTrue(stanza.removeAttrezzo(attrezzo));
	}
}
