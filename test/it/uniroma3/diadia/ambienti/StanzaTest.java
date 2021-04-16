/**
 * 
 */
package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * @author filippovisconti allegrastrippoli
 *
 */
public class StanzaTest {

	String[] direzione = {"nord", "sud", "est", "ovest"};
	
	Stanza test = new Stanza("Test");
	Stanza atrio = new Stanza("atrio");
	Stanza mensa = new Stanza("mensa");

	Stanza s1 = new Stanza("n18");
	Stanza s2 = new Stanza("n11");
	Stanza s3 = new Stanza("reattore nucleare");
	
	Attrezzo[] attrezzi = {
			new Attrezzo("osso", 1), new Attrezzo("mazza", 4), 
			new Attrezzo("cane", 10), new Attrezzo("vaso", 15),
			new Attrezzo("falce", 8), new Attrezzo("pala", 6), 
			new Attrezzo("calcolatrice", 11), new Attrezzo("pianoforte", 100),
			new Attrezzo("astronave", 99999), new Attrezzo("elon", 90),
			new Attrezzo("model3", 2500), new Attrezzo("codicePenale", 2)
			};
	
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	/**
	 * 
	 */
	@Before
	public void setUp() {
		if(test.getNumeroAttrezzi() != 0) {
			test.setNumeroAttrezzi(0);
			Attrezzo[] temp = test.getAttrezzi();
			for(int i = 0; i < temp.length; i++) {
				temp[i] = null;
			}
		}
	}

	/**
	 * 
	 */
	@After
	public void tearDown() {
		for(int i = 0; i < direzione.length; i++) {
			test.impostaStanzaAdiacente(direzione[i], null);
		}
	}

	/**
	 * 
	 */
	
	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("nord", s2);
		assertEquals(s2, s1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteATutteLeDirezioni() {
		
		for(int i = 0; i < direzione.length; i++) {	
			test.impostaStanzaAdiacente(direzione[i], mensa);
			assertEquals(mensa, test.getStanzaAdiacente(direzione[i]));
		}		
	}

	@Test
	public void testImpostaStanzaAdiacenteStanzaNull() {
		s1.impostaStanzaAdiacente("nord", null);
		assertNull(s1.getStanzaAdiacente("nord"));
	}
	@Test
	public void testImpostaStanzaAdiacenteNull() {
		s1.impostaStanzaAdiacente(null, s2);
		assertNull(s1.getStanzaAdiacente("nord"));
	}

	@Test
	public void testImpostaStanzaAdiacenteAggiornato() {
		s1.impostaStanzaAdiacente("nord", s2);
		s1.impostaStanzaAdiacente("nord", s3);
		assertEquals(s3, s1.getStanzaAdiacente("nord"));
	}

	@Test
	public void testImpostaStanzaAdiacenteNonReciproco() {
		s1.impostaStanzaAdiacente("nord", s2);
		assertNull(s2.getStanzaAdiacente("sud"));
	}
	
	
	/**
	 * 
	 */
	@Test
	public void testAddAttrezzoAggiungoNull() {
		assertFalse(test.addAttrezzo(null));
	}
	

	@Test
	public void testAddAttrezzoStandard() {
		test.addAttrezzo(attrezzi[0]);
		assertEquals(attrezzi[0], test.getAttrezzo(attrezzi[0].getNome()));
	}	
	
	@Test
	public void testAddAttrezzoOverflow() {
		for(int i = 0; i < attrezzi.length; i++) {
			
			if(i > (NUMERO_MASSIMO_ATTREZZI -1)) 
				assertFalse(test.addAttrezzo(attrezzi[i]));
			
			else 
				test.addAttrezzo(attrezzi[i]);
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void testRemoveAttrezzoStandard() {
		for(int i = 0; i < attrezzi.length; i++) {
			test.addAttrezzo(attrezzi[i]);
		}
		for(int i = 0; i < attrezzi.length; i++) {
			test.removeAttrezzo(attrezzi[i].getNome());
			
			assertNull(test.getAttrezzo(attrezzi[i].getNome()));
		}
	}
	
	@Test
	public void testRemoveAttrezzoRimuoviNull() {
		assertNull(test.removeAttrezzo(null));
	}

	@Test
	public void testRemoveAttrezzoRimuoviAttrezzoNonPresente() {
		assertNull(test.removeAttrezzo("rullino foto"));
	}

}
