package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

	public ComandoNonValido() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void esegui(Partita partita) {
		this.getIO().mostraMessaggio("Comando sconosciuto.");
	}


}
