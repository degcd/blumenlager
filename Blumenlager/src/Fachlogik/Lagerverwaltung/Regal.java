package Fachlogik.Lagerverwaltung;


import java.util.ArrayList;

import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Bindegruen;
import Fachlogik.Artikelverwaltung.Blume;
import Fachlogik.Artikelverwaltung.Typ;

public class Regal {

	private static int regalnummer = 1;
	private int maxAnzahlArtikel;
	private Blume musterBlume;
	private Bindegruen musterBindegruen;
	private ArrayList<Artikel> artikelliste;//Generics?
	
	// Id die sich hochz�hlt? feste Pl�tze wenn gel�scht und weiter dann �ndert die sich auch ?
	public Regal(int maxAnzahl, Bindegruen musterArtikel )
	{
		this.regalnummer = regalnummer ++;
		this.maxAnzahlArtikel = maxAnzahl;
		this.musterBindegruen = musterArtikel;
	}
	public Regal(int maxAnzahl, Blume musterArtikel )
	{
		regalnummer = regalnummer ++;
		this.maxAnzahlArtikel = maxAnzahl;
		this.musterBlume = musterArtikel;
	}
	//EXCEPTIONS?
	public boolean addeArtikel(String bezeichnung, int anzahl)
	{
		if(artikelliste.size() < maxAnzahlArtikel)
		{
			if( bezeichnung != null)
			{
				if(musterBindegruen != null)
				{
					if(bezeichnung.equals(musterBindegruen.getBezeichnung()))
					{
						artikelliste.add(new Bindegruen());
						return true;
					}
				}
				else
				{
					if(bezeichnung.equals(musterBlume.getBezeichnung()))
					{
						artikelliste.add(new Blume(musterBlume.getBezeichnung(), musterBlume.getFarbe(), musterBlume.getTyp()));
						return true;
					}
				}	
			}
		}
		return false;
	}
	

	public void setMaxAnzahlArtikel(int maxAnzahlArtikel)
	{
		this.maxAnzahlArtikel = maxAnzahlArtikel;
	}
	public int getRegalnummer()
	{
		return this.regalnummer;
	}
	public int getMaxAnzahlArtikel()
	{
		return this.maxAnzahlArtikel;
	}
	
}
