package diadia.hw_2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class StepDefinitions {

	private DiaDia diadia;
	private IOSimulator ioConsole;
	private List<String> comandi = new ArrayList<String>();


	@Given("Comando {string}")
	public void comando(String string) {
		this.comandi.add(string);
	}
	
	@When("Lancio diadia")
	public void lancio_diadia() {
		String[] a = this.comandi.toArray(new String[1]);
		this.ioConsole = new IOSimulator(a);
		this.diadia = new DiaDia(this.ioConsole);
		this.diadia.gioca();
	}

	@Then("Posso leggere {string}")
	public void posso_leggere(String string) {
		String messaggio;
		assertTrue(this.ioConsole.hasNextMessaggio());
		messaggio = this.ioConsole.nextMessaggio();
		assertTrue(messaggio, messaggio.contains(string));
	}
}
