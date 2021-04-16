/**
 * 
 */
package it.uniroma3.diadia.giocatore;

/**
 * @author filippovisconti allegrastrippoli
 * 
 * Giocatore ha la responsabilità di gestire i CFU del giocatore e di memorizzare gli attrezzi 
 * in un oggetto istanza della classe Borsa 
 */
public class Giocatore {
	private int cfu;
	private Borsa borsa;
	
	public Giocatore(int x, Borsa b) {
		this.cfu = x;
		this.borsa = b;
	}
	public Giocatore(int x) {
		this.cfu = x;
		this.borsa = new Borsa();
	}
	
	public Giocatore() {
		this.cfu = 10;
		this.borsa = new Borsa();
	}
	
	public int decrementaCfu() {
		if(this.cfu > 0) 
			this.cfu = this.cfu -1;
		return this.cfu;
	
	}
	public boolean isVivo() {
		return this.cfu > 0;
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	public int getCfu() {
		return cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	
}
