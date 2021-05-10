package it.uniroma3.diadia.ambienti;

/**
 * ha la responsabilità di creare il labirinto, di memorizzare la stanza iniziale (entrata) e quella finale (uscita)
 */
public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private String nomeLabirinto;
	
//	private void creaStanze() {
//
//		/* crea gli attrezzi */
//    	Attrezzo lanterna = new Attrezzo("lanterna",3);
//		Attrezzo osso = new Attrezzo("osso",1); 
//		Attrezzo mazza = new Attrezzo("mazza",4); 
//		Attrezzo cane = new Attrezzo("cane",5); 
//		Attrezzo pianoforte = new Attrezzo("pianoforte",4); 
//		Attrezzo razzo = new Attrezzo("razzo", 10);
//		Attrezzo tavolo = new Attrezzo("tavolo", 9); 
//		Attrezzo sedia = new Attrezzo("sedia", 5); 
//	    Attrezzo chiave = new Attrezzo("chiave", 8);
//	    Attrezzo lampada = new Attrezzo("lampada", 8);
//		
//    	
//		/* crea stanze del labirinto */
//		Stanza atrio = new Stanza("Atrio");
//		Stanza aulaN18 = new Stanza("Aula N18");
//		Stanza aulaN11 = new Stanza("Aula N11");
//		Stanza aulaN10 = new Stanza("Aula N10");
//		Stanza laboratorio = new Stanza("Laboratorio Campus");
//		Stanza biblioteca = new Stanza("Biblioteca");
//		Stanza mensa = new Stanza("Mensa");
//		Stanza aulaMagna = new StanzaBuia("Aula Magna", lampada.getNome());
//		Stanza segreteria = new Stanza("Segreteria");
//		Stanza ufficiProf = new StanzaBloccata("Uffici dei professori", chiave.getNome(), "est");
//		
//		
//		/* collega le stanze */
//		atrio.impostaStanzaAdiacente("nord", aulaMagna);
//		atrio.impostaStanzaAdiacente("est", aulaN11);
//		atrio.impostaStanzaAdiacente("sud", segreteria);
//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
//		
//		aulaN11.impostaStanzaAdiacente("sud", aulaN10);
//		aulaN11.impostaStanzaAdiacente("nord", aulaN18);
//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
//		
//		aulaN10.impostaStanzaAdiacente("nord", aulaN11);
//		aulaN10.impostaStanzaAdiacente("ovest", segreteria);
//	
//		aulaN18.impostaStanzaAdiacente("sud", aulaN11);
//		aulaN18.impostaStanzaAdiacente("ovest", aulaMagna);
//		
//		laboratorio.impostaStanzaAdiacente("nord", biblioteca);
//		laboratorio.impostaStanzaAdiacente("sud", mensa);
//		laboratorio.impostaStanzaAdiacente("est", atrio);
//		
//		biblioteca.impostaStanzaAdiacente("sud", laboratorio);
//		biblioteca.impostaStanzaAdiacente("est", aulaMagna);
//		
//		mensa.impostaStanzaAdiacente("nord", laboratorio);
//		mensa.impostaStanzaAdiacente("est", segreteria);
//		
//		segreteria.impostaStanzaAdiacente("nord", atrio);
//		segreteria.impostaStanzaAdiacente("est", aulaN10);
//		segreteria.impostaStanzaAdiacente("ovest", mensa);
//		segreteria.impostaStanzaAdiacente("sud", ufficiProf);
//		
//		ufficiProf.impostaStanzaAdiacente("nord", segreteria);
//		
//		
//		aulaMagna.impostaStanzaAdiacente("sud", atrio);
//		aulaMagna.impostaStanzaAdiacente("est", aulaN18);
//		aulaMagna.impostaStanzaAdiacente("ovest", biblioteca);
//		
//
//        /* pone gli attrezzi nelle stanze */
//		aulaN10.addAttrezzo(lanterna);
//		atrio.addAttrezzo(osso);
//		atrio.addAttrezzo(lampada);
//		mensa.addAttrezzo(tavolo);
//		mensa.addAttrezzo(sedia);
//		aulaMagna.addAttrezzo(pianoforte);
//		segreteria.addAttrezzo(razzo);
//		laboratorio.addAttrezzo(cane);
//		aulaN18.addAttrezzo(mazza);
//
//		// il gioco comincia nell'atrio
//        setStanzaCorrente(atrio);  
//		setStanzaVincente(biblioteca);
//		
//    }
	
	public Labirinto(String nomeLabirinto) {
		this.setNomeLabirinto(nomeLabirinto);
	}

	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public String getNomeLabirinto() {
		return nomeLabirinto;
	}

	public void setNomeLabirinto(String nomeLabirinto) {
		this.nomeLabirinto = nomeLabirinto;
	}
	
}
