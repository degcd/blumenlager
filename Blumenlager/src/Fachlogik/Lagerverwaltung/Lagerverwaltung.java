package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import DTO.LagerDTO;
import Datenhaltung.IDAO;
import Datenhaltung.LagerDAO;
import Logging.Log;

/*verwaltet alle Lager*/
public class Lagerverwaltung implements ILagerverwaltung{

	private ArrayList<Lager> lagerListe;
	private LagerDAO lagerdao;
	
	
	public Lagerverwaltung(IDAO lagerdao)
	{
		lagerListe = new ArrayList<Lager>();
		this.lagerdao = (LagerDAO) lagerdao;
	}
	/*f�gt ein Lager zur Liste hinzu*/
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
	/*l�dt alle Lager und speichert sie in einer Liste*/
	public void laden()throws Exception{
		lagerListe.clear();
		try{
			LagerDTO dto = lagerdao.laden();
			ArrayList<Lager> tmpList = dto.getListe();
			for(Lager x : tmpList)
			{
				lagerListe.add(x);
			}
			try{
				Log blumenlagerLog = Log.getInstance("BlumenlagerLogging.txt");
				blumenlagerLog.logger.info("Lagerverwaltung wurde geladen.");
			}
			catch(Exception e){}
		}catch(Exception e){
			throw new Exception("Fehler beim Laden der Lagerliste: "+ e.getMessage());
		}
	}
	
	/*speichert alle Lager*/
	public void speichern() throws Exception{
		try{
			lagerdao.speichern(new LagerDTO(lagerdao, lagerListe));
			try{
				Log blumenlagerLog = Log.getInstance("BlumenlagerLogging.txt");
				blumenlagerLog.logger.info("Lagerverwaltung wurde gespeichert.");
			}
			catch(Exception e){}
		}catch(Exception e){
			throw new Exception("Fehler beim Speichern der Lagerliste: " + e.getMessage());
		}

	}

	@Override
	public IDAO getDAO() {
		return this.lagerdao;
	}
	
	
}
