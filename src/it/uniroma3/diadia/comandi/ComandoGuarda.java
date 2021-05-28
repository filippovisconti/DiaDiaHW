package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	
	public ComandoGuarda() {
		
	}

	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";

	@Override
	public void esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		s.append("\n-Ti trovi nella stanza\n  " + ANSI_YELLOW + partita.getStanzaCorrente().getDescrizione() + ANSI_RESET);
		this.getIO().mostraMessaggio(s.toString());

	}

}
