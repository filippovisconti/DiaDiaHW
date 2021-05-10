package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	Map<String, Attrezzo> dbAttrezzi;

	Map<String, Stanza> dbStanze;
	
//	/* crea gli attrezzi */
//	Attrezzo lanterna, osso, mazza, cane, pianoforte, razzo, tavolo, sedia, chiave,lampada;
////    Attrezzo vaso = new Attrezzo("vaso", 2);
////    Attrezzo falce = new Attrezzo("falce", 5);
////    Attrezzo pala = new Attrezzo("pala", 2); 
////    Attrezzo calcolatrice = new Attrezzo("calcolatrice", 11);
//	
//	/* crea stanze del labirinto */
//	Stanza atrio, aulaN18, aulaN11, aulaN10, laboratorio, biblioteca, mensa, aulaMagna, segreteria, ufficiProf;


	public LabirintoBuilder() {
		
		/* crea gli attrezzi */
//	    Attrezzo vaso = new Attrezzo("vaso", 2);
//	    Attrezzo falce = new Attrezzo("falce", 5);
//	    Attrezzo pala = new Attrezzo("pala", 2); 
//	    Attrezzo calcolatrice = new Attrezzo("calcolatrice", 11);
		dbAttrezzi = new HashMap<>();
		dbAttrezzi.put("lanterna", new Attrezzo("lanterna",3));
		dbAttrezzi.put("osso", new Attrezzo("osso",1));
		dbAttrezzi.put("mazza", new Attrezzo("mazza",4));
		dbAttrezzi.put("cane", new Attrezzo("cane",5));
		dbAttrezzi.put("pianoforte", new Attrezzo("pianoforte",4));
		dbAttrezzi.put("razzo", new Attrezzo("razzo", 10));
		dbAttrezzi.put("tavolo", new Attrezzo("tavolo", 9));
		dbAttrezzi.put("sedia", new Attrezzo("sedia", 5));
		dbAttrezzi.put("chiave", new Attrezzo("chiave", 8));
		dbAttrezzi.put("lampada", new Attrezzo("lampada", 8));
		
		/* crea stanze del labirinto */
		dbStanze = new HashMap<>();
		dbStanze.put("atrio", new Stanza("Atrio"));
		dbStanze.put("aulaN18", new Stanza("Aula N18"));
		dbStanze.put("aulaN11", new Stanza("Aula N11"));
		dbStanze.put("aulaN10", new Stanza("Aula N10"));
		dbStanze.put("laboratorio", new Stanza("Laboratorio Campus"));
		dbStanze.put("biblioteca", new Stanza("Biblioteca"));
		dbStanze.put("mensa", new Stanza("Mensa"));
		dbStanze.put("aulaMagna",new StanzaBuia("Aula Magna",dbAttrezzi.get("lanterna").getNome()));
		dbStanze.put("segreteria", new Stanza("Segreteria"));
		dbStanze.put("ufficiProf", new StanzaBloccata("Uffici dei professori", dbAttrezzi.get("chiave").getNome(), "est"));
		
	}

	public Labirinto creaUniversità() {
		Labirinto l = new Labirinto("Università");

		/* collega le stanze */
		dbStanze.get("atrio").impostaStanzaAdiacente("nord", dbStanze.get("aulaMagna"));
		dbStanze.get("atrio").impostaStanzaAdiacente("est", dbStanze.get("aulaN11"));
		dbStanze.get("atrio").impostaStanzaAdiacente("sud", dbStanze.get("segreteria"));
		dbStanze.get("atrio").impostaStanzaAdiacente("ovest", dbStanze.get("laboratorio"));

		dbStanze.get("aulaN11").impostaStanzaAdiacente("sud", dbStanze.get("aulaN10"));
		dbStanze.get("aulaN11").impostaStanzaAdiacente("nord", dbStanze.get("aulaN18"));
		dbStanze.get("aulaN11").impostaStanzaAdiacente("ovest", dbStanze.get("atrio"));

		dbStanze.get("aulaN10").impostaStanzaAdiacente("nord", dbStanze.get("aulaN11"));
		dbStanze.get("aulaN10").impostaStanzaAdiacente("ovest", dbStanze.get("segreteria"));

		dbStanze.get("aulaN18").impostaStanzaAdiacente("sud", dbStanze.get("aulaN11"));
		dbStanze.get("aulaN18").impostaStanzaAdiacente("ovest", dbStanze.get("aulaMagna"));

		dbStanze.get("laboratorio").impostaStanzaAdiacente("nord", dbStanze.get("biblioteca"));
		dbStanze.get("laboratorio").impostaStanzaAdiacente("sud", dbStanze.get("mensa"));
		dbStanze.get("laboratorio").impostaStanzaAdiacente("est", dbStanze.get("atrio"));

		dbStanze.get("biblioteca").impostaStanzaAdiacente("sud", dbStanze.get("laboratorio"));
		dbStanze.get("biblioteca").impostaStanzaAdiacente("est", dbStanze.get("aulaMagna"));

		dbStanze.get("mensa").impostaStanzaAdiacente("nord", dbStanze.get("laboratorio"));
		dbStanze.get("mensa").impostaStanzaAdiacente("est", dbStanze.get("segreteria"));

		dbStanze.get("segreteria").impostaStanzaAdiacente("nord", dbStanze.get("atrio"));
		dbStanze.get("segreteria").impostaStanzaAdiacente("est", dbStanze.get("aulaN10"));
		dbStanze.get("segreteria").impostaStanzaAdiacente("ovest", dbStanze.get("mensa"));
		dbStanze.get("segreteria").impostaStanzaAdiacente("sud", dbStanze.get("ufficiProf"));

		dbStanze.get("ufficiProf").impostaStanzaAdiacente("nord", dbStanze.get("segreteria"));


		dbStanze.get("aulaMagna").impostaStanzaAdiacente("sud", dbStanze.get("atrio"));
		dbStanze.get("aulaMagna").impostaStanzaAdiacente("est", dbStanze.get("aulaN18"));
		dbStanze.get("aulaMagna").impostaStanzaAdiacente("ovest", dbStanze.get("biblioteca"));


		/* pone gli attrezzi nelle stanze */
		dbStanze.get("aulaN10").addAttrezzo(dbAttrezzi.get("lampada"));
		dbStanze.get("atrio").addAttrezzo(dbAttrezzi.get("osso"));
		dbStanze.get("atrio").addAttrezzo(dbAttrezzi.get("lanterna"));
		dbStanze.get("mensa").addAttrezzo(dbAttrezzi.get("tavolo"));
		dbStanze.get("mensa").addAttrezzo(dbAttrezzi.get("sedia"));
		dbStanze.get("aulaMagna").addAttrezzo(dbAttrezzi.get("pianoforte"));
		dbStanze.get("segreteria").addAttrezzo(dbAttrezzi.get("razzo"));
		dbStanze.get("laboratorio").addAttrezzo(dbAttrezzi.get("cane"));
		dbStanze.get("aulaN18").addAttrezzo(dbAttrezzi.get("chiave"));

		// il gioco comincia nell'atrio
		l.setStanzaCorrente(dbStanze.get("atrio"));  
//		Integer index = (int) Math.floor(Math.random()*(dbStanze.size()+1)); // indice tra 0 e size dbStanze;
//		Stanza random = (Stanza) new ArrayList<Stanza>(dbStanze.values()).get(index);
//		l.setStanzaVincente(random);
		l.setStanzaVincente(dbStanze.get("biblioteca"));
		return l;

	}
	public Labirinto creaLabirinto(String nome) {
		if (nome.equals("Universita")) {
			return creaUniversità();
		}
		return creaUniversità();
	}
}

