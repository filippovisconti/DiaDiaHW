package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	private String direzioneBloccata = null;
	private String attrezzoDiSblocco = null;
	
	public StanzaBloccata(String nome) {
		super(nome);
		this.attrezzoDiSblocco = "chiave";
		this.direzioneBloccata = "nord";
	}

	public StanzaBloccata(String nome, String dirBlocc, String attrSblocco) {
		super(nome);
		this.direzioneBloccata = dirBlocc;
		this.attrezzoDiSblocco = attrSblocco;
	}

	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}

	public String getAttrezzoDiSblocco() {
		return attrezzoDiSblocco;
	}

	public void setAttrezzoDiSblocco(String attrezzoDiSblocco) {
		this.attrezzoDiSblocco = attrezzoDiSblocco;
	}
	
	/*
	 * se nella stanza non è presente l'attrezzo sbloccante, il metodo ritorna un riferimento alla stanza corrente
	 altrimenti ha l’usuale comportamento (ritorna la stanza corrispondente all'uscita specificata)
	 * */
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		
		if (this.hasAttrezzo(attrezzoDiSblocco)) {
			return super.getStanzaAdiacente(direzione);
		}
		return this;
	}

	@Override
	public String getDescrizione() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getDescrizione());
		risultato.append("La direzione" + ANSI_RED + direzioneBloccata + ANSI_RESET + " è bloccata.");
		risultato.append("\n Per sbloccarla, serve avere nella stanza" + ANSI_GREEN + attrezzoDiSblocco + ANSI_RESET + ".\n");
		
		return risultato.toString();
    }

	
}
