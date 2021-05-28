package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	
	private IO io;
	private String par;


	public abstract void esegui(Partita partita);


	public String getPararametro() {
		return par;
	}


	public void setParametro(String par) {
		this.par = par;
	}


	public IO getIO() {
		return io;
	}


	public void setIO(IO io) {
		this.io = io;
	}
	
	
}
