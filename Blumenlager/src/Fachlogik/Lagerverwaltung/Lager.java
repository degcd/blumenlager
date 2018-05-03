package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

public class Lager {

	private int maxAnzahlRegale;
	private ArrayList<Regal> regalListe;
	
	public Lager(int max)
	{
		this.maxAnzahlRegale = max;
		this.regalListe = new ArrayList<Regal>();
	}
	
	public void addeRegal(Regal r)
	{
		if(r != null && regalListe.size() < maxAnzahlRegale)
			regalListe.add(r);
	}
	
	//l�schen Methode machen? wenn ja, wie soll sie aussehen?
	
	
}


