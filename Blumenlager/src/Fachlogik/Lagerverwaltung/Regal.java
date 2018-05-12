package Fachlogik.Lagerverwaltung;


import java.util.ArrayList;

import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Bindegruen;
import Fachlogik.Artikelverwaltung.Blume;
import Fachlogik.Artikelverwaltung.Typ;

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
		artikelliste.remove(0);
	}
	
//	public boolean addeArtikel(String bezeichnung, int anzahl)
//	{
//		if(artikelliste == null){
//			artikelliste = new ArrayList<Artikel>();
//		}
//		if(artikelliste.size() < maxAnzahlArtikel)
//		{
//			if( bezeichnung != null)
//			{
//				if(musterBindegruen != null)
//				{
//					if(bezeichnung.equals(musterBindegruen.getBezeichnung()))
//					{
//						artikelliste.add(new Bindegruen(2,musterBindegruen.getBezeichnung()));//!!!  nicht richtig wartet auf richtige Umsetzung !
//						return true;
//					}
//				}
//				else
//				{
//					if(bezeichnung.equals(musterBlume.getBezeichnung()))
//					{
//						artikelliste.add(new Blume(3, musterBlume.getBezeichnung(), musterBlume.getFarbe(), musterBlume.getTyp()));//!! id-> auch nicht richtig
//						return true;
//					}
//				}	
//			}
//		}
//		return false;
//	}
	
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
