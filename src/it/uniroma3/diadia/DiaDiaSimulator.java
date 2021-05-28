package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class DiaDiaSimulator  {

	private Partita partita;
	private IOSimulator io;
	


	private String labirintoScelto;
	private IOConsole output;
	
	public IOSimulator getIo() {
		return io;
	}


	public void setIo(IOSimulator io) {
		this.io = io;
	}

	public DiaDiaSimulator(IOSimulator io, String labirinto) {
		this.io = io;
		this.labirintoScelto = labirinto;
		LabirintoBuilder l= new LabirintoBuilder(labirintoScelto);
		this.setPartita(new Partita(l.getLabirinto()));
		this.output = new IOConsole();
	}


	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio("$");
		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));	
		
		for (String s: this.io.getStringheStampate().values()) {
			this.output.mostraMessaggio(s);
		}
		
	}   
	
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		AbstractComando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		
		try {
			comandoDaEseguire = factory.costruisciComando(istruzione);
		} catch (Exception e) {
			comandoDaEseguire = new ComandoNonValido();
			e.printStackTrace();
		}
		
		comandoDaEseguire.esegui(this.getPartita());
		
		if (this.getPartita().vinta())
			this.io.mostraMessaggio("Hai vinto!");
		
		if (!this.getPartita().giocatoreIsVivo())
			this.io.mostraMessaggio("Hai esaurito i CFU");
		return this.getPartita().isFinita();
	}  
	
	public Partita getPartita() {
		return partita;
	}

	public void setPartita(Partita partita) {
		this.partita = partita;
	}


//	public static void main(String[] argc) {
//		String labirinto ="Università";
//		DiaDiaSimulator gioco = new DiaDiaSimulator(new IOSimulator(), labirinto);
//		gioco.gioca();
//	}

	
}
