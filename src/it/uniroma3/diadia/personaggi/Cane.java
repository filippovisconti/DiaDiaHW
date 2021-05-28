package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

	private String ciboPreferito;

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
		this.ciboPreferito = "croccantini";
	}

	@Override
	public String agisci(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo == null|| partita == null) return "Non trovo l'attrezzo o la partita";


		if (partita.getStanzaCorrente() == null) return "Non trovo la stanza corrente";


		if(this.ciboPreferito.equals(attrezzo.getNome())) {

			if (partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
				return ">Cane: Grazie per il cibo, l'ho aggiunto nella stanza";

			} else {
				return ">Cane: Grazie per il cibo, ma non sono riuscito ad aggiungerlo alla stanza";
			}

		} else {

			partita.getGiocatore().decrementaCfu();
			return ">Cane: Pessima scelta, ti ho morso e tolto un CFU";
		}

	}


}
