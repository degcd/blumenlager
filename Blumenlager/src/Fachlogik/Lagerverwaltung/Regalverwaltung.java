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
	
	public Regal getRegal(int id)
	{
		for(Regal r: regalListe){
			if(r.getId() == id)
				return r;
		}
		return null;
	}
	
	public void laden()throws Exception{
		regalListe.clear();
		try{
			ArrayList<Regal> tmpList = regaldao.laden();
			for(Regal x : tmpList)
			{
				regalListe.add(x);
			}
		}catch(Exception e){
			throw new Exception("Fehler beim Laden der Regalliste: "+ e.getMessage());
		}
	}
	
	
	public void speichern() throws Exception{
		try{
			ArrayList<Regal> liste = new ArrayList<>();
			for (Regal r : regalListe)
				liste.add(r);
			regaldao.speichern(liste);
		}catch(Exception e){
			throw new Exception("Fehler beim Speichern der Regalliste: " + e.getMessage());
		}

	}


}
