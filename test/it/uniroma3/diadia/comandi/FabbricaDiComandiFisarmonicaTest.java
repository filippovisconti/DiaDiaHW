package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {
	FabbricaDiComandiFisarmonica f = null;

	@Before
	public void setUp() throws Exception {
		f = new FabbricaDiComandiFisarmonica();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNome() {
		f.costruisciComando("aiuto");
		assertEquals("aiuto", f.getNome());
	}
	
	public void testGetParametro() {
		f.costruisciComando("vai nord");
		assertEquals("vai", f.getNome());
		assertEquals("nord", f.getParametro());
	}

}
