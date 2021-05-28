package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	
	public ComandoVai() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void esegui(Partita partita) {
		String direzione = this.getPararametro();
		String next = direzione;

		if(direzione==null) {
			this.getIO().mostraMessaggio("Dove vuoi andare?");

		} 		
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(next); // originale direzione, non next

			if (prossimaStanza == null)
				this.getIO().mostraMessaggio("Direzione inesistente");
			else {
				partita.setStanzaCorrente(prossimaStanza);
				partita.getGiocatore().decrementaCfu();
				this.getIO().mostraMessaggio("Hai ancora " +  partita.getGiocatore().getCfu() + " cfu rimanenti.");
			}
			this.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		}
	}

}
