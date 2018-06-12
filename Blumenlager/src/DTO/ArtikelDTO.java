package DTO;

import java.util.ArrayList;

import Datenhaltung.ArtikelDAO;
import Datenhaltung.IDAO;
import Fachlogik.Artikelverwaltung.Artikel;

public class ArtikelDTO implements IDTO {

	private ArrayList<Artikel> liste;
	private ArtikelDAO dao;
	
	public ArtikelDTO(IDAO dao, ArrayList<Artikel> l)
	{
		this.liste = l;
		this.dao = (ArtikelDAO) dao;
	}
	
	public ArrayList<Artikel> getListe()
	{
		return liste;
	}

	public IDAO getDAO() {
		return dao;
	}
	
	
}
