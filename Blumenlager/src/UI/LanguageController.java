package UI;

import java.util.ArrayList;

public class LanguageController implements ISprachSubjekt{

	private static LanguageController lc;
	private static int flag = 0; //Deutsch
	private ArrayList<ISprachBeobachter> beobachterliste = new ArrayList<ISprachBeobachter>();
	
	private LanguageController() {
		
	}
	
	public static LanguageController getLanguageController() {
		if (lc == null) {
			lc = new LanguageController();
		}
		return lc;
	}
	
	public int getFlag() {
		return flag;
	}

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
