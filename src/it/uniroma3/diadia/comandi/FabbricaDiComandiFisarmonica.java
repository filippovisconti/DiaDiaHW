package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

	String nomeComando = null;
	String parametro = null;
	
	public FabbricaDiComandiFisarmonica() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractComando costruisciComando(String istruzione) {
		
		if(istruzione == null) {
			AbstractComando comando = new ComandoNonValido(); 
			comando.setIO(new IOConsole());
			return comando;
		}
		@SuppressWarnings("resource")
		Scanner scannerDiParole = new Scanner(istruzione);
		nomeComando = null;
		parametro = null;
		AbstractComando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();// prima parola: nome del comando
		
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();  // seconda parola: eventuale param.
			
		if (nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai")) comando = new ComandoVai();
		
		else if (nomeComando.equals("prendi")) comando = new ComandoPrendi();
		
		else if (nomeComando.equals("posa")) comando = new ComandoPosa();
		
		else if (nomeComando.equals("aiuto")) comando = new ComandoAiuto();

		else if (nomeComando.equals("fine")) comando = new ComandoFine();

		else if (nomeComando.equals("guarda")) comando = new ComandoGuarda();

		else comando = new ComandoNonValido(); 
		comando.setIO(new IOConsole());
		comando.setParametro(parametro);
		
		return comando;
	}

	@Override
	public String getNome() {
		return this.nomeComando;
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}

}
