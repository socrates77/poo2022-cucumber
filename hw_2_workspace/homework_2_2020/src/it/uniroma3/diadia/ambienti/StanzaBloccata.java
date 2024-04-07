/**
 * 
 */
package it.uniroma3.diadia.ambienti;

/**
 * @author Alessandro Manias
 *
 */
public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	
	private String nomeAttrezzo;
	
	public StanzaBloccata(String nome) {
		super(nome);
	}

	public StanzaBloccata(String nome, String direzione, String nomeAttrezzo) {
		this(nome);
		this.direzioneBloccata = direzione;
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (this.isBloccata(direzione)) {
			return this;
		}
		
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String toString() {
		StringBuilder descrizione = new StringBuilder();
		if (this.isBloccata(this.direzioneBloccata)) {
			descrizione.append("L'uscita ");
			descrizione.append(this.direzioneBloccata);
			descrizione.append(" è bloccata");
			descrizione.append("\n");
		}
		
		descrizione.append(super.toString());
		return descrizione.toString();
	}

	private boolean isBloccata(String direzione) {
		if (direzione.equals(this.direzioneBloccata) && 
				!this.hasAttrezzo(this.nomeAttrezzo)) {
			return true;
		}
		
		return false;
	}
}
