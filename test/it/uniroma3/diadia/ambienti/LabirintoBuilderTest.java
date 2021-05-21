package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.ComandoVai;



public class LabirintoBuilderTest {

	Labirinto testLab;
	LabirintoBuilder testBuilder;
	ComandoVai c = new ComandoVai();
	Partita p;

	@Before
	public void setUp() throws Exception {
		this.c.setIO(new IOConsole());
		this.testBuilder = new LabirintoBuilder();
		this.testBuilder.creaLabirinto("Universita");
		this.testLab = null;
		this.p = new Partita(testBuilder.getLabirinto());
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreaUniversità() {
		this.testBuilder.creaUniversità();
		assertEquals("Aula Magna", testBuilder.getLabirinto().getStanzaVincente().getNome());
		assertEquals("Atrio", testBuilder.getLabirinto().getStanzaCorrente().getNome());
		this.c.setParametro("est");
		this.c.esegui(p);
		assertEquals("Aula N11", p.getStanzaCorrente().getNome());
	}

	@Test
	public void testAddStanza() {
		this.testBuilder.addStanza("porticato");
		assertTrue(this.testBuilder.getDbStanze().containsKey("porticato"));
	}

	@Test
	public void testAddStanzaIniziale() {
		this.testBuilder.addStanzaIniziale("salone");
		assertEquals("salone", testBuilder.getLabirinto().getStanzaCorrente().getNome());
	}

	@Test
	public void testAddStanzaVincente() {
		this.testBuilder.addStanzaVincente("scale");
		assertEquals("scale", testBuilder.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testAddAdiacenza() {
		this.testBuilder.addStanza("salone");
		this.testBuilder.addStanza("scale");
		this.testBuilder.addAdiacenza("salone", "scale", "sud");
		assertEquals("scale", this.testBuilder.getDbStanze().get("salone").getStanzaAdiacente("sud").getNome());
	}

	@Test
	public void testAddAttrezzoInUltimaStanzaAggiunta() {
		this.testBuilder.addStanza("parcoGiochi");
		this.testBuilder.addAttrezzoInUltimaStanzaAggiunta("cassa", 4);
		assertEquals("cassa", this.testBuilder.getUltimaAggiunta().getAttrezzo("cassa").getNome());
	}

	@Test
	public void testCreaLabirinto() {
		Labirinto l = this.testBuilder.creaLabirinto("lab");
		assertEquals("lab", l.getNomeLabirinto());
	}

}
