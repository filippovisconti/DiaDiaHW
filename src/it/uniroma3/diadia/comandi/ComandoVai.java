package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	private String direzione; 
	private IOConsole io;

	public ComandoVai() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void esegui(Partita partita) {
		String next = direzione;

		if(direzione==null) {
			this.io.mostraMessaggio("Dove vuoi andare?");

		} 		
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(next); // originale direzione, non next

		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			partita.getGiocatore().decrementaCfu();
			this.io.mostraMessaggio("Hai ancora " +  partita.getGiocatore().getCfu() + " cfu rimanenti.");
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;

	}

	@Override
	public void setIO(IOConsole console) {
		this.io = console;
		
	}

}