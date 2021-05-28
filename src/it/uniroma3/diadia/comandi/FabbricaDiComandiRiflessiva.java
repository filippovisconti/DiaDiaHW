package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	String nomeComando; // es. ‘vai’
	String parametro;   // es. ‘sud’

	@Override
	public AbstractComando costruisciComando(String istruzione) throws Exception {
		@SuppressWarnings("resource")
		Scanner scannerDiParole = new Scanner(istruzione); // es. ‘vai sud’
		this.nomeComando = null; // es. ‘vai’
		this.parametro = null;   // es. ‘sud’
		AbstractComando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
		
		StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
		nomeClasse.append( nomeComando.substring(1) );
		// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoV’ nomeClasse.append( nomeComando.substring(1) ) ;
		// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoVai’
		comando = (AbstractComando)Class.forName(nomeClasse.toString()).getDeclaredConstructor().newInstance();
		comando.setParametro(parametro);
				
		return comando;
	}

	@Override
	public String getNome() {
		return nomeComando;
	}

	@Override
	public String getParametro() {
		return parametro;
	}

}
