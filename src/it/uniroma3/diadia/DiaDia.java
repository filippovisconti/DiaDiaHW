package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version 1.0
 */

public class DiaDia {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando \u001B[32m 'aiuto'\u001B[0m. ";

//	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "elimina", "aggiungi"};

	private Partita partita;
//	private Borsa borsa;
	private IOConsole io;

	public IOConsole getIo() {
		return io;
	}

	public void setIo(IOConsole io) {
		this.io = io;
	}

	public DiaDia() {
		this.partita = new Partita();
//		this.borsa = new Borsa();
//		this.io = new IOConsole();
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO + ANSI_RED + "$ " + ANSI_RESET);

		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));

		
		
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta())
			this.io.mostraMessaggio("Hai vinto!");
		
		if (!this.partita.giocatoreIsVivo())
			this.io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();

	}   



	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.setIo(new IOConsole());
		gioco.gioca();
	}
}