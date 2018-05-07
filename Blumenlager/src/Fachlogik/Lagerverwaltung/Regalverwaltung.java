package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import Datenhaltung.IArtikelDAO;
import Datenhaltung.IRegalDAO;
import Fachlogik.Artikelverwaltung.Artikel;

public class Regalverwaltung {

	private ArrayList<Regal> regalListe;
	private IRegalDAO regaldao;
	
	
	public Regalverwaltung(IRegalDAO regaldao)
	{
		regalListe = new ArrayList<Regal>();
		this.regaldao = regaldao;
	}
	
	public void addeRegal(Regal r)
	{
		if(r != null)
			this.regalListe.add(r);
	}
	

	public ArrayList<Regal> getRegalListe()
	{
		return this.regalListe;
	}
	
	public void laden()throws Exception{
		//TODO : die Methode hier ist nicht vollständig und nur von Artikelverw. kopiert & abgeändert
		regalListe.clear();
		try{
			ArrayList<Regal> tmpList = regaldao.laden();
			for(Regal x : tmpList)
			{
				regalListe.add(x);
			}
		}catch(Exception e){
			throw new Exception("Fehler beim Laden der Regalliste.");
		}
	}
	
	
	public void speichern() throws Exception{
		//TODO
		try{
			ArrayList<Regal> liste = new ArrayList<>();
			for (Regal r : regalListe)
				liste.add(r);
			regaldao.speichern(liste);
		}catch(Exception e){
			throw new Exception("Fehler beim Speichern der Regalliste.");
		}

	}


}
