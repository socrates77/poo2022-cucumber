/**
 * 
 */
package it.uniroma3.fixture;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

/**
 * @author Alessandro Manias
 *
 */
public class Fixture {

	public static Labirinto creaLabirinto() {
		return new LabirintoBuilder()
				.getLabirinto();
	}
	
	public static IOSimulator creaSimulazionePartitaEGioca(String...comandiDaEseguire) {
		return new IOSimulator(comandiDaEseguire);
	}
	
}
