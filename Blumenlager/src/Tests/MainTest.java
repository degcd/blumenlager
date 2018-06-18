package Tests;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
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


public class MainTest {

	private BlumenlagerDataConnector dc = new BlumenlagerDataConnector();
	private Artikelverwaltung artikelverwaltung = new Artikelverwaltung(new ArtikelDAO(dc.getConnection()));
	private Regalverwaltung regalverwaltung = new Regalverwaltung(new RegalDAO(dc.getConnection(), artikelverwaltung), artikelverwaltung);
	private Lagerverwaltung lagerverwaltung = new Lagerverwaltung(new LagerDAO(dc.getConnection(), regalverwaltung));
	private Controller controller = new Controller(artikelverwaltung, regalverwaltung, lagerverwaltung);
	
	 @BeforeClass
	   public static void create() {
	      // Test-Objekt erschaffen mit den Testwerten (Länge: 10 und Breite: 20)
	      System.out.println("Start!");
	   }
	    
	   @Before
	   public void vor() {
	      // Diese Methode wird vor jedem Testfall ausgeführt
	      System.out.println("vor Test");
	   }
//	    
//	   @Test
//	   public void derTest1() {
//	      // Testfall 1: Prüfung ob Umfangsberechnung stimmt
//	      System.out.println("Test1");
//    
//	   }
//	    
//	   @Test
//	   public void derTest2() throws Exception {
//	      // Testfall 2: Prüfung ob Flächeninhaltsberechnung stimmt
//	      System.out.println("Test2");
//	      int vorher = regalverwaltung.getRegal("Regalnummer1").getArtikelListe().size();
//	      controller.start();  
//	      assertEquals((vorher), regalverwaltung.getRegal("Regalnummer1").getArtikelListe().size());
//	   }
//	    
//	   @After
//	   public void nach() {
//	      // Diese Methode wird nach jedem Testfall ausgeführt z.B. um einen bestimmten Zustand zu erreichen
//	      System.out.println("nach Test");
//	   }
	    
	   @AfterClass
	   public static void delete() {
	      // Diese Methode wird am Ende der Test-Klasse ausgeführt z.B. zum aufräumen oder löschen von Rückständen
	      System.out.println("Test Ende!");
	   }
}
