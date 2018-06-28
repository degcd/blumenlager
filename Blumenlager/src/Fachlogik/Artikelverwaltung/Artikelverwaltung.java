package Fachlogik.Artikelverwaltung;

import java.util.ArrayList;

import DTO.ArtikelDTO;
import Datenhaltung.ArtikelDAO;
import Datenhaltung.IDAO;
import Logging.Log;

public class Artikelverwaltung implements IArtikelverwaltung{

	private ArrayList<Artikel> artikelListe;
	private ArtikelDAO artdao;
	
	public Artikelverwaltung(IDAO artdao)
	{
		artikelListe = new ArrayList<Artikel>();
		this.artdao = (ArtikelDAO) artdao;
	}
	
	public ArrayList<Artikel> getArtikelListe()
	{
		return this.artikelListe;
	}
	
	public void addeArtikel(Artikel a)
	{
		if(a != null)
			artikelListe.add(a);
	}
	
	public Artikel getArtikel(int id)
	{
		for(Artikel a: artikelListe){
			if(a.getId() == id)
				return a;
		}
		return null;
	}
	public int getNextArtikelId()
	{
		int max = 0;
		for(Artikel a:artikelListe)
		{
			if(a.getId() > max)
				max = a.getId();
		}
		return max + 1;
	}
	
	
	
	public void laden() throws Exception{
		artikelListe.clear();
		try{
			ArtikelDTO dto  = artdao.laden();
			ArrayList<Artikel> tmpList = dto.getListe();
			for(Artikel x : tmpList)
			{
				artikelListe.add(x);
			}
			try{
				Log blumenlagerLog = Log.getInstance("BlumenlagerLogging.txt");
				blumenlagerLog.logger.info("Artikelverwaltung wurde geladen.");
			}
			catch(Exception e){}
		}catch(Exception e){
			throw new Exception("Fehler beim Laden der Artikelliste.");
		}
	}
	
	
	public void speichern() throws Exception{
		try{
			artdao.speichern(new ArtikelDTO(artdao, artikelListe));
			try{
				Log blumenlagerLog = Log.getInstance("BlumenlagerLogging.txt");
				blumenlagerLog.logger.info("Artikelverwaltung wurde gespeichert.");
			}
			catch(Exception e){}
		}catch(Exception e){
			throw new Exception("Fehler beim Speichern der Artikelliste.");
		}

	}


	@Override
	public IDAO getDAO() {
		return this.artdao;
	}
}
