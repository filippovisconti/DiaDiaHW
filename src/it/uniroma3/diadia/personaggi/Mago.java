package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {

	private static final String MESSAGGIO_DONO = 
			"Sei un vero simpaticone, " + "con una mia magica azione, troverai un nuovo oggetto " +
					"per il tuo borsone!";

	private static final String MESSAGGIO_SCUSE = 
			"Mi spiace, ma non ho piu' nulla...";

	private Attrezzo attrezzo;

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo); this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		} else {
			msg = MESSAGGIO_SCUSE; }
		return msg; }

	@Override
	/*
	 * un mago riceve un regalo, gli dimezza il peso e lo lascia cadere nella stanza
	 */
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo == null|| partita == null) return "Non trovo l'attrezzo o la partita";

		Attrezzo dimezzato = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2); 

		if (partita.getStanzaCorrente() == null) return "Non trovo la stanza corrente";

		if (partita.getStanzaCorrente().addAttrezzo(dimezzato)) {
			return ">Mago: Grazie del regalo, gli ho dimezzato il peso e l'ho aggiunto nella stanza";

		} else 	return ">Mago: non sono riuscito ad accettare il regalo e aggiungerlo alla stanza";
	}
}
