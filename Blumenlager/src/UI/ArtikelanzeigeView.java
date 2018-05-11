package UI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Lagerverwaltung.Regal;

public class ArtikelanzeigeView extends JFrame{

	private DefaultTableModel tabellenModel;
	private JTable artikelTabelle;
	private java.util.List<Artikel> artikelliste;
	private java.util.List<Regal> regalliste;
	private Controller controller;
	
	public ArtikelanzeigeView(Controller controller, java.util.List<Artikel> artikelliste) {
		super("Artikelanzeige");
		this.controller = controller;
		this.artikelliste = artikelliste;
		setSize(500, 500);
		setLocationRelativeTo(null);
		baueArtikelanzeigeView();
		setVisible(true);
	}
	
	private void baueArtikelanzeigeView() {
		JPanel panel = new JPanel(new BorderLayout());
				
		JPanel buttonPanel = new JPanel();
		
		JButton hauptmenueButton = new JButton("Hauptmenü");
		hauptmenueButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				close();
			}
		});
		
		buttonPanel.add(hauptmenueButton);
		panel.add("North",buttonPanel);
		
		JPanel tabellenPanel = new JPanel();
		
		String[] spaltenNamen = {"Regalnummer", "Artikel", "Anzahl"};
		tabellenModel = new DefaultTableModel(spaltenNamen, 0);
		artikelTabelle = new JTable(tabellenModel);
//		artikelTabelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		fuelleTabelle(artikelliste);
		
		
		panel.add("South",tabellenPanel);
		
		add(panel);
		setVisible(true);
	}
	
	
	private void fuelleTabelle(java.util.List<Artikel> artikelliste) {
		Object[] zeile = new Object[3];
		for (Artikel a : artikelliste) {
//			zeile[0] = a.getRegalnummer();
			zeile[1] = a.getBezeichnung();
//			zeile[2] = a.getPreis();
			tabellenModel.addRow(zeile);
		}
	}
	
	
	public void close() {
		this.setVisible(false);
	}
}
