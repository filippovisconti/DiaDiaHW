package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	static final private String[] elencoComandi = {
			"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IO io;

	@Override
	public void esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		s.append("\n-Sono disponibili i seguenti comandi: " + ANSI_CYAN);
		s.append("\t");
		for(int i=0; i< elencoComandi.length; i++) 
			s.append(elencoComandi[i]+" ");
		s.append(ANSI_RESET + "$ ");
		this.io.mostraMessaggio(s.toString());

	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public void setIO(IO console) {
		this.io = console;
	}

}
