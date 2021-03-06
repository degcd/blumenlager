package UI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Hauptmenue extends JFrame implements ISprachBeobachter{

	/**
	 * Dieses Fenster wird beim Start der Anwendung geladen. Es existiert nur eine Instanz
	 * und bleibt stets offen, auch wenn andere Fenster ge�ffnet werden.
	 * Die Navigation zu den verschiedenen Funktionen erfolgt �ber 6 verschiedene Button.
	 * Beim Schlie�en der Anwendung �ber das x werden die get�tigten �nderungen in der Datenbank gespeichert.
	 */
	
	private static final long serialVersionUID = -4642355566112266090L;	
	
	private static Hauptmenue hm;
	private Controller controller ;
	ResourceBundle bundle;
	JLabel label;
	JButton einlagern;
	JButton auslagern;
	JButton anzeigen;
	JButton lagerAnzeigen;
	JButton speichern;
	JButton sprachauswahl;
	
	//privater Konstruktor zur Umsetzung des Singleton-Musters
	private Hauptmenue() {

	}
	
	public void createHauptmenue(Controller controller) {
		this.controller = controller;
		hm.setTitle("Flower Floor");
		setSize(700, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		bundle = ResourceBundle.getBundle("Bundle_de_DE");
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel labelPanel = new JPanel();
		String str = bundle.getString("HM");
		label = new JLabel(str);
		JPanel buttonPanel = new JPanel();
		
		String str2 = bundle.getString("Ein");
		einlagern = new JButton(str2);
		einlagern.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent evt) {
			controller.getController().zeigeEinlagernView();
		}
		});
		buttonPanel.add(einlagern);

		String str3 = bundle.getString("Aus");
		auslagern = new JButton(str3);
		auslagern.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controller.getController().zeigeAuslagernView();
			}
		});
		buttonPanel.add(auslagern);
		
		String str4 = bundle.getString("show");
		anzeigen = new JButton(str4);
		anzeigen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controller.getController().zeigeArtikelanzeigeView();
			}
		}
		);
		buttonPanel.add(anzeigen);	
		
		String str5 = bundle.getString("show2");
		lagerAnzeigen = new JButton(str5);
		lagerAnzeigen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controller.getController().zeigeLagerDetailsView();
			}
		}
		);
		buttonPanel.add(lagerAnzeigen);
		
		String str6 = bundle.getString("save");
		speichern = new JButton(str6);
		speichern.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				speichern();
			}
		}
		);
		buttonPanel.add(speichern);	
		
		String str7 = bundle.getString("sprache");
		sprachauswahl = new JButton(str7);
		sprachauswahl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				LanguageController.getLanguageController().benachrichtige();
			}
		}
		);
		buttonPanel.add(sprachauswahl);	
		
		labelPanel.add(label);
		panel.add("North", labelPanel);
		panel.add("Center", buttonPanel);
		add(panel);
		setVisible(true);
		LanguageController.getLanguageController().registriere(this);
	}

	//statische Methode um von den anderen Klassen aus Zugriff auf die einzige Instanz zu erhalten
	public static Hauptmenue getInstance() {
		if (hm == null) {
			hm = new Hauptmenue();
		}
		return hm;
	}
	
	/*Methode dient dazu jegliche �nderungen in der Datenbank zu Speichern, nicht erst beim Schlie�en
	 * der Anwendung, es erfolgt eine Weiterleitung an den Controller
	 */
	public void speichern(){
		controller.getController().speichern();
	}

	//die Methode wird bei Sprach�nderung aufgerufen um alle Textelemente zu �ndern
	@Override
	public void spracheAendern() {
		if (LanguageController.getLanguageController().getFlag() == 0) { //auf deutsch �ndern
			bundle = ResourceBundle.getBundle("Bundle_de_DE");
		}
		if (LanguageController.getLanguageController().getFlag() == 1) { //auf englisch �ndern
			bundle = ResourceBundle.getBundle("Bundle_en_GB");
		}
		label.setText(bundle.getString("HM"));
		einlagern.setText(bundle.getString("Ein"));
		auslagern.setText(bundle.getString("Aus"));
		anzeigen.setText(bundle.getString("show"));
		lagerAnzeigen.setText(bundle.getString("show2"));
		speichern.setText(bundle.getString("save"));
		sprachauswahl.setText(bundle.getString("sprache"));
	}
}
