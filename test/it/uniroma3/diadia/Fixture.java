package it.uniroma3.diadia;

import java.util.Map;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Fixture {

	public static IOSimulator creaSimulazionePartitaEGioca(Map<Integer, String> stringheDaInserire) {
		IOSimulator io= new IOSimulator(stringheDaInserire);
		new DiaDia(io, "Universita").gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEAggiungiStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo= new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
