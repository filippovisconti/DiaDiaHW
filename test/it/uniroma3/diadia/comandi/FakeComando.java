package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class FakeComando extends AbstractComando {

	public FakeComando(String parametro) {
		this.setParametro(parametro);
		this.setIO(new IOConsole());
	}
	
	public FakeComando() {
		this(null);
	}

	@Override
	public void esegui(Partita partita) {
		this.getIO().mostraMessaggio("Eseguo con parametro: "+ this.getPararametro());
	}

	public String eseguiTest() {
	
		return ("Eseguo con parametro: "+ this.getPararametro());
	}
}
