package diadia.homework_2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOCucumber;
import it.uniroma3.diadia.IOSimulator;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class StepDefinitions {

	private DiaDia diadia;
	private IOCucumber ioConsole;
	private List<String> comandi = new ArrayList<String>();

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
