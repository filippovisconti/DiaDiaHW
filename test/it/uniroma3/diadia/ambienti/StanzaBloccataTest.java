package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata s;
	private Stanza s2;

	@Before
	public void setUp() throws Exception {
		s = new StanzaBloccata("casa", "est", "key");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDescrizione() {
		assertTrue("Descrizione non contiene direzione bloccata", s.getDescrizione().contains("est"));	
		assertTrue("Descrizione non contiene attrezzo di sblocco", s.getDescrizione().contains("key"));	
	}
	
	@Test
	public void testGetStanzaAdiacenteSenzaAttrezzo() {
		s2 = new Stanza("adiacente");
		s.impostaStanzaAdiacente("est", s2);
		assertEquals(s, s.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testGetStanzaAdiacenteConAttrezzo() {
		s2 = new Stanza("adiacente");
		s.impostaStanzaAdiacente("est", s2);
		s.addAttrezzo(new Attrezzo("key", 1));
		assertEquals(s2, s.getStanzaAdiacente("est"));
	}
	
	
}
