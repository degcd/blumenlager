package Fachlogik.Artikelverwaltung;

import java.util.ArrayList;

public abstract class Artikel {


  private String kategorie;
	private int idArtikel;
	private String bezeichnung;

    

	
	public Artikel(int artikelnr, String kategorie, String bezeichnung)
	{
		this.idArtikel = artikelnr;
		this.kategorie = kategorie;
		this.bezeichnung = bezeichnung;
	}
	

	//wird zur Identifikation genutzt; darf nicht geändert werden ? Methode löschen ?

//	public void setBezeichnung(String bezeichnung)
//	{
//		this.bezeichnung = bezeichnung;
//	}
	
	public String getKategorie()
	{
		return kategorie;
	}

	public int getId()
	{
		return this.idArtikel;
	}
	
	public String getBezeichnung()
	{
		return this.bezeichnung;
	}
	
}
