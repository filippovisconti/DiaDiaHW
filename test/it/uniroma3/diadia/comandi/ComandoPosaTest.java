package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	
	private Partita p = new Partita();
	private ComandoPosa c;
	private Stanza s1 = new Stanza("serra");
	private Stanza s2 = new Stanza("veranda");
	private Attrezzo a1 = new Attrezzo("spartito", 1); 

	@Before
	public void setUp() throws Exception {
		this.c = new ComandoPosa();
		this.c.setIO(new IOConsole());
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void eseguiPosaNull() {
		
		int n = this.p.getGiocatore().getBorsa().getDimensione();
		this.c.setParametro(null);
		this.c.esegui(p);
		assertEquals(n, this.p.getGiocatore().getBorsa().getDimensione());
	}
	
	@Test
	public void eseguiPosa() {
		this.p.getGiocatore().getBorsa().addAttrezzo(a1);
		this.c.setParametro(this.a1.getNome());
		this.c.esegui(p);
//		assertEquals(a1.getNome(), this.p.getLabirinto().getStanzaCorrente().getAttrezzo(a1.getNome()).getNome());
		assertTrue(this.p.getStanzaCorrente().hasAttrezzo(a1.getNome()));
	}
}
