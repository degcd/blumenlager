package DTO;

import java.util.ArrayList;

import Datenhaltung.IDAO;
import Datenhaltung.RegalDAO;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Artikelverwaltung.IArtikelverwaltung;
import Fachlogik.Lagerverwaltung.Regal;

public class RegalDTO implements IDTO {

	
	private ArrayList<Regal> liste;
	private Artikelverwaltung artikelverwaltung;
	private RegalDAO dao;
	
	public RegalDTO(IDAO dao, ArrayList<Regal> l, IArtikelverwaltung artikelverwaltung)
	{
		this.liste = l;
		this.artikelverwaltung = (Artikelverwaltung) artikelverwaltung;
		this.dao = (RegalDAO) dao;
	}
	
	public ArrayList<Regal> getListe()
	{
		return liste;
	}
	public Artikelverwaltung getArtikelverwaltung(){
		return artikelverwaltung;
	}
	public IDAO getDAO(){
		return this.dao;
	}
	
}
