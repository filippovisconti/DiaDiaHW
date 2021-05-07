package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String attrezzoPerIlluminare = null;

	public String getAttrezzoPerIlluminare() {
		return attrezzoPerIlluminare;
	}

	public void setAttrezzoPerIlluminare(String a) {
		this.attrezzoPerIlluminare = a;
	}

	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoPerIlluminare = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(attrezzoPerIlluminare))
			return this.toString();
		String s = "Qui c'è un buio pesto.";
		return s;
    }


}
