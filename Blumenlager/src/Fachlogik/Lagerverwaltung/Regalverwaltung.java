package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import Datenhaltung.IRegalDAO;
import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Artikelverwaltung.Bindegruen;
import Fachlogik.Artikelverwaltung.Blume;

public class Regalverwaltung {

	private ArrayList<Regal> regalListe;
	private IRegalDAO regaldao;
	private Artikelverwaltung artikelverwaltung;
	
	//artikelverwaltung wird benötigt für nächste id; für andere Lösungsvorschläge  offen
	//wird auch für normale artikelliste benötigt
	public Regalverwaltung(IRegalDAO regaldao, Artikelverwaltung artikelverwaltung)
	{
		regalListe = new ArrayList<Regal>();
		this.regaldao = regaldao;
		this.artikelverwaltung = artikelverwaltung;
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
	
	public Regal getRegal(String platzbezeichnung)
	{
		for(Regal r: regalListe)
		{
			if(r.getPlatzbezeichnung().equals(platzbezeichnung))
			{
				return r;
			}
		}
		return null;
	}
	
	public void einlagern(String regalbezeichnung, int anzahlArtikel) throws Exception
	{
		if(anzahlArtikel > 0)
		{
			Regal r = getRegal(regalbezeichnung);
			if(r != null)
			{
				ArrayList<Artikel> artikelliste = r.getArtikelListe();
				if(artikelliste.size()+anzahlArtikel <= r.getMaxAnzahlArtikel())
				{
					if(artikelliste.size() > 0)
					{
						if(artikelliste.get(0).getKategorie().equals("Blume"))
						{
							Blume musterBlume = (Blume) artikelliste.get(0);
							for(int i = 0; i < anzahlArtikel ; i++)
							{
								Blume neu = new Blume(artikelverwaltung.getNextArtikelId(), musterBlume.getBezeichnung(), musterBlume.getFarbe(), musterBlume.getTyp());
								artikelverwaltung.addeArtikel(neu);
								r.addeArtikel(neu);
							}
						}
						else if(artikelliste.get(0).getKategorie().equals("Bindegruen"))
						{
							Bindegruen musterBindegruen = (Bindegruen) artikelliste.get(0);
							for(int i = 0; i < anzahlArtikel ; i++)
							{
								Bindegruen neu = new Bindegruen(artikelverwaltung.getNextArtikelId(), musterBindegruen.getBezeichnung());
								artikelverwaltung.addeArtikel(neu);
								r.addeArtikel(neu);
							}	
						}
					}
					else
					{
						throw new Exception("Regal ist keinem Artikel zugeordnet.");
					}
				}
				else
				{
					throw new Exception("So viele Artikel können nicht in " + regalbezeichnung + " eingelagert werden.");
				}
			}
			else{
				throw new Exception("Regal nicht gefunden. Platz ist nicht belegt.");
			}
			
		}
		else if(anzahlArtikel < 0)
		{
			throw new Exception("Werte müssen größer 0 sein.");
		}
	}
	
	public void auslagern(String regalbezeichnung, int anzahlArtikel) throws Exception
	{
		if(anzahlArtikel > 0)
		{
			Regal r = getRegal(regalbezeichnung);
			if(r != null)
			{
				ArrayList<Artikel> artikelliste = r.getArtikelListe();
				if(artikelliste.size()+anzahlArtikel <= r.getMaxAnzahlArtikel())
				{
					if(artikelliste.size() > 0)
					{
						if(artikelliste.get(0).getKategorie().equals("Blume"))
						{
							Blume musterBlume = (Blume) artikelliste.get(0);
							for(int i = 0; i < anzahlArtikel ; i++)
							{
								Blume neu = new Blume(artikelverwaltung.getNextArtikelId(), musterBlume.getBezeichnung(), musterBlume.getFarbe(), musterBlume.getTyp());
								artikelverwaltung.addeArtikel(neu);
								r.addeArtikel(neu);
							}
						}
						else if(artikelliste.get(0).getKategorie().equals("Bindegruen"))
						{
							Bindegruen musterBindegruen = (Bindegruen) artikelliste.get(0);
							for(int i = 0; i < anzahlArtikel ; i++)
							{
								Bindegruen neu = new Bindegruen(artikelverwaltung.getNextArtikelId(), musterBindegruen.getBezeichnung());
								artikelverwaltung.addeArtikel(neu);
								r.addeArtikel(neu);
							}	
						}
					}
					else
					{
						throw new Exception("Regal ist keinem Artikel zugeordnet.");
					}
				}
				else
				{
					throw new Exception("So viele Artikel können nicht in " + regalbezeichnung + " eingelagert werden.");
				}
			}
			else{
				throw new Exception("Regal nicht gefunden. Platz ist nicht belegt.");
			}
			
		}
		else if(anzahlArtikel < 0)
		{
			throw new Exception("Werte müssen größer 0 sein.");
		}
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
