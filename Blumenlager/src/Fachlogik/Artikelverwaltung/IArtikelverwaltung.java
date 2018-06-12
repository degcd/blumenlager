package Fachlogik.Artikelverwaltung;

import java.util.ArrayList;

import Datenhaltung.IDAO;

public interface IArtikelverwaltung {
	
	public void addeArtikel(Artikel a);
	public void laden() throws Exception;
	public void speichern() throws Exception;
	
	public ArrayList<Artikel> getArtikelListe();
	public Artikel getArtikel(int id);
	public int getNextArtikelId();
	public IDAO getDAO();
	
}
