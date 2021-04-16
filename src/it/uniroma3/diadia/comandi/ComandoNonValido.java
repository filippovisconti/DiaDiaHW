package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	private IOConsole io;

	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Comando sconosciuto");

	}

	@Override
	public void setParametro(String parametro) {
		

	}

	@Override
	public void setIO(IOConsole console) {
		this.io = console;
		
	}

}
