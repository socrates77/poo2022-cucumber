package diadia.homework_2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOCucumber;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class StepDefinitions {

	private DiaDia diadia;
	private IOCucumber ioConsole;
	private List<String> comandi = new ArrayList<String>();
	/**
	 * Aggiunto nella versione del terzo Homework per gestire l'assenza
	 * di un labirinto predefinito.
	 * @return 
	 */
	private Labirinto createStandardLabirinto() {
		return new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 1)
				.addAttrezzo("sasso", 1)
				.addStanzaVincente("Biblioteca")
				.addStanzaBloccata("Aula N11", "ovest", "osso")
				.addStanzaBuia("Aula N10", "lanterna")
				.addAttrezzo("lanterna", 3)
				.addStanza("Laboratorio Campus")
				.addStanzaMagica("Laboratorio IA")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Atrio", "Aula N10", "sud")
				.addAdiacenza("Atrio", "Aula N11", "est")
				.addAdiacenza("Atrio", "Laboratorio Campus", "ovest")
				.addAdiacenza("Aula N11", "Laboratorio Campus", "est")
				.addAdiacenza("Aula N11", "Atrio", "ovest")
				.addAdiacenza("Aula N10", "Atrio", "nord")
				.addAdiacenza("Aula N10", "Aula N11", "est")
				.addAdiacenza("Aula N10", "Laboratorio Campus", "ovest")
				.addAdiacenza("Laboratorio Campus", "Atrio", "est")
				.addAdiacenza("Laboratorio Campus", "Aula N11", "ovest")
				.addAdiacenza("Laboratorio Campus", "Laboratorio IA", "sud")
				.addAdiacenza("Laboratorio IA", "Laboratorio Campus", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
	}

	@When("Comando {string}")
	public void comando(String string) {
		this.comandi.add(string);
	}

	@When("Ripeti {string} volte il comando {string}")
	public void ripeti_volte_il_comando(String string, String string2) {
		int passi = Integer.parseInt(string);
		for(int i=0;i<passi;i++) {
			this.comandi.add(string2);
		}
	}

	@Given("Lancio DiaDia")
	public void lancio_diadia() {
		this.ioConsole = new IOCucumber();
		this.diadia = new DiaDia(this.ioConsole);
		this.diadia.setLabirinto(this.createStandardLabirinto());
	}

	@Then("Posso leggere {string}")
	public void posso_leggere(String string) {
		String messaggio = "";
		boolean messaggioTrovato = false;
		this.ioConsole.setRigheDaLeggere(comandi);
		this.diadia.gioca();
		this.ioConsole.messaggiIterator();

		assertTrue(this.ioConsole.hasNextMessaggio());

		while (this.ioConsole.hasNextMessaggio()) {
			messaggio = this.ioConsole.nextMessaggio();
			if(messaggio.contains(string)) {
				messaggioTrovato = true;
			}
		}

		assertTrue(messaggioTrovato);
	}
}
