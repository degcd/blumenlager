package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class EinlagernView extends JFrame implements ISubjekt, ISprachBeobachter{
	
	/**
	 * Ein Fenster, das zur Dokumentation der eingelagerten Mengen dient
	 * �nderungen werden direkt an ArtikelanzeigeView und LagerDetailsView weitergeleitet
	 */
	
	private static final long serialVersionUID = 6676077927159427855L;
	private ArrayList<JTextField> textfelder;
	private ArrayList<JLabel> regalnummern;
	private Controller controller;
	private ArrayList<IBeobachter> beobachterliste = new ArrayList<IBeobachter>();
	ResourceBundle bundle;
	JButton einlagernButton;
	JButton hauptmenueButton;
	JLabel header;
	JLabel regalLabel1;
	JLabel regalLabel2;
	JLabel regalLabel3;
	JLabel regalLabel4;
	JLabel regalLabel5;
	JLabel regalLabel6;
	JLabel bezLabel1;
	JLabel bezLabel2;
	JLabel bezLabel3;
	JLabel bezLabel4;
	JLabel bezLabel5;
	JLabel bezLabel6;
	
	
	public EinlagernView(Controller c){
		super();
		this.controller = c;
		setSize(1000, 300);
		setLocationRelativeTo(null);
		if (LanguageController.getLanguageController().getFlag() == 0)
		bundle = ResourceBundle.getBundle("Bundle_de_DE");
		if (LanguageController.getLanguageController().getFlag() == 1)
		bundle = ResourceBundle.getBundle("Bundle_en_GB");
		this.setTitle(bundle.getString("Ein"));
		if (controller.getAktuelleArtikelanzeigeView() != null) {
			registriere(controller.getAktuelleArtikelanzeigeView());
		}
		if (controller.getAktuelleLagerDetailsView() != null) {
			registriere(controller.getAktuelleLagerDetailsView());
		}
		baueEinlagernView();
		this.setVisible(true);
		LanguageController.getLanguageController().registriere(this);
	}
	
	private void baueEinlagernView()
	{
		textfelder = new ArrayList<JTextField>();
		regalnummern = new ArrayList<JLabel>();
		JPanel mainPanel = new JPanel(new BorderLayout());	
		header = new JLabel(bundle.getString("einFrage"));
		
		//Buttons
		JPanel buttonPanel = new JPanel();
		einlagernButton = new JButton(bundle.getString("Ein"));
		einlagernButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				einlagern();
				benachrichtige();
				for(JTextField j : textfelder)
				{
					j.setText("0");
				}
			}
		});
		hauptmenueButton = new JButton(bundle.getString("HM"));
		hauptmenueButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				deregistriere(controller.getAktuelleArtikelanzeigeView());
				deregistriere(controller.getAktuelleLagerDetailsView());
				close();
			}
		});		
		buttonPanel.add(einlagernButton);
		buttonPanel.add(hauptmenueButton);		
		
		JPanel lagerplatzPanel = new JPanel(new GridLayout(6,3, 5, 5));
		
		//alle Label
		JTextField platz1 = new JTextField("0");
		JTextField platz2 = new JTextField("0");
		JTextField platz3 = new JTextField("0");
		JTextField platz4 = new JTextField("0");
		JTextField platz5 = new JTextField("0");
		JTextField platz6 = new JTextField("0");
		textfelder.add(platz1);
		textfelder.add(platz2);
		textfelder.add(platz3);
		textfelder.add(platz4);
		textfelder.add(platz5);
		textfelder.add(platz6);
		
		regalLabel1 = new JLabel();
		regalLabel2 = new JLabel();
		regalLabel3 = new JLabel();
		regalLabel4 = new JLabel();
		regalLabel5 = new JLabel();
		regalLabel6 = new JLabel();
		bezLabel1 = new JLabel();
		bezLabel2 = new JLabel();
		bezLabel3 = new JLabel();
		bezLabel4 = new JLabel();
		bezLabel5 = new JLabel();
		bezLabel6 = new JLabel();
		fuelleLabels();
		
		regalnummern.add(regalLabel1);
		regalnummern.add(regalLabel2);
		regalnummern.add(regalLabel3);
		regalnummern.add(regalLabel4);
		regalnummern.add(regalLabel5);
		regalnummern.add(regalLabel6);
		
		lagerplatzPanel.add(regalLabel1);
		lagerplatzPanel.add(bezLabel1);
		lagerplatzPanel.add(platz1);
		lagerplatzPanel.add(regalLabel2);
		lagerplatzPanel.add(bezLabel2);
		lagerplatzPanel.add(platz2);
		lagerplatzPanel.add(regalLabel3);
		lagerplatzPanel.add(bezLabel3);
		lagerplatzPanel.add(platz3);
		lagerplatzPanel.add(regalLabel4);
		lagerplatzPanel.add(bezLabel4);
		lagerplatzPanel.add(platz4);
		lagerplatzPanel.add(regalLabel5);
		lagerplatzPanel.add(bezLabel5);
		lagerplatzPanel.add(platz5);
		lagerplatzPanel.add(regalLabel6);
		lagerplatzPanel.add(bezLabel6);
		lagerplatzPanel.add(platz6);
		
		mainPanel.add("North", header);
		mainPanel.add("Center", lagerplatzPanel);
		mainPanel.add("South",buttonPanel);		
		this.add(mainPanel);
	}
	
	
	//Beim Schlie�en des Fensters: Deregistrierung von der Beobachterliste vom LanguageController
	@Override 
	public void dispose() {
		super.dispose();
		LanguageController.getLanguageController().deregistriere(this);
	}

	public void close() {
		this.setVisible(false);
	}
	
	//Hilfmethode f�r den JUnit-Test
	public void setWertInTextfeld(int regalnummer, int wert)
	{
		textfelder.get(regalnummer -1).setText(Integer.toString(wert));
	}
	
	/*zentrale Methode dieser Klasse: entsprechende Werte werden an den Controller weitergeleitet, der die 
	 * weitere Verarbeitung (Regalverwaltung sowie Datenbank) regelt, es wird �ber Erfolg oder Misserfolg in
	 * Form eines Hinweis-Fensters informiert
	 */
	public void einlagern(){
		boolean fehler = false;

		for(int i = 0; i < 6; i++)
		{
			try{
				int anzahlArtikel = Integer.parseInt(textfelder.get(i).getText());
				String regalbezeichnung;
				if (LanguageController.getLanguageController().getFlag() == 1) {
					deutscheLabel();
					regalbezeichnung = regalnummern.get(i).getText();
					controller.einlagern(regalbezeichnung, anzahlArtikel);
					setzeRegalLabel();
				}
				else {
					regalbezeichnung = regalnummern.get(i).getText();
					controller.einlagern(regalbezeichnung, anzahlArtikel);
				}

			}catch(Exception e){
				System.out.println("Probleme beim Einlagern: " + e.getMessage());
				fehler = true;
			}
		}
		if (fehler == false) 
		{
			controller.zeigeEinlagernHinweis();
			close();
		}
		else
		{
			controller.zeigeFehlerEinlagern();
			}
		}

	/*�berschriebene Methoden zur Implementierung von "ISubjekt", sodass ArtikelanzeigeView und LagerDetailsView
	 * bei �nderungen des Bestandes informiert und aktualiesiert werden
	 */
	@Override
	public void registriere(IBeobachter b) {
		beobachterliste.add(b);		
	}

	@Override
	public void deregistriere(IBeobachter b) {
		beobachterliste.remove(b);		
	}

	@Override
	public void benachrichtige() {
		for (IBeobachter b : beobachterliste) {
			b.update();
		}		
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
		this.setTitle(bundle.getString("Ein"));
		header.setText(bundle.getString("einFrage"));
		einlagernButton.setText(bundle.getString("Ein"));
		hauptmenueButton.setText(bundle.getString("HM"));
		fuelleLabels();			
	}
	
	//Hilfsmethoden zur Umsetzung bzw. �nderung der Textelemente bei Wechsel auf eine andere Sprache
	private void setzeRegalLabel() {
		regalLabel1.setText((bundle.getString("regnum") + "1"));	
		regalLabel2.setText((bundle.getString("regnum") + "2"));
		regalLabel3.setText((bundle.getString("regnum") + "3"));
		regalLabel4.setText((bundle.getString("regnum") + "4"));
		regalLabel5.setText((bundle.getString("regnum") + "5"));
		regalLabel6.setText((bundle.getString("regnum") + "6"));
	}
	
	private void fuelleLabels() {
		setzeRegalLabel();
		bezLabel1.setText(bundle.getString("bez") + bundle.getString("bin"));
		bezLabel2.setText(bundle.getString("bez") + bundle.getString("tul"));
		bezLabel3.setText(bundle.getString("bez") + bundle.getString("lil"));
		bezLabel4.setText(bundle.getString("bez") + bundle.getString("son"));
		bezLabel5.setText(bundle.getString("bez") + bundle.getString("ros"));
		bezLabel6.setText(bundle.getString("bez") + bundle.getString("orc"));
	}
	
	private void deutscheLabel() {
		bundle = ResourceBundle.getBundle("Bundle_de_DE");
		setzeRegalLabel();
		bundle = ResourceBundle.getBundle("Bundle_en_GB");
	}
	
	}


