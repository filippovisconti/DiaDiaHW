package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	/*
	 * il giocatore può regalare un attrezzo al personaggio presente nella stanza
	 * 
	 * in una stanza può trovarsi un solo personaggio: affinché un attrezzo 
	 * possa essere regalato il parametro del comando regala 
	 * deve essere il nome di uno degli attrezzi presenti nella borsa
	 * 
	 */

	public ComandoRegala() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void esegui(Partita partita) {
		if (partita == null) return;
		
		if (partita.getStanzaCorrente().hasPersonaggio()) {
			if (partita.getGiocatore().getBorsa().hasAttrezzo(this.getPararametro())) {
				Attrezzo a = partita.getGiocatore().getBorsa().removeAttrezzo(getPararametro());

				this.getIO().mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(a, partita));
			} else {
				this.getIO().mostraMessaggio("Non hai " + this.getPararametro() + "nella borsa.");
			}

		} else {
			this.getIO().mostraMessaggio("Nella stanza non c'è nessun personaggio a cui regalare " + this.getPararametro());
		}
	}
}
