 package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private IO io;
	private String par;

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	@Override
	public void esegui(Partita partita) {
		if (par != null)
			this.posa(par, partita);
		else {
			this.io.mostraMessaggio(ANSI_RED + "POSA ha bisogno di un parametro." + ANSI_RESET);
			this.io.mostraMessaggio(ANSI_GREEN + "\t posa nomeOggetto" + ANSI_RESET);
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.par = parametro;

	}

	@Override
	public void setIO(IO console) {
		this.io = console;
	}
	
	private void posa(String obj, Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().removeAttrezzo(obj);

		if (a == null) {
			this.io.mostraMessaggio(ANSI_RED + "Non hai " + obj + " nella borsa." + ANSI_RESET);
		}
		else {
			
			if(partita.getStanzaCorrente().addAttrezzo(a))
				this.io.mostraMessaggio(ANSI_GREEN + "Hai posato "+ obj + ANSI_RESET);
			else
				this.io.mostraMessaggio(ANSI_RED + "Hai eliminato e non posato "+ obj + ANSI_RESET);

		}
	}

}

