/**
 * 
 */
package it.uniroma3.diadia.giocatore;


import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * @author filippovisconti allegrastrippoli
 *
 */
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10; 

	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;


	/* Costruttori */
	public Borsa() { 
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>(); 
		//		this.numeroAttrezzi = 0;
	}


	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);	
	}

	public int getPeso() {
		int peso = 0;

		for (Attrezzo a : this.attrezzi.values()) 
			peso += a.getPeso();

		return peso;
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo == null)
			return false;

		return (this.getAttrezzo(nomeAttrezzo) != null);
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null) return false;

		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;

		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		//		this.numeroAttrezzi++;
		return true;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
	}

	public int getPesoMax() {
		return pesoMax;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Borsa vuota");
		} else
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		for (Attrezzo attrezzo : this.attrezzi.values()) 
			s.append(attrezzo.toString()+" ");

		return s.toString();
	}


	//	
	//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
	//		if (this.hasAttrezzo(nomeAttrezzo)) {
	//
	//			Attrezzo temp = null; 
	//			
	//			for(int i = 0; i < this.numeroAttrezzi && temp == null; i++) {
	//				if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
	//					temp = attrezzi[i];
	//					for(int j = i; j < this.numeroAttrezzi - 1; j++) {
	//						this.attrezzi[j] = this.attrezzi[j+1];
	//					}
	//					attrezzi[this.numeroAttrezzi -1] = null; 	
	//				}
	//			}
	//
	//			this.numeroAttrezzi = this.numeroAttrezzi - 1;
	//			return temp;
	//		}
	//		else {
	//			return null;
	//		}
	//	}
	//	private int numeroAttrezzi;
	//	
	//	public int getNumeroAttrezzi() {
	//		return numeroAttrezzi;
	//	}
	//	
	//	
	//	public void setNumeroAttrezzi(int numeroAttrezzi) {
	//		this.numeroAttrezzi = numeroAttrezzi;
	//	}
	//

	//	
}