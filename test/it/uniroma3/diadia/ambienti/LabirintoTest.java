package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {

	Labirinto l = new Labirinto("l");
	Stanza testingRoom = new Stanza("Testing room");
	Stanza winningRoom = new Stanza("Winning room");

	@Test
	public void testLabirinto() {
		// verifichiamo che il labirinto abbia una stanza corrente e una vincente
		assertNotNull(l.getStanzaCorrente());
		assertNotNull(l.getStanzaVincente());
		
	}

	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(testingRoom);
		assertEquals(testingRoom, l.getStanzaCorrente());
	}

	@Test
	public void testSetStanzaVincente() {
		l.setStanzaVincente(winningRoom);	
		assertEquals(winningRoom, l.getStanzaVincente());}

}
