package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	
	public ComandoFine() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void esegui(Partita partita) {
		this.getIO().mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}


}
