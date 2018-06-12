package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import DTO.RegalDTO;
import Datenhaltung.IDAO;
import Datenhaltung.RegalDAO;
import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Artikelverwaltung.Bindegruen;
import Fachlogik.Artikelverwaltung.Blume;
import Fachlogik.Artikelverwaltung.IArtikelverwaltung;
import Fachlogik.Artikelverwaltung.Typ;

public class Regalverwaltung implements IRegalverwaltung{

	private ArrayList<Regal> regalListe;
	private RegalDAO regaldao;
	private Artikelverwaltung artikelverwaltung;
	
	

	public Regalverwaltung(IDAO regaldao, IArtikelverwaltung artikelverwaltung)
	{
		regalListe = new ArrayList<Regal>();
		this.regaldao = (RegalDAO) regaldao;
		this.artikelverwaltung = (Artikelverwaltung) artikelverwaltung;
	}
	public Regalverwaltung(IDAO regaldao, ArrayList<Regal> liste, IArtikelverwaltung artikelverwaltung)
	{
		regalListe = liste;
		this.regaldao = (RegalDAO) regaldao;
		this.artikelverwaltung = (Artikelverwaltung) artikelverwaltung;
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
	
	public Artikel createArtikel(String kategorie, int id, String bezeichnung, String farbe, Typ typ ){
		if(kategorie.equals("Blume"))
			return new Blume(id, bezeichnung, farbe, typ);
		else if(kategorie.equals("Bindegruen"))
			return new Bindegruen(id, bezeichnung);
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
						String kategorie = artikelliste.get(0).getKategorie();
						if(kategorie.equals("Blume"))
						{
							Blume musterBlume = (Blume) artikelliste.get(0);
							for(int i = 0; i < anzahlArtikel ; i++)
							{
								Blume neu = (Blume) createArtikel(kategorie, artikelverwaltung.getNextArtikelId(), musterBlume.getBezeichnung(), musterBlume.getFarbe(), musterBlume.getTyp());
								//Blume neu = new Blume(artikelverwaltung.getNextArtikelId(), musterBlume.getBezeichnung(), musterBlume.getFarbe(), musterBlume.getTyp());
								if(neu != null){
									artikelverwaltung.addeArtikel(neu);
									r.addeArtikel(neu);
								}

							}
						}
						else if(kategorie.equals("Bindegruen"))
						{
							Bindegruen musterBindegruen = (Bindegruen) artikelliste.get(0);
							for(int i = 0; i < anzahlArtikel ; i++)
							{
								Bindegruen neu = (Bindegruen) createArtikel(kategorie, artikelverwaltung.getNextArtikelId(), musterBindegruen.getBezeichnung(), "", null);
//								Bindegruen neu = new Bindegruen(artikelverwaltung.getNextArtikelId(), musterBindegruen.getBezeichnung());
								if(neu != null){
									artikelverwaltung.addeArtikel(neu);
									r.addeArtikel(neu);
								}
							}	
						}
					}
					else
					{
						throw new Exception("Regal ist keinem Artikel zugeordnet.(" + regalbezeichnung + ")");
					}
				}
				else
				{
					throw new Exception("So viele Artikel können nicht in " + regalbezeichnung + " eingelagert werden.");
				}
			}
			else{
				throw new Exception("Regal nicht gefunden. "+ regalbezeichnung +"ist nicht belegt.");
			}
			
		}
		else if(anzahlArtikel < 0)
		{
			throw new Exception("Werte dürfen nicht kleiner 0 sein. (" + regalbezeichnung + ")");
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
				if(artikelliste.size()-anzahlArtikel >= 1)
				{
					for(int i = 0; i < anzahlArtikel; i++)
					{
						r.removeArtikel();
						//Artikel existieren trotzdem in Artikelliste weiter nur nicht in Regal
					}
				}
				else
				{
					throw new Exception("So viele Artikel können nicht aus " + regalbezeichnung + " ausgelagert werden.");
				}
			}
			else{
				throw new Exception("Regal nicht gefunden. "+ regalbezeichnung +"ist nicht belegt.");
			}
		}
		else if(anzahlArtikel < 0)
		{
			throw new Exception("Werte dürfen nicht kleiner 0 sein. (" + regalbezeichnung + ")");
		}
	}
	
	
	public void laden()throws Exception{
    
		regalListe.clear();
		try{
			RegalDTO dto = regaldao.laden();
			ArrayList<Regal> tmpList = dto.getListe();
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
			regaldao.speichern(new RegalDTO(regaldao, regalListe, artikelverwaltung));
		}catch(Exception e){
			throw new Exception("Fehler beim Speichern der Regalliste: " + e.getMessage());
		}

	}


	@Override
	public IDAO getDAO() {
		return this.regaldao;
	}
	public IArtikelverwaltung getArtikelverwaltung(){
		return this.artikelverwaltung;
	}
	
}
