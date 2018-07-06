package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Fachlogik.Lagerverwaltung.IRegalverwaltung;
import Fachlogik.Lagerverwaltung.Regal;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class LagerDetailsView extends JFrame implements IBeobachter, ISprachBeobachter{

	/**
	 * Dient als "Detailseite" des Lagers
	 * Zeigt ein Fenster mit mit Gridlayout, zu jedem Regal werden folgende Informationen angezeigt:
	 * Bezeichnung des Artikels, Artikel-ID, Anzahl eingelagerte Artikel bzw. "belegte Pl‰tze" sowie die Anzahl freier Pl‰tze
	 */
	private static final long serialVersionUID = -1629380597610753797L;
	private Controller controller;
	private Regalverwaltung regalverwaltung;
	ResourceBundle bundle;
	JPanel panel;
	JPanel gridpanel;
	JButton hauptmenueButton;
	
	public LagerDetailsView(Controller controller, IRegalverwaltung regalverwaltung) {
		super();
		this.controller = controller;
		this.regalverwaltung = (Regalverwaltung)regalverwaltung;
		setSize(700, 500);
		setLocationRelativeTo(null);
		if (LanguageController.getLanguageController().getFlag() == 0)
		bundle = ResourceBundle.getBundle("Bundle_de_DE");
		if (LanguageController.getLanguageController().getFlag() == 1)
		bundle = ResourceBundle.getBundle("Bundle_en_GB");
		this.setTitle(bundle.getString("lagerView"));
		
		panel = new JPanel(new BorderLayout());
		
		//Button
		JPanel buttonPanel = new JPanel();	
		hauptmenueButton = new JButton(bundle.getString("HM"));

		hauptmenueButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				close();
			}
		});		
		buttonPanel.add(hauptmenueButton);
		panel.add("South",buttonPanel);
		
		gridpanel = new JPanel(new GridLayout(2,3, 150, 130));
		erstelleGrid();
		setVisible(true);
		LanguageController.getLanguageController().registriere(this);
	}

	
	private void erstelleGrid() {
		ArrayList<Regal> regalliste = new ArrayList<Regal>();
		regalliste = regalListeKlonen(regalverwaltung.getRegalListe());		
		for (Regal r : regalliste) {
			Box neu = new Box(BoxLayout.Y_AXIS);
			//Regalnummer
			JLabel label1 = new JLabel(r.getPlatzbezeichnung());
			neu.add(label1);
			neu.add(Box.createVerticalStrut(20));
			//Artikel
			JLabel label2 = new JLabel(r.getArtikelListe().get(0).getBezeichnung());
			neu.add(label2);
			String id = bundle.getString("artID") + Integer.toString(r.getArtikelListe().get(0).getId());
			JLabel label3 = new JLabel(id);
			neu.add(label3);
			//belegte und freie Pl‰tze
			String anzahl = bundle.getString("anz2") + Integer.toString(r.getArtikelListe().size());
			JLabel label4 = new JLabel(anzahl);
			neu.add(label4);
			String verfuegbar = bundle.getString("verplae") + Integer.toString(berechneVerfuegbarePlaetze(r));
			JLabel label5 = new JLabel(verfuegbar);
			neu.add(label5);
			gridpanel.add(neu);
		}
		
		panel.add("North", gridpanel);				
		add(panel);		
	}

	//Beim Schlieﬂen des Fensters: Deregistrierung von der Beobachterliste vom LanguageController
	@Override 
	public void dispose() {
		super.dispose();
		LanguageController.getLanguageController().deregistriere(this);
	}
	
	public void close() {
		this.setVisible(false);
	}
	
	//Klonen der aktuellen Regalliste von der Regalverwaltung
	public static ArrayList<Regal> regalListeKlonen(ArrayList<Regal> original)
	{
	    ArrayList<Regal> klon = new ArrayList<Regal>(original.size());
	    for (Regal r : original)
	        klon.add(r);
	    return klon;
	}
	
	//Hilfsmethode zur Berechnung der freien Lagerplatzanzahl pro Regal
	public int berechneVerfuegbarePlaetze(Regal r) {
		return r.getMaxAnzahlArtikel() - r.getArtikelListe().size();
	}
	
	//die Methode wird aufgerufen, sobald Artikel ein- oder ausgelagert werden, sodass die Anzeige direkt aktualisiert wird
	@Override
	public void update() {		
		gridpanel.removeAll();
		erstelleGrid();
	}

	//die Methode wird bei Sprach‰nderung aufgerufen um alle Textelemente zu ‰ndern
	@Override
	public void spracheAendern() {
		gridpanel.removeAll();
		if (LanguageController.getLanguageController().getFlag() == 0) { //auf deutsch ‰ndern
			bundle = ResourceBundle.getBundle("Bundle_de_DE");
		}
		if (LanguageController.getLanguageController().getFlag() == 1) { //auf englisch ‰ndern
			bundle = ResourceBundle.getBundle("Bundle_en_GB");
		}
		this.setTitle(bundle.getString("lagerView"));
		hauptmenueButton.setText(bundle.getString("HM"));
		erstelleGrid();
	}
	

}
