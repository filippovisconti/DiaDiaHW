package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa test;
	
	Attrezzo[] attrezzi = {
			new Attrezzo("osso", 1), new Attrezzo("mazza", 2), 
			new Attrezzo("cane", 3), new Attrezzo("vaso", 2),
			new Attrezzo("falce", 5), new Attrezzo("pala", 2), 
			new Attrezzo("calcolatrice", 11), new Attrezzo("pianoforte", 100),
			};
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10; 

	@Before
	public void setUp() {
		test = new Borsa();
	}
	
	public void riempiBorsa() {
		for (Attrezzo attrezzo : attrezzi) {
			test.addAttrezzo(attrezzo);
		}
	}

	@Test
	public void testIsEmptyTrue() {
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

	@Test
	public void testOrdPesoVuoto(){
		assertTrue(test.getContenutoOrdinatoPerPeso().isEmpty());
	}
	
	@Test
	public void testOrdPesoNonVuoto(){
		riempiBorsa();
		assertFalse("La borsa è vuota, ma non dovrebbe esserlo.", test.getContenutoOrdinatoPerPeso().isEmpty());
		List<Attrezzo> lista = test.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> i = lista.iterator();
		Attrezzo a1 = i.next();
		while (i.hasNext()) {
			Attrezzo a2 = i.next();
			assertTrue("Ordinamento errato sui pesi.", a2.getPeso() >= a1.getPeso());
			a1 = a2;
		}
		
	}
	
	@Test
	public void testOrdPesoNonVuotoCheckSuiNomi(){
		riempiBorsa();
		assertFalse("La borsa è vuota, ma non dovrebbe esserlo.", test.getContenutoOrdinatoPerPeso().isEmpty());
		List<Attrezzo> lista = test.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> i = lista.iterator();
		Attrezzo a1 = i.next();
		while (i.hasNext()) {
			Attrezzo a2 = i.next();
			if(a2.getPeso() == a1.getPeso())
			assertTrue("Ordinamento errato sui nomi, con pesi uguali.", a2.getNome().compareTo(a1.getNome()) > 0);
			a1 = a2;
		}
		
	}
	
	@Test
	public void testOrdNomiVuoto(){
		assertTrue(test.getContenutoOrdinatoPerNome().isEmpty());
	}
	
	@Test
	public void testOrdNomeNonVuoto(){
		riempiBorsa();
		assertFalse("La borsa è vuota, ma non dovrebbe esserlo.", test.getContenutoOrdinatoPerNome().isEmpty());
		Set<Attrezzo> lista = test.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> i = lista.iterator();
		Attrezzo a1 = i.next();
		while (i.hasNext()) {
			Attrezzo a2 = i.next();
			assertTrue("Ordinamento errato sui nomi.", a2.getNome().compareTo(a1.getNome()) > 0);
			a1 = a2;
		}
		
	}
	
	@Test
	public void testSortedSetOrdPesoVuoto(){
		assertTrue(test.getSortedSetOrdinatoPerPeso().isEmpty());
	}
	
	@Test
	public void testSortedSetOrdPesoNonVuoto(){
		riempiBorsa();
		assertFalse("La borsa è vuota, ma non dovrebbe esserlo.", test.getSortedSetOrdinatoPerPeso().isEmpty());
		Set<Attrezzo> lista = test.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> i = lista.iterator();
		Attrezzo a1 = i.next();
		while (i.hasNext()) {
			Attrezzo a2 = i.next();
			assertTrue("Ordinamento errato sui pesi.", a2.getPeso() >= a1.getPeso());
			a1 = a2;
		}
		
	}
	
	@Test
	public void testSortedSetOrdPesoNonVuotoCheckSuiNomi(){
		riempiBorsa();
		assertFalse("La borsa è vuota, ma non dovrebbe esserlo.", test.getSortedSetOrdinatoPerPeso().isEmpty());
		Set<Attrezzo> lista = test.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> i = lista.iterator();
		Attrezzo a1 = i.next();
		while (i.hasNext()) {
			Attrezzo a2 = i.next();
			if(a2.getPeso() == a1.getPeso())
			assertTrue("Ordinamento errato sui nomi, con pesi uguali.", a2.getNome().compareTo(a1.getNome()) > 0);
			a1 = a2;
		}
		
	}

}
