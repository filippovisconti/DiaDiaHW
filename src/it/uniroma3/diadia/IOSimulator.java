package it.uniroma3.diadia;

import java.util.HashMap;
import java.util.Map;

public class IOSimulator implements IO {

	private Map<Integer, String> stringheStampate;

	private Map<Integer, String> stringheDaInserire;
	
	int numeroStringheInseriteElaborate;
	int numeroStringheInseriteTotali;
	int numeroStringheProdotte;
	int numeroStringheStampate;

	public IOSimulator(Map<Integer, String> stringheDaInserire) {
		this.stringheDaInserire= stringheDaInserire;
		this.numeroStringheInseriteTotali= stringheDaInserire.size();
		this.numeroStringheInseriteElaborate= 0;
		
		this.stringheStampate= new HashMap<Integer, String>();
		this.numeroStringheProdotte= 0;
		this.numeroStringheStampate= 0;
	}


	public Map<Integer, String> getStringheStampate() {
		return stringheStampate;
	}

	public void setStringheStampate(Map<Integer, String> stringheStampate) {
		this.stringheStampate = stringheStampate;
	}

	public Map<Integer, String> getStringheDaInserire() {
		return stringheDaInserire;
	}


	public void setStringheDaInserire(Map<Integer, String> stringheDaInserire) {
		this.stringheDaInserire = stringheDaInserire;
		this.numeroStringheInseriteTotali= stringheDaInserire.size();
	}

	public String nextMessaggio() {
		String next= this.stringheStampate.get(this.numeroStringheStampate);
		if (next != null) this.numeroStringheStampate++;
		return next;
	}
	public boolean hasNextMessaggio() {
		return (this.numeroStringheStampate < this.numeroStringheProdotte);
	}


	@Override
	public void mostraMessaggio(String messaggio) {
		this.numeroStringheProdotte++;
		String s1 = "";
		if(this.stringheStampate.get(this.numeroStringheInseriteElaborate)!= null)
			s1 = new StringBuilder(
					this.stringheStampate.get(
							this.numeroStringheInseriteElaborate)).append(messaggio).toString();
		else {
			s1 = messaggio;
		}
		this.stringheStampate.put(this.numeroStringheInseriteElaborate, s1);
	}

	@Override
	public String leggiRiga() {
		if(numeroStringheInseriteElaborate < numeroStringheInseriteTotali) {
			this.numeroStringheInseriteElaborate++;
			return stringheDaInserire.get(numeroStringheInseriteElaborate);
		}
		return "fine";
	}

}
