package Tests;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Datenhaltung.ArtikelDAO;
import Datenhaltung.BlumenlagerDataConnector;
import Datenhaltung.LagerDAO;
import Datenhaltung.RegalDAO;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Lagerverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;
import UI.Controller;
import UI.Hauptmenue;
import org.junit.Assert;


public class MainTest {

       private BlumenlagerDataConnector dc = new BlumenlagerDataConnector();
       private Artikelverwaltung artikelverwaltung;
       private Regalverwaltung regalverwaltung;
       private Lagerverwaltung lagerverwaltung;
       private Controller controller;
       
           
          @Before
          public void vor() {
              dc = new BlumenlagerDataConnector();
              artikelverwaltung = new Artikelverwaltung(new ArtikelDAO(dc.getConnection()));
              regalverwaltung = new Regalverwaltung(new RegalDAO(dc.getConnection(), artikelverwaltung), artikelverwaltung);
              lagerverwaltung = new Lagerverwaltung(new LagerDAO(dc.getConnection(), regalverwaltung));
              controller = new Controller(artikelverwaltung, regalverwaltung, lagerverwaltung);
          }
           
          @Test
          public void derTest1() {
             controller.start();   
             int regalnummer = 1;
             int eingabewert = 5;
             int anzVorher = regalverwaltung.getRegal("Regalnummer "+ Integer.toString(regalnummer)).getArtikelListe().size();

             controller.zeigeEinlagernView();
             controller.getAktuelleEinlagernView().setWertInTextfeld(1, eingabewert);
             controller.getAktuelleEinlagernView().einlagern();
             
             int anzNachher = regalverwaltung.getRegal("Regalnummer "+ Integer.toString(regalnummer)).getArtikelListe().size();
             Assert.assertSame("Ist Einlagerung erfolgreich in Fachlogik übertragen worden?",(anzVorher+eingabewert), anzNachher);
             
             Hauptmenue hauptmenue = controller.getAktuellesHauptmenue();
             hauptmenue.speichern();
             
             Connection conn = dc.getConnection();
         	 int anzArtikelDatenbank = 0;
             try{
          		Statement statement = conn.createStatement();
          		ResultSet rsArtikel = statement.executeQuery("SELECT * FROM blumenlager.artikel a natural join regal r where r.platzbezeichnung = 'Regalnummer "+ Integer.toString(regalnummer) + "';");
          		while(rsArtikel.next())
          		{
          			anzArtikelDatenbank++;
          		}
             }catch(Exception ex){}
             
             Assert.assertSame("Ist Einlagerung erfolgreich in Datenbank übertragen worden?", (anzVorher+eingabewert), anzArtikelDatenbank);

          }
           
}

