package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import Datenhaltung.ILagerDAO;

public class Lagerverwaltung {

	private ArrayList<Lager> lagerListe;
	private ILagerDAO lagerdao;
	
	
	public Lagerverwaltung(ILagerDAO lagerdao)
	{
		lagerListe = new ArrayList<Lager>();
		this.lagerdao = lagerdao;
	}
	
	public void addeLager(Lager l)
	{
		if(l != null)
			this.lagerListe.add(l);
	}
	

	public ArrayList<Lager> getRegalListe()
	{
		return this.lagerListe;
	}
	
	public Lager getLager(int id)
	{
		for(Lager l: lagerListe){
			if(l.getId() == id)
				return l;
		}
		return null;
	}
	
	public void laden()throws Exception{
		lagerListe.clear();
		try{
			ArrayList<Lager> tmpList = lagerdao.laden();
			for(Lager x : tmpList)
			{
				lagerListe.add(x);
			}
		}catch(Exception e){
			throw new Exception("Fehler beim Laden der Lagerliste: "+ e.getMessage());
		}
	}
	
	
	public void speichern() throws Exception{
		try{
			ArrayList<Lager> liste = new ArrayList<>();
			for (Lager l : lagerListe)
				liste.add(l);
			lagerdao.speichern(liste);
		}catch(Exception e){
			throw new Exception("Fehler beim Speichern der Lagerliste: " + e.getMessage());
		}

	}

	
	
}
