package DTO;

import java.util.ArrayList;

import Datenhaltung.IDAO;
import Datenhaltung.LagerDAO;
import Fachlogik.Lagerverwaltung.Lager;

public class LagerDTO implements IDTO{

	private ArrayList<Lager> liste;
	private LagerDAO dao;
	
	public LagerDTO(IDAO dao, ArrayList<Lager> l)
	{
		this.liste = l;
		this.dao = (LagerDAO)dao;
	}
	
	public ArrayList<Lager> getListe()
	{
		return liste;
	}

	@Override
	public IDAO getDAO() {
		return dao;
	}
	
}
