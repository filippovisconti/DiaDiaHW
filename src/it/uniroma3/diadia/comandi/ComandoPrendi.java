package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IOConsole io;
	private String par;

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	@Override
	public void esegui(Partita partita) {
	
		if (par != null)
			this.raccogli(par, partita);
		else {
			this.io.mostraMessaggio(ANSI_RED + "PRENDI ha bisogno di un parametro." + ANSI_RESET);
			this.io.mostraMessaggio(ANSI_GREEN + "\t raccogli nomeOggetto" + ANSI_RESET);
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.par = parametro;

	}

	@Override
	public void setIO(IOConsole console) {
		this.io = console;
		
	}
	
	private void raccogli(String obj, Partita partita) {
		Attrezzo a = partita.getStanzaCorrente().removeAttrezzo(obj);
		if (a == null) {
			this.io.mostraMessaggio(ANSI_RED + obj + " non è presente nella stanza." + ANSI_RESET);
		} else {
			
			if(partita.getGiocatore().getBorsa().addAttrezzo(a))
				this.io.mostraMessaggio(ANSI_GREEN + "Hai raccolto "+ obj + ANSI_RESET);
			else
				this.io.mostraMessaggio(ANSI_RED + "Non raccolto "+ obj + ANSI_RESET);
		}
	} 


}
