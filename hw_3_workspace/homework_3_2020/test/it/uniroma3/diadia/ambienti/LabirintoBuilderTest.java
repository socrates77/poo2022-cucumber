/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * @author Alessandro Manias
 *
 */
public class LabirintoBuilderTest {

	@Test
	public void testLabirintoMonolocale() {
		Labirinto monolocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto") // aggiunge una stanza, che sarà anche iniziale
				.addStanzaVincente("salotto") // specifica quala stanza sarà vincente
				.getLabirinto();
		assertEquals(new Stanza("salotto"), monolocale.getStanzaCorrente());
		assertEquals(new Stanza("salotto"), monolocale.getStanzaVincente());
	}

	@Test
	public void testLabirintoBilocale() {
		Labirinto bilocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.addAttrezzo("letto",10) // dove? fa riferimento all’ultima stanza aggiunta
				.addAdiacenza("salotto", "camera", "nord") // camera si trova a nord di salotto
				.getLabirinto();
		assertEquals(new Stanza("salotto"), bilocale.getStanzaCorrente());
		bilocale.setStanzaCorrente(bilocale.getStanzaCorrente().getStanzaAdiacente("nord"));
		assertEquals(new Stanza("camera"), bilocale.getStanzaCorrente());
		assertEquals(new Attrezzo("letto", 10), bilocale.getStanzaCorrente().getAttrezzo("letto"));
	}

	@Test
	public void testLabirintoTrilocale() {
		Labirinto trilocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto();
		assertEquals(new Stanza("salotto"), trilocale.getStanzaCorrente());
		trilocale.setStanzaCorrente(trilocale.getStanzaCorrente().getStanzaAdiacente("nord"));
		assertEquals(new Stanza("cucina"), trilocale.getStanzaCorrente());
		trilocale.setStanzaCorrente(trilocale.getStanzaCorrente().getStanzaAdiacente("est"));
		assertEquals(new Stanza("camera"), trilocale.getStanzaCorrente());
		assertEquals(trilocale.getStanzaCorrente(), trilocale.getStanzaVincente());
	}
}
