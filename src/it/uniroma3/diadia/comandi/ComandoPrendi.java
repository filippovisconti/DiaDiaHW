package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	
	public ComandoPrendi() {
		// TODO Auto-generated constructor stub
	}

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	@Override
	public void esegui(Partita partita) {
	
		if (this.getPararametro() != null)
			this.raccogli(this.getPararametro(), partita);
		else {
			this.getIO().mostraMessaggio(ANSI_RED + "PRENDI ha bisogno di un parametro." + ANSI_RESET);
			this.getIO().mostraMessaggio(ANSI_GREEN + "\t raccogli nomeOggetto" + ANSI_RESET);
		}

	}

	private void raccogli(String obj, Partita partita) {
		Attrezzo a = partita.getStanzaCorrente().removeAttrezzo(obj);
		if (a == null) {
			this.getIO().mostraMessaggio(ANSI_RED + obj + " non è presente nella stanza." + ANSI_RESET);
		} else {
			
			if(partita.getGiocatore().getBorsa().addAttrezzo(a))
				this.getIO().mostraMessaggio(ANSI_GREEN + "Hai raccolto "+ obj + ANSI_RESET);
			else
				this.getIO().mostraMessaggio(ANSI_RED + "Non raccolto "+ obj + ANSI_RESET);
		}
	} 


}
