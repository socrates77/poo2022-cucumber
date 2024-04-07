/**
 * Rappreseta le Direzioni utilizzabili nel gioco tramite una enum.
 * 
 */
package it.uniroma3.diadia.ambienti;

/**
 * 
 * @author Alessandro Manias
 *
 */
public enum Direzione {
	NORD, OVEST, SUD, EST;
	
	public static Direzione opposta(Direzione d) {
		Direzione opposta;

		switch(d) {
			case NORD:
				opposta = SUD;
				break;
			case OVEST:
				opposta = EST;
				break;
			case SUD:
				opposta = NORD;
				break;
			case EST:
				opposta = OVEST;
				break;
			default:
				throw new IllegalArgumentException();
		}
		
		return opposta;
	}
}
