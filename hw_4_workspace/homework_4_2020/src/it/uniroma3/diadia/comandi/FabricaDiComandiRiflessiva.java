/**
 * 
 */
package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

/**
 * @author Alessandro Manias
 *
 */
public class FabricaDiComandiRiflessiva implements FabricaDiComandi {

	@Override
	public Comando costruisciComando(String istruzione, IO ioConsole) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		
		try {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
			nomeClasse.append(nomeComando.substring(1));
			@SuppressWarnings("unchecked")
			Class<Comando> classComando = (Class<Comando>) Class.forName(nomeClasse.toString());
			comando = classComando.newInstance();
			
			if ( parametro != null )
				comando.setParametro(parametro);
		} catch(Exception e) {
			comando = new ComandoNonValido();
		} finally {
			comando.setIO(ioConsole);
			scannerDiParole.close();	
		}

		return comando;
	}
}
