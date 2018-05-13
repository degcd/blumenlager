package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Regal;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class ArtikelanzeigeView extends JFrame{

	private DefaultTableModel tabellenModel;
	private JTable artikelTabelle;
	private Regalverwaltung regalverwaltung;
	private Artikelverwaltung artikelverwaltung;	
	private Controller controller;
	
	public ArtikelanzeigeView(Controller controller, Regalverwaltung regalverwaltung, Artikelverwaltung artikelverwaltung) {
		super("Artikelanzeige");
		this.controller = controller;
		this.regalverwaltung = regalverwaltung;
		this.artikelverwaltung = artikelverwaltung;
		setSize(500, 500);
		setLocationRelativeTo(null);
		baueArtikelanzeigeView();
		setVisible(true);
	}
	
	private void baueArtikelanzeigeView() {
		JPanel panel = new JPanel(new BorderLayout());
			
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
		
		
		//Tabelle
		JPanel tabellenPanel = new JPanel();		
		String[] spaltenNamen = {"Regalnummer", "Artikelnummer", "Artikel", "Anzahl"};
		tabellenModel = new DefaultTableModel(spaltenNamen, 0);
		artikelTabelle = new JTable(tabellenModel);
		artikelTabelle.setPreferredSize(new Dimension(450, 400));		
		//artikelTabelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fuelleTabelle();
		tabellenPanel.add(artikelTabelle);		
		panel.add("North",tabellenPanel);
		
		add(panel);
		setVisible(true);
	}
	
	
	
	private void fuelleTabelle() {
		Object[] zeile = new Object[4];
		//Tabellenkopf
		zeile[0] = "Regalnummer";
		zeile[1] = "Artikelnummer";
		zeile[2] = "Artikel";
		zeile[3] = "Anzahl";
		tabellenModel.addRow(zeile);
	
		//Tabelleninhalt
		ArrayList<Regal> regalliste = new ArrayList<Regal>();
		regalliste = regalListeKlonen(regalverwaltung.getRegalListe());		
		for (Regal r : regalliste) {
			int anzahl = r.getArtikelListe().size();
			for (int i = 0; i < anzahl; i++) {
				zeile[0] = r.getId();
				zeile[1] = r.getArtikelListe().get(i).getId();
				zeile[2] = r.getArtikelListe().get(i).getBezeichnung();
				zeile[3] = r.getArtikelListe().size();
				tabellenModel.addRow(zeile);
			}
		}
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
	
	public static ArrayList<Artikel> artikelListeKlonen(ArrayList<Artikel> original)
	{
	    ArrayList<Artikel> klon = new ArrayList<Artikel>(original.size());
	    for (Artikel a : original)
	        klon.add(a);
	    return klon;
	}
}
