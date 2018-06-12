package Fachlogik.Lagerverwaltung;


import java.util.ArrayList;

import Fachlogik.Artikelverwaltung.Artikel;

public class Regal {

	private int idRegal = 1;
	private String platzbezeichnung;
	private int maxAnzahlArtikel;
	private ArrayList<Artikel> artikelliste;
	
	public Regal(int idRegal, int maxAnzahl, String platzbezeichnung , ArrayList<Artikel> artikelliste){
		this.idRegal = idRegal;
		this.maxAnzahlArtikel = maxAnzahl;
		this.platzbezeichnung = platzbezeichnung;
		this.artikelliste = artikelliste;
	}

	public void addeArtikel(Artikel a)
	{
		if(a != null && artikelliste .size() < maxAnzahlArtikel)
			artikelliste.add(a);
			
	}
	public void removeArtikel(){
		if(artikelliste.size() > 0)
			artikelliste.remove(0);
	}
	
	
	public ArrayList<Artikel> getArtikelListe(){
		return this.artikelliste;
	}

	public void setMaxAnzahlArtikel(int maxAnzahlArtikel)
	{
		this.maxAnzahlArtikel = maxAnzahlArtikel;
	}
	public int getId()
	{
		return this.idRegal;
	}
	public String getPlatzbezeichnung()
	{
		return this.platzbezeichnung;
	}
	public int getMaxAnzahlArtikel()
	{
		return this.maxAnzahlArtikel;
	}
}
