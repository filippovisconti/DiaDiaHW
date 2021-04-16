/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * @author filippovisconti allegrastrippoli
 *
 */

/**
 * ha la responsabilità di creare il labirinto, di memorizzare la stanza iniziale (entrata) e quella finale (uscita)
 */
public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1); 
		Attrezzo mazza = new Attrezzo("mazza",4); 
		Attrezzo cane = new Attrezzo("cane",8); 
		Attrezzo pianoforte = new Attrezzo("pianoforte",400); 
		Attrezzo razzo = new Attrezzo("razzo", 2000);
		Attrezzo tavolo = new Attrezzo("tavolo", 30); 
		Attrezzo sedia = new Attrezzo("sedia", 15); 
		
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN18 = new Stanza("Aula N18");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza mensa = new Stanza("Mensa");
		Stanza aulaMagna = new Stanza("Aula Magna");
		Stanza segreteria = new Stanza("Segreteria");
//		Stanza ufficiProf = new Stanza("Uffici dei professori");
		
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", aulaMagna);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", segreteria);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		
		aulaN11.impostaStanzaAdiacente("sud", aulaN10);
		aulaN11.impostaStanzaAdiacente("nord", aulaN18);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		
		aulaN10.impostaStanzaAdiacente("nord", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", segreteria);
	
		aulaN18.impostaStanzaAdiacente("sud", aulaN11);
		aulaN18.impostaStanzaAdiacente("ovest", aulaMagna);
		
		laboratorio.impostaStanzaAdiacente("nord", biblioteca);
		laboratorio.impostaStanzaAdiacente("sud", mensa);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		
		biblioteca.impostaStanzaAdiacente("sud", laboratorio);
		biblioteca.impostaStanzaAdiacente("est", aulaMagna);
		
		mensa.impostaStanzaAdiacente("nord", laboratorio);
		mensa.impostaStanzaAdiacente("est", segreteria);
		
		segreteria.impostaStanzaAdiacente("nord", atrio);
		segreteria.impostaStanzaAdiacente("est", aulaN10);
		segreteria.impostaStanzaAdiacente("ovest", mensa);
		
		
		aulaMagna.impostaStanzaAdiacente("sud", atrio);
		aulaMagna.impostaStanzaAdiacente("est", aulaN18);
		aulaMagna.impostaStanzaAdiacente("ovest", biblioteca);
		

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		mensa.addAttrezzo(tavolo);
		mensa.addAttrezzo(sedia);
		aulaMagna.addAttrezzo(pianoforte);
		segreteria.addAttrezzo(razzo);
		laboratorio.addAttrezzo(cane);
		aulaN18.addAttrezzo(mazza);

		// il gioco comincia nell'atrio
        setStanzaCorrente(atrio);  
		setStanzaVincente(biblioteca);
		
    }
	
	public Labirinto(String nomeLabirinto) {
		this.creaStanze();
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
	
}
