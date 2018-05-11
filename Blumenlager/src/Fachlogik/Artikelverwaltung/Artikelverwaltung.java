package Fachlogik.Artikelverwaltung;

import java.util.ArrayList;
import java.util.HashSet;

import Datenhaltung.IArtikelDAO;
import Fachlogik.Lagerverwaltung.Regal;

public class Artikelverwaltung {

	private ArrayList<Artikel> artikelListe;
	private IArtikelDAO artdao;
	
	public Artikelverwaltung(IArtikelDAO artdao)
	{
		artikelListe = new ArrayList<Artikel>();
		this.artdao = artdao;
	}

	
	public ArrayList<Artikel> getArtikelListe()
	{
		return this.artikelListe;
	}
	
	public void addeArtikel(Artikel a)
	{
		if(a != null){
			artikelListe.add(a);
		}
	}
	public Artikel getArtikel(int id)
	{
		for(Artikel a: artikelListe){
			if(a.getId() == id)
				return a;
		}
		return null;
	}
	
	
	//remove Artikel nicht zwingend nötig da beim Auslagern nur die Blumen aus den Regalen genommen werden, 
	//aber ansonsten weiter existieren
	
	public void laden()throws Exception{
		artikelListe.clear();
		try{
			ArrayList<Artikel> tmpList = artdao.laden();
			for(Artikel x : tmpList)
			{
				artikelListe.add(x);
			}
		}catch(Exception e){
			throw new Exception("Fehler beim Laden der Artikelliste.");
		}
	}
	
	
	public void speichern() throws Exception{
		try{
			ArrayList<Artikel> liste = new ArrayList<>();
			for (Artikel a : artikelListe)
				liste.add(a);
			artdao.speichern(liste);
		}catch(Exception e){
			throw new Exception("Fehler beim Speichern der Artikelliste.");
		}

	}
}
