package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import Datenhaltung.IDAO;
import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Typ;

public interface IRegalverwaltung {

	public void addeRegal(Regal r);
	public Artikel createArtikel(String kategorie, int id, String bezeichnung, String farbe, Typ typ );
	public void einlagern(String regalbezeichnung, int anzahlArtikel) throws Exception;
	public void auslagern(String regalbezeichnung, int anzahlArtikel) throws Exception;
	public void laden() throws Exception;
	public void speichern() throws Exception;
	
	public ArrayList<Regal> getRegalListe();
	public Regal getRegal(int id);
	public Regal getRegal(String platzbezeichnung);
	public IDAO getDAO();
	
	
}
