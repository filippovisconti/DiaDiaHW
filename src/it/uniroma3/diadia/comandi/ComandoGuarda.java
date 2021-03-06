package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	private IO io;

	@Override
	public void esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		s.append("\n-Ti trovi nella stanza\n  " + ANSI_YELLOW + partita.getStanzaCorrente().getDescrizione() + ANSI_RESET);
		this.io.mostraMessaggio(s.toString());

	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public void setIO(IO console) {
		this.io = console;
	}
	public ComandoGuarda() {
		// TODO Auto-generated constructor stub
	}
}
