/**
 * 
 */
package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author filippovisconti allegrastrippoli
 *
 */
public class GiocatoreTest {
	int cfuOriginali = 10;
	Giocatore g = new Giocatore(cfuOriginali);
	
	@Test
	public void testDecrementaCfu() {
		g.decrementaCfu();
		assertEquals(cfuOriginali -1, g.getCfu());
	}

	@Test
	public void testSetCfu() {
		g.setCfu(cfuOriginali);
		assertEquals(cfuOriginali, g.getCfu());
	}

}
