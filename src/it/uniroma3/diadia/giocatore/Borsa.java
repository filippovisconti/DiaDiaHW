/**
 * 
 */
package it.uniroma3.diadia.giocatore;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

//import it.uniroma3.diadia.IO; 
//import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;
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

	public int getDimensione() {
		return this.attrezzi.size();
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

	/*
	 * @return la lista degli attrezzi nella borsa ordinati per peso e quindi, 
	 * a parità di peso, per nome
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziPerPeso = new ArrayList<>(this.attrezzi.values());
		Collections.sort(attrezziPerPeso, new ComparatoreAttrezziPerPeso());
		return attrezziPerPeso;

	}

	/*
	 * @return l'insieme degli attrezzi nella borsa ordinati per nome
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<>(this.attrezzi.values());
	}

	/* 
	 * restituisce una mappa che associa un intero (rappresentante un peso) 
	 * con l’insieme (comunque non vuoto) degli attrezzi di tale peso: 
	 * tutti gli attrezzi dell'insieme che figura come valore hanno 
	 * lo stesso peso pari all'intero che figura come chiave
	 */
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mappaPerPeso = new TreeMap<>();

		for (Attrezzo a : this.attrezzi.values()) {
			if(mappaPerPeso.containsKey(a.getPeso())) 
				mappaPerPeso.put(a.getPeso(), new TreeSet<Attrezzo>());
			
			mappaPerPeso.get(a.getPeso()).add(a);
		}
		return mappaPerPeso;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> setPerPeso = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		setPerPeso.addAll(this.attrezzi.values());
		return setPerPeso;
			
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
	
	public Map<String, Attrezzo> getAttrezzi() {
		return attrezzi;
	}
	public void setAttrezzi(Map<String, Attrezzo> attrezzi) {
		this.attrezzi = attrezzi;
	}
	
//	 TODO: import io e metodi main() e ordinamenti() da eliminare
//	public static void ordinamenti() {
//		Attrezzo[] attrezzi = {
//				new Attrezzo("osso", 1), new Attrezzo("mazza", 2), 
//				new Attrezzo("cane", 3), new Attrezzo("vaso", 2),
//				new Attrezzo("falce", 5), new Attrezzo("pala", 2), 
//				new Attrezzo("calcolatrice", 11), new Attrezzo("pianoforte", 100),
//				};
//		Borsa test = new Borsa();
//		
//		for (Attrezzo attrezzo : attrezzi) {
//			test.addAttrezzo(attrezzo);
//		}
//		IO io = new IOConsole();
//		
//		for (Attrezzo attrezzo : test.getAttrezzi().values()) {
//			io.mostraMessaggio(attrezzo.toString());
//		}
//		io.mostraMessaggio("---");
//		for (Attrezzo attrezzo : test.getContenutoOrdinatoPerPeso()) {
//			io.mostraMessaggio(attrezzo.toString());
//		}
//		
//		io.mostraMessaggio("---");
//		for (Attrezzo attrezzo : test.getContenutoOrdinatoPerNome()) {
//			io.mostraMessaggio(attrezzo.toString());
//		}
//		io.mostraMessaggio("---");
//		for (Integer i : test.getContenutoRaggruppatoPerPeso().keySet()) {
//			io.mostraMessaggio(i + ": ");
//			for (Attrezzo attrezzo : test.getContenutoRaggruppatoPerPeso().get(i)) {
//				io.mostraMessaggio(attrezzo.toString());
//			}
//			io.mostraMessaggio("^^^");
//		}
//
//	}
//	public static void main(String[] args) {
//		ordinamenti();
//	}

}