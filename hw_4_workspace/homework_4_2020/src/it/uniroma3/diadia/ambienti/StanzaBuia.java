/**
 * 
 */
package it.uniroma3.diadia.ambienti;

/**
 * @author Alessandro Manias
 *
 */
public class StanzaBuia extends Stanza {

	private String nomeAttrezzo;
	
	public StanzaBuia(String nome) {
		super(nome);
	}
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		this(nome);
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(this.nomeAttrezzo)) {
			return super.getDescrizione();
		}
		return "Qui c'è buio pesto";
	}

}
