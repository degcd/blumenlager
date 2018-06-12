package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import Datenhaltung.IDAO;

public interface ILagerverwaltung {
	
	public void addeLager(Lager l);
	public void laden() throws Exception;
	public void speichern() throws Exception;
	
	public ArrayList<Lager> getLagerListe();
	public Lager getLager(int id);
	public IDAO getDAO();

}
