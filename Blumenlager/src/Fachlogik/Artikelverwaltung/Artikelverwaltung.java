package Fachlogik.Artikelverwaltung;

import java.util.ArrayList;
import java.util.HashSet;

import Datenhaltung.IArtikelDAO;
import Fachlogik.Lagerverwaltung.Regal;

public class Artikelverwaltung {

	private ArrayList<Artikel> artikelListe;
	private IArtikelDAO artdao;
	
	public Artikelverwaltung(IArtikelDAO artdao)
	{
		artikelListe = new ArrayList<Artikel>();
		this.artdao = artdao;
	}

	
	public ArrayList<Artikel> getRegalListe()
	{
		return this.artikelListe;
	}
	
}
