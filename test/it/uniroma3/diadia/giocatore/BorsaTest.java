package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	private Borsa test = new Borsa();
	Attrezzo[] attrezzi = {
			new Attrezzo("osso", 1), new Attrezzo("mazza", 4), 
			new Attrezzo("cane", 10), new Attrezzo("vaso", 15),
			new Attrezzo("falce", 8), new Attrezzo("pala", 6), 
			new Attrezzo("calcolatrice", 11), new Attrezzo("pianoforte", 100),
			new Attrezzo("astronave", 99999), new Attrezzo("elon", 90),
			new Attrezzo("model3", 2500), new Attrezzo("codicePenale", 2)
			};

	public final static int DEFAULT_PESO_MAX_BORSA = 10; 

	@Before
	public void setUp() {
		if(test.getNumeroAttrezzi() != 0) {
			test.setNumeroAttrezzi(0);
			Attrezzo[] temp = test.getAttrezzi();
			for(int i = 0; i < temp.length; i++) {
				temp[i] = null;
			}
		}
	}

	@Test
	public void testIsEmptyTrue() {
		test.setNumeroAttrezzi(0);
		assertTrue(test.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse() {
		test.addAttrezzo(attrezzi[0]);
		assertFalse(test.isEmpty());
	}


	@Test
	public void testHasAttrezzoTrue() {
		test.addAttrezzo(attrezzi[0]);
		assertTrue(test.hasAttrezzo(attrezzi[0].getNome()));
	}
	
	@Test
	public void testHasAttrezzoFalse() {
		assertFalse(test.hasAttrezzo("vaso"));
	}
	

	@Test
	public void testHasAttrezzoNull() {
		assertFalse(test.hasAttrezzo(null));
	}
	
	
	/**
	 * 
	 */
	@Test
	public void testAddAttrezzoAggiungoNull() {
		assertFalse(test.addAttrezzo(null));
	}
	

	@Test
	public void testAddAttrezzoStandard() {
		test.addAttrezzo(attrezzi[0]);
		assertEquals(attrezzi[0], test.getAttrezzo(attrezzi[0].getNome()));
	}	
	
	@Test
	public void testAddAttrezzoOverflow() {
		for(int i = 0; i < attrezzi.length; i++) {
			
			if(test.getPeso() >= (DEFAULT_PESO_MAX_BORSA)) 
				assertFalse(test.addAttrezzo(attrezzi[i]));
		
			else 
				test.addAttrezzo(attrezzi[i]);
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void testRemoveAttrezzoStandard() {
		for(int i = 0; i < attrezzi.length; i++) {
			test.addAttrezzo(attrezzi[i]);
		}
		for(int i = 0; i < attrezzi.length; i++) {
			test.removeAttrezzo(attrezzi[i].getNome());
			
			assertNull(test.getAttrezzo(attrezzi[i].getNome()));
		}
		
	}
	
	@Test
	public void testRemoveAttrezzoRimuoviNull() {
		assertNull(test.removeAttrezzo(null));
	}

	@Test
	public void testRemoveAttrezzoRimuoviAttrezzoNonPresente() {
		assertNull(test.removeAttrezzo("rullino foto"));
	}


}
