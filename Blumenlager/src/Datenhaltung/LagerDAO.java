package Datenhaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Fachlogik.Lagerverwaltung.Lager;
import Fachlogik.Lagerverwaltung.Regal;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class LagerDAO implements ILagerDAO{

	private Connection conn;
	private Regalverwaltung regalverwaltung;
	
	public LagerDAO(Connection c, Regalverwaltung a)
	{
		this.conn = c;
		this.regalverwaltung = a;
	}
	
	
	@Override
	public ArrayList<Lager> laden() throws Exception {
		
		ArrayList<Lager> lagerliste = new ArrayList<Lager>();
		Statement statement = conn.createStatement();
		ResultSet rsLager = statement.executeQuery("select * from Lager");
		
		//Gehe alle Lager durch 
		while(rsLager.next())
		{
			//Für jedes Lager: finde alle Regale; erstelle Liste 
			//füge fertiges Lagerl zu der Regalliste hinzu
			ArrayList<Regal> regale = new ArrayList<Regal>();
			Statement stat2 = conn.createStatement();
			ResultSet rsLagerRegale = stat2.executeQuery("select * from regal where idLager =" + rsLager.getString("idLager"));
			
			while(rsLagerRegale.next())
			{
				//vorhandenes Regal aus Regalliste holen und hinzufügen
				regale.add(regalverwaltung.getRegal(rsLagerRegale.getInt("idRegal")));
			}
			lagerliste.add(new Lager(rsLager.getInt("idLager"),rsLager.getInt("maxAnzahlRegale"), regale));
			
		}
		return lagerliste;
	}

	@Override
	public void speichern(ArrayList<Lager> liste) throws Exception {
		
		Statement statement = conn.createStatement();
		statement.executeUpdate("Delete from lager;");
		for(Lager l: liste){
			
			statement.executeUpdate("insert into lager values("
					+ Integer.toString(l.getId()) + ","
					+ Integer.toString(l.getMaxAnzahlRegale())+ ");");
			
			for(Regal r : l.getRegalListe()){
				Statement stat2 = conn.createStatement();
				stat2.executeUpdate("update regal set idlager= "
						+ Integer.toString(l.getId()) + " where idregal="
						+ Integer.toString(r.getId()));	
			}
		}
		
	}
	
	
}
