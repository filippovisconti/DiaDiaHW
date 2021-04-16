package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */


public interface Comando {
	  /**
	    * esecuzione del comando
	    */
	    public void esegui(Partita partita);
	  /**
	    * set parametro del comando
	    */
	    public void setParametro(String parametro);
	    
	    public void setIO(IOConsole console);
	}



//
//public class Comando {
//
//    private String nome;  
//    private String parametro; 
//    private String secondoParametro;
//
//    public Comando(String istruzione) {
//		Scanner scannerDiParole = new Scanner(istruzione);
//
//		// prima parola: nome del comando
//		if (scannerDiParole.hasNext())
//			this.nome = scannerDiParole.next(); 
//
//		// seconda parola: eventuale parametro
//		if (scannerDiParole.hasNext())
//			this.parametro = scannerDiParole.next();
//		
//		if (scannerDiParole.hasNext())
//			this.secondoParametro = scannerDiParole.next();
//		
//		scannerDiParole.close();
//    }
//
//    public String getNome() {
//        return this.nome;
//    }
//
//    public String getParametro() {
//        return this.parametro;
//    }
//    public String getSecParametro() {
//        return this.secondoParametro;
//    }
//
//    public boolean sconosciuto() {
//        return (this.nome == null);
//    }
//}