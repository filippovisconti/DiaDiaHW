package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia s;
	String mess = "Qui c'è un buio pesto.";
	
	@Before
	public void setUp() throws Exception {
		s = new StanzaBuia("camera oscura", "luce");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		assertFalse(s.hasAttrezzo("luce"));
		assertTrue("Non dovrebbe essere illuminata", s.getDescrizione().contains(mess));
	}
	
	@Test
	public void testGetDescrizioneConAttrezzo() {
		s.addAttrezzo(new Attrezzo("luce", 1));
		assertTrue(s.hasAttrezzo("luce"));
		assertFalse("Dovrebbe essere illuminata", s.getDescrizione().contains(mess));
	}

}
