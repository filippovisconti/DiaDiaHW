package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	private Partita p = new Partita();
	private ComandoPrendi c;
	private Attrezzo a1 = new Attrezzo("a1", 5);
	
	@Before
	public void setUp() {
		this.c = new ComandoPrendi();
		this.c.setIO(new IOConsole());
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEseguiRaccogliNull() {
		int n = this.p.getGiocatore().getBorsa().getDimensione();
		this.c.setParametro(null);
		this.c.esegui(p);
		assertEquals(n, this.p.getGiocatore().getBorsa().getDimensione());
	}
	
	@Test
	public void testEseguiRaccogliA1() {
		this.c.setParametro(a1.getNome());
		this.p.getStanzaCorrente().addAttrezzo(a1);
		assertTrue(this.p.getStanzaCorrente().hasAttrezzo(a1.getNome()));
		this.c.esegui(p);
		assertFalse(this.p.getStanzaCorrente().hasAttrezzo(a1.getNome()));
		assertTrue(this.p.getGiocatore().getBorsa().hasAttrezzo(a1.getNome()));
		
		
	}
}
