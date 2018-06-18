package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DTO.IDTO;
import DTO.RegalDTO;
import Fachlogik.Lagerverwaltung.Regal;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class LagerDetailsView extends JFrame implements IBeobachter{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1629380597610753797L;
	private Controller controller;
	private Regalverwaltung regalverwaltung;
	JPanel panel;
	JPanel gridpanel;
	
	public LagerDetailsView(Controller controller, IDTO regaldto) {
		super("Lagerbestand");
		this.controller = controller;
		RegalDTO dto= (RegalDTO) regaldto;
		this.regalverwaltung = new Regalverwaltung(dto.getDAO(), dto.getListe(), dto.getArtikelverwaltung());
		setSize(700, 500);
		setLocationRelativeTo(null);
		
		panel = new JPanel(new BorderLayout());
		
		//Button
		JPanel buttonPanel = new JPanel();	
		JButton hauptmenueButton = new JButton("Hauptmenü");

		hauptmenueButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				close();
			}
		});		
		buttonPanel.add(hauptmenueButton);
		panel.add("South",buttonPanel);
		
		gridpanel = new JPanel(new GridLayout(2,3, 150, 130));
		erstelleGrid();
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
			String id = "Artikel-ID: " + Integer.toString(r.getArtikelListe().get(0).getId());
			JLabel label3 = new JLabel(id);
			neu.add(label3);
			//belegte und freie Plätze
			String anzahl = "Anzahl: " + Integer.toString(r.getArtikelListe().size());
			JLabel label4 = new JLabel(anzahl);
			neu.add(label4);
			String verfuegbar = "verfügbare Plätze: " + Integer.toString(berechneVerfuegbarePlaetze(r));
			JLabel label5 = new JLabel(verfuegbar);
			neu.add(label5);
			gridpanel.add(neu);
		}
		
		panel.add("North", gridpanel);
				
		add(panel);		
		setVisible(true);
	}

	
	public void close() {
		this.setVisible(false);
	}
	
	public static ArrayList<Regal> regalListeKlonen(ArrayList<Regal> original)
	{
	    ArrayList<Regal> klon = new ArrayList<Regal>(original.size());
	    for (Regal r : original)
	        klon.add(r);
	    return klon;
	}
	
	public int berechneVerfuegbarePlaetze(Regal r) {
		return r.getMaxAnzahlArtikel() - r.getArtikelListe().size();
	}
	
	@Override
	public void update() {		
		gridpanel.removeAll();
		erstelleGrid();
	}
	

}
