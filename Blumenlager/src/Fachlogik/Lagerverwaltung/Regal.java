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
	private Blume musterBlume; // keine Musterblumen !! muss noch anders umgesetzt werden durch z.B. Kategorie
	private Bindegruen musterBindegruen;

	private ArrayList<Artikel> artikelliste;//Generics?
	
	// Id die sich hochz�hlt? feste Pl�tze wenn gel�scht und weiter dann �ndert die sich auch ?
//	public Regal(int maxAnzahl)
//	{
//		this.regalnummer = regalnummer ++;
//		this.maxAnzahlArtikel = maxAnzahl;
//	}
	public Regal(int idRegal, int maxAnzahl, String platzbezeichnung , ArrayList<Artikel> artikelliste){
		this.idRegal = idRegal;
		this.maxAnzahlArtikel = maxAnzahl;
		this.platzbezeichnung = platzbezeichnung;
		this.artikelliste = artikelliste;
	}

	public boolean addeArtikel(String bezeichnung, int anzahl)//------>>>> neues Attribut Kategorie in Artikel
	//TODO:generell nochmal Logik anpassen
	//TODO:erster Artikel wird als Referenzartikel genutzt, wenn Liste leer ,dann beliebig
	{
		if(artikelliste == null){
			artikelliste = new ArrayList<Artikel>();
		}
		if(artikelliste.size() < maxAnzahlArtikel)
		{
			if( bezeichnung != null)
			{
				if(musterBindegruen != null)
				{
					if(bezeichnung.equals(musterBindegruen.getBezeichnung()))
					{
						artikelliste.add(new Bindegruen(2,musterBindegruen.getBezeichnung()));//!!!  nicht richtig wartet auf richtige Umsetzung !
						return true;
					}
				}
				else
				{
					if(bezeichnung.equals(musterBlume.getBezeichnung()))
					{
						artikelliste.add(new Blume(3, musterBlume.getBezeichnung(), musterBlume.getFarbe(), musterBlume.getTyp()));//!! id-> auch nicht richtig
						return true;
					}
				}	
			}
		}
		return false;
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
