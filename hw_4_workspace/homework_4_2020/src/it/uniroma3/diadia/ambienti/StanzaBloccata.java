/**
 * 
 */
package it.uniroma3.diadia.ambienti;

/**
 * @author Alessandro Manias
 *
 */
public class StanzaBloccata extends Stanza {
	/**
	 * Direzione bloccata in assenza di un attrezzo con nome
	 * attrezzo.
	 * 
	 */
	private Direzione direzioneBloccata;
	
	private String nomeAttrezzo;
	
	public StanzaBloccata(String nome) {
		super(nome);
	}

	public StanzaBloccata(String nome, Direzione direzione, String nomeAttrezzo) {
		this(nome);
		this.direzioneBloccata = direzione;
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if (this.isBloccata(direzione)) {
			return this;
		}
		
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String toString() {
		StringBuilder descrizioneGenitore = new StringBuilder(super.toString());
		StringBuilder descrizione = new StringBuilder();
		if (this.isBloccata(this.direzioneBloccata)) {
			descrizione.append("L'uscita ");
			descrizione.append(this.direzioneBloccata);
			descrizione.append(" è bloccata");
			descrizione.append("\n");
		}
		
		descrizioneGenitore.append(descrizione);
		return descrizioneGenitore.toString();
	}

	private boolean isBloccata(Direzione direzione) {
		if (direzione.equals(this.direzioneBloccata) && 
				!this.hasAttrezzo(this.nomeAttrezzo)) {
			return true;
		}
		
		return false;
	}
}
