package UI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Fachlogik.Lagerverwaltung.Regal;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class ArtikelanzeigeView extends JFrame{

	private DefaultTableModel tabellenModel;
	private JTable artikelTabelle;
	private Regalverwaltung regalverwaltung;
	private ArrayList<Regal> regalliste;
	private Controller controller;
	
	public ArtikelanzeigeView(Controller controller, Regalverwaltung regalverwaltung) {
		super("Artikelanzeige");
		this.controller = controller;
		this.regalverwaltung = regalverwaltung;
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
		fuelleTabelle();
		tabellenPanel.add(artikelTabelle);
		
		panel.add("South",tabellenPanel);
		
		add(panel);
		setVisible(true);
	}
	
	
	private void fuelleTabelle() {
		Object[] zeile = new Object[3];
		for(int i = 1; i <= 5; i++) {
			zeile[0] = 2;
			zeile[1] = 8;
			zeile[2] = 5; 
			tabellenModel.addRow(zeile);
		}
//		Object[] zeile = new Object[3];
//		ArrayList<Artikel> artikelliste = new ArrayList<Artikel>();
//		artikelliste = artikelverwaltung.getArtikelListe();
//		for (Artikel a : artikelliste) {
//			zeile[0] = a.getBezeichnung(); //Regalnummer
//			zeile[1] = a.getBezeichnung();
//			zeile[2] = 5; //Anzahl
//			tabellenModel.addRow(zeile);
//		}
	}
	
	
	public void close() {
		this.setVisible(false);
	}
}
