package UI;

import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Lagerverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class Controller {

	private Artikelverwaltung artikelverwaltung;
	private Regalverwaltung regalverwaltung;
	private Lagerverwaltung lagerverwaltung;

	
	public Controller(Artikelverwaltung artikelverwaltung, Regalverwaltung regalverwaltung, Lagerverwaltung lagerverwaltung) {
		this.artikelverwaltung = artikelverwaltung;
		this.regalverwaltung = regalverwaltung;
		this.lagerverwaltung = lagerverwaltung;
	}

	public void start() {
		
		try{
			artikelverwaltung.laden();
		}
		catch(Exception e)
		{
			System.out.println("Artikelverwaltung konnte nicht geladen werden: " + e.getMessage());
		}

		try{
			regalverwaltung.laden();
		}
		catch(Exception e)
		{
			System.out.println("Regalverwaltung konnte nicht geladen werden: " + e.getMessage());
		}
		try{
			lagerverwaltung.laden();
		}
		catch(Exception e)
		{
			System.out.println("Lagerverwaltung konnte nicht geladen werden: " + e.getMessage());
		}
		
		new Hauptmenue(this);

	}
  
	public void zeigeEinlagernView()
	{
		new EinlagernView();
	}
	public void zeigeAuslagernView()
	{
		new AuslagernView();
	}
	
	
	
	
//	public HauptmenueListener createMainViewListener() {
//		return new HauptmenueListener();
//	}
//	
//	/**** Listener f�rs Haupmen� *********/
//	class HauptmenueListener implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String befehl = e.getActionCommand();
//			try {
//				switch (befehl) {
//				case "einlagern":
//					zeigeEinlagernView();
//					new HinweisView(menue, "Daten wurden geladen");
//					//break;
////				case "speichern":
////					//speichern();
////					new HinweisView(menue, "Daten wurden gespeichert");
////					break;
////				case "bearbeiten":
////					// V6.0 Zustands�nderung jetzt auch f�r MenuItems
////					//ui.setStateBearbeiten();
////					// V6.0: Wegen integrierter Sicht. 
////					// BuchListeView besitzt eigene Toolbar
////					// Ist jetzt nicht mehr als internes Fenster
////					// realisiert sondern als JPanel
////					//ui.removeTooBar();
////					//listeBearbeiten();
////					break;
////				case "beenden": // V6.0 wegen Men�punkt beenden
////					ui.dispose();
////					System.exit(0);
////					break;
//				}
//			} //catch (IOException) {
//				//new HinweisView(ui, e1.getMessage());
//			//}
//			finally {
//				
//			}
//		}
//
//			}
	}



