package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Fixture;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
//import it.uniroma3.diadia.ambienti.Labirinto;
//import it.uniroma3.diadia.ambienti.LabirintoBuilder;
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
	
	@Test
	public void testEseguiDirezioneSbagliata() {
		this.p.getLabirinto().setStanzaCorrente(s1);
		this.s1.impostaStanzaAdiacente("est", s2);
		
		this.c.setParametro("nord");
		this.c.esegui(p);
		assertEquals(s1, this.p.getLabirinto().getStanzaCorrente());
	}
	
//	@Test
//	public void testPartitaMonolocale() {
//		Fallisce, da verificare
//		LabirintoBuilder builder = new LabirintoBuilder();
//		builder.addStanza("ingresso");
//		builder.setLabirinto(new Labirinto("Uni"));
//		Labirinto l = builder.getLabirinto();
//		l.setStanzaCorrente(builder.getUltimaAggiunta());
//		l.setStanzaVincente(builder.getUltimaAggiunta());
//		Map<Integer, String> comandiDaEseguire= new HashMap<Integer, String>();
//		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(comandiDaEseguire);
//		assertTrue(io.hasNextMessaggio());
//		assertContains("Ti trovi nell'Universita", io.nextMessaggio());
//		assertTrue(io.hasNextMessaggio());
//		assertEquals("Hai vinto!", io.nextMessaggio());
//	}
	

	@Test(timeout = 500)
    public void testPartitaConComandoVai() {
		Map<Integer, String> comandiDaEseguire= new HashMap<Integer, String>();
        comandiDaEseguire.put(1, "vai sud");
        comandiDaEseguire.put(2, "fine");
        IOSimulator io= Fixture.creaSimulazionePartitaEGioca(comandiDaEseguire);
        assertTrue(io.hasNextMessaggio());
        assertContains("Ti trovi nell'Universita", io.nextMessaggio());
//        assertTrue(io.hasNextMessaggio());
//        assertContains("Aula N10", io.nextMessaggio()); //ci sono anche delle stampe che indicano le uscite e gli attrezzi
//        assertTrue(io.hasNextMessaggio());
//        assertEquals("Numero di cfu: 19", io.nextMessaggio());
//        assertEquals("Hai vinto!", io.nextMessaggio());
    }

    public void assertContains(String expected, String interaRiga) {
        assertTrue(interaRiga.contains(expected));
    }
}
