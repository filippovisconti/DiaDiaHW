/**
 * @author filippovisconti allegrastrippoli
 *
 */

package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PartitaTest {


	Partita p;
	Stanza s1 = new Stanza("lab");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.p = new Partita();
	}

	@After
	public void tearDown() throws Exception {
		this.p = null;
	}

		
	
	@Test
	public void isFinitaBoolTrue() {
		p.setFinita();
		assertTrue(p.isFinita()); 
	}
	
	@Test
	public void isFinitaBoolFalse() {
		assertFalse(p.isFinita());
	}
	
	@Test
	public void isFinitaCfuTrue() {
		p.getGiocatore().setCfu(0);
		assertTrue(p.isFinita());
	}
	
	@Test
	public void isFinitaCfuFalse() {
		p.getGiocatore().setCfu(3);
		assertFalse(p.isFinita());
	}

	@Test
	public void isFinitaVintaTrue() {
		p.setStanzaCorrente(p.getStanzaVincente());
		assertTrue(p.isFinita());
	}
	

	@Test
	public void isFinitaVintaFalse() {
		p.setStanzaCorrente(s1);
		assertFalse(p.isFinita());
	}
	
	
	@Test
	public void vintaTrue() {
		p.setStanzaCorrente(p.getStanzaVincente());
		assertTrue(p.vinta());
		
	}
	

	@Test
	public void vintaFalse() {
		p.setStanzaCorrente(s1);
		assertFalse(p.vinta());
	}

	@Test
	public void vintaNull() {
		p.setStanzaCorrente(null);
		assertFalse(p.vinta());
	}



	
	
}



