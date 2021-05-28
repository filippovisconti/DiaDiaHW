package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

	private Attrezzo attrezzoStrega;

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		this.setAttrezzoStrega(null);
	}

	@Override
	public String agisci(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo == null|| partita == null) return "Non trovo l'attrezzo o la partita";
		this.setAttrezzoStrega(attrezzo);
		return ">Strega: AHAHAHAHAH!";
	}

	public Attrezzo getAttrezzoStrega() {
		return attrezzoStrega;
	}

	public void setAttrezzoStrega(Attrezzo attrezzoStrega) {
		this.attrezzoStrega = attrezzoStrega;
	} 
}


