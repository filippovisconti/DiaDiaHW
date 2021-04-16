package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	private IOConsole io;

	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIO(IOConsole console) {
		this.io = console;

	}

}
