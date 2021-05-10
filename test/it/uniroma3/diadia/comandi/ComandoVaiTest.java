package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza; 



public class ComandoVaiTest {

	private Partita p = new Partita();
	private ComandoVai c = new ComandoVai();
	private Stanza s1 = new Stanza("serra");
	private Stanza s2 = new Stanza("veranda");
	

	@Before
	public void setUp() {
		this.c.setIO(new IOConsole());
	}
	
	@Test
	public void testEseguiDirezioneNull() {
		Stanza s = this.p.getStanzaCorrente();
		this.c.setParametro(null);
		this.c.esegui(p);
		assertEquals(s, this.p.getStanzaCorrente());
	}

	@Test
	public void testEseguiStanzaNull() {
		this.p.getLabirinto().setStanzaCorrente(s1);
		this.s1.impostaStanzaAdiacente("est", null);
		
		this.c.setParametro("est");
		this.c.esegui(p);
		assertEquals(s1, this.p.getStanzaCorrente());
	}
	
	@Test
	public void testEsegui() {
		this.p.getLabirinto().setStanzaCorrente(s1);
		this.s1.impostaStanzaAdiacente("est", s2);
		
		this.c.setParametro("est");
		this.c.esegui(p);
		
		assertEquals(s2, this.p.getLabirinto().getStanzaCorrente());
	}
}
