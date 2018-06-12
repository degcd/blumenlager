package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import DTO.LagerDTO;
import Datenhaltung.IDAO;
import Datenhaltung.LagerDAO;

public class Lagerverwaltung implements ILagerverwaltung{

	private ArrayList<Lager> lagerListe;
	private LagerDAO lagerdao;
	
	
	public Lagerverwaltung(IDAO lagerdao)
	{
		lagerListe = new ArrayList<Lager>();
		this.lagerdao = (LagerDAO) lagerdao;
	}
	
	public void addeLager(Lager l)
	{
		if(l != null)
			this.lagerListe.add(l);
	}
	

	public ArrayList<Lager> getLagerListe()
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
			LagerDTO dto = lagerdao.laden();
			ArrayList<Lager> tmpList = dto.getListe();
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
			lagerdao.speichern(new LagerDTO(lagerdao, lagerListe));
		}catch(Exception e){
			throw new Exception("Fehler beim Speichern der Lagerliste: " + e.getMessage());
		}

	}

	@Override
	public IDAO getDAO() {
		return this.lagerdao;
	}
	
	
}
