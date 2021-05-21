package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiaDiaSimulatorTest {

	DiaDiaSimulator diadia;
	IOSimulator ioSim;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUniversità() {
		
		Map<Integer, String> stringheDaInserire= new HashMap<>();
		stringheDaInserire.put(1, "vai nord");
		diadia = new DiaDiaSimulator(new IOSimulator(stringheDaInserire), "Universita");
//		diadia.getIo().setStringheDaInserire(stringheDaInserire);
		diadia.gioca();
		int trovato = 0;

		for (String string : diadia.getIo().getStringheStampate().values()) {
			if (string.contains("vinto")) {
				trovato = 1;
			}
		}
		
		assertTrue("Non hai vinto", trovato != 0);
	}

}
