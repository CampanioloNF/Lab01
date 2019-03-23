package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
		
	private List <String> lista;
	
	public Parole() {
		
	    lista = new ArrayList<String>();
		
	}
	
	public void addParola(String p) {
		
		String c = p;
		
		if(!c.trim().equals(""))
		    lista.add(p);
		
	}
	
	public List<String> getElenco() {
		//TODO
		
		Collections.sort(lista);
		
		return lista;
	}
	
	public void reset() {
		lista.clear();
	}

	public void elimina(String p) {
		
	String c = p;
		
		if(!c.trim().equals(""))
		    lista.remove(p);
	}
}
