package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Bindegruen;
import Fachlogik.Artikelverwaltung.Blume;
import Fachlogik.Artikelverwaltung.Typ;

public class Regal {

	private static int regalnummer = 1;
	private int maxAnzahlArtikel;
	private Artikel musterArtikel;
	private ArrayList<Artikel> artikelliste;
	
	// Id die sich hochzählt? feste Plätze wenn gelöscht und weiter dann ändert die sich auch ?
	public Regal(int maxAnzahl, Artikel musterArtikel )
	{
		this.regalnummer = regalnummer ++;
		this.maxAnzahlArtikel = maxAnzahl;
	}
	public boolean addeArtikel(String bezeichnung, int anzahl)
	{
		if( bezeichnung != null)
		{
			if(!artikelliste.isEmpty()){
				if(bezeichnung.equals(musterArtikel.getBezeichnung()))
				{
					if(artikelliste.size() < maxAnzahlArtikel)
					{
						if(bezeichnung.equals("Bindegruen"))
						{
							artikelliste.add(new Bindegruen());
							return true;
						}
						else
						{
							artikelliste.add(new Blume(musterArtikel.getBezeichnung(), "dummy", new Typ("dummy", "dummy")));
							return true ;
						}
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
