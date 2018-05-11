package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class Controller {

	private Artikelverwaltung artikelverwaltung;
	private Regalverwaltung regalverwaltung;
	private Hauptmenue menue;

	
	public Controller(Artikelverwaltung artikelverwaltung, Regalverwaltung regalverwaltung) {
		this.artikelverwaltung = artikelverwaltung;
		this.regalverwaltung = regalverwaltung;
	}

	public void start() {
		
    //Brauchen wir das Ã¼berhaupt?
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			// Look & Feels: Metal, CDE/Motif, Windows, Windows Classic, Nimbus
			if ("Nimbus".equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException 
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
				break;
			}
		}
		menue = new Hauptmenue(this);
		//new HinweisView(ui, "Start der Buchverwaltung!");
	}
  
	public void zeigeEinlagernView()
	{
		EinlagernView einlagernView = new EinlagernView();
	}
	public void zeigeAuslagernView()
	{
		AuslagernView auslagernView = new AuslagernView();
	}
	
	
	
	
//	public HauptmenueListener createMainViewListener() {
//		return new HauptmenueListener();
//	}
//	
//	/**** Listener fürs Haupmenü *********/
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
////					// V6.0 Zustandsänderung jetzt auch für MenuItems
////					//ui.setStateBearbeiten();
////					// V6.0: Wegen integrierter Sicht. 
////					// BuchListeView besitzt eigene Toolbar
////					// Ist jetzt nicht mehr als internes Fenster
////					// realisiert sondern als JPanel
////					//ui.removeTooBar();
////					//listeBearbeiten();
////					break;
////				case "beenden": // V6.0 wegen Menüpunkt beenden
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



