package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AbstractComandoTest {

	FakeComando c;
	
	@Before
	public void setUp() throws Exception {
		c = new FakeComando();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComandoSenzaParametro() {
		assertContains("null", c.eseguiTest()); 
	}
	
	@Test
	public void testComandoConParametro() {
		assertContains("null", c.eseguiTest()); 
		c.setParametro("nord");
		assertContains("nord", c.eseguiTest()); 
	}
	
	public void assertContains(String expected, String interaRiga) {
        assertTrue(interaRiga.contains(expected));
    }


}
