package UI;

import java.util.ArrayList;

public class LanguageController implements ISprachSubjekt{

	/**
	 * Es existiert nur eine Instanz vom LanguageController.
	 * Er dient dazu die registrierten Beobachter, also die aktuell offenen Fenster über eine Sprachänderung zu informieren,
	 * sodass sie ihre Textelemente ändern.
	 */
	
	private static LanguageController lc;
	private static int flag = 0; //Marker der aktuell ausgewählten Sprache (0 = deutsch)
	private ArrayList<ISprachBeobachter> beobachterliste = new ArrayList<ISprachBeobachter>();
	
	//privater Konstruktor zur Umsetzung des Singleton-Musters
	private LanguageController() {
		
	}
	
	//statische Methode um von den anderen Klassen aus Zugriff auf die einzige Instanz zu erhalten
	public static LanguageController getLanguageController() {
		if (lc == null) {
			lc = new LanguageController();
		}
		return lc;
	}
	
	public int getFlag() {
		return flag;
	}

	/*Überschriebene Methoden zur Implementierung von "ISprachSubjekt", sodass alle GUI-Fensterklassen
	 * bei Änderungen der Sprache informiert werden und die Textelemente angepasst werden
	 */
	@Override
	public void registriere(ISprachBeobachter b) {
		beobachterliste.add(b);		
	}

	@Override
	public void deregistriere(ISprachBeobachter b) {
		beobachterliste.remove(b);		
	}

	@Override
	public void benachrichtige() {
		if (flag == 0) {
			flag = 1;
		}
		else {
			flag = 0;
		}
		for (ISprachBeobachter b : beobachterliste) {				
			b.spracheAendern();
		}
	}
}
