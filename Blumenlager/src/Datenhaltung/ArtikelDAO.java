package Datenhaltung;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Bindegruen;
import Fachlogik.Artikelverwaltung.Blume;
import Fachlogik.Artikelverwaltung.Typ;

public class ArtikelDAO implements IArtikelDAO{

	private Connection conn;
	
	public ArtikelDAO(Connection c)
	{
		this.conn = c;
	}
	
	@Override
	public ArrayList<Artikel> laden() throws Exception {
		
		ArrayList<Artikel> list = new ArrayList<Artikel>();
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("select * from artikel");
		while(result.next())
		{
			String kategorie = result.getString("kategorie");
			
			if(kategorie.equals("Blume"))
			{
				list.add(new Blume(Integer.parseInt(result.getString("idartikel")),
									result.getString("bezeichnung"),
									result.getString("farbe"),
									new Typ(result.getString("gattung"),result.getString("familie"))));
			}
			else if (kategorie.equals("Bindegruen"))
			{
				list.add(new Bindegruen(Integer.parseInt(result.getString("idartikel")),
						result.getString("bezeichnung")));
			}
		}
		
		return list;
	}

	@Override
	public void speichern(ArrayList<Artikel> liste) throws Exception {
		Statement statement = conn.createStatement();
		statement.executeUpdate("DELETE from artikel");
		for(Artikel a : liste)
		{
			if(a.getKategorie().equals("Blume"))
			{
				Blume b = (Blume)a;
				statement.executeUpdate("insert into artikel values("
						+ Integer.toString(b.getId()) + ","
						+ "'"+ b.getBezeichnung()+"',"
						+ "'" + b.getKategorie()+ "'," 
						+ "'" + b.getFarbe() + "',"
						+ "'" + b.getTyp().getGattung()+ "',"
						+ "'" + b.getTyp().getFamilie() + "',"
								+ "null)");
			}
			else if( a.getKategorie().equals("Bindegruen"))
			{
				Bindegruen b = (Bindegruen)a;
				statement.executeUpdate("insert into artikel values("
						+ Integer.toString(b.getId()) + ","
						+ "'"+ b.getBezeichnung()+"',"
						+ "'" + b.getKategorie()+ "', null, null, null,null);");

			}
			
		}
		

		
		
	}

}
