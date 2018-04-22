package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

public class Lager {

	private ArrayList<Regal> regalListe;
	
	public Lager()
	{
		this.regalListe = new ArrayList<Regal>();
	}
	
	public void addeRegal(Regal r)
	{
		if(r != null)
			regalListe.add(r);
	}
	
	//löschen Methode ? wenn ja, wie soll sie aussehen?
	
	
}

