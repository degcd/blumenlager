package UI;

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
		
    //Brauchen wir das überhaupt?
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

}
