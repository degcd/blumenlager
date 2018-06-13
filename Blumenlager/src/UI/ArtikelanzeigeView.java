package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import DTO.IDTO;
import DTO.RegalDTO;
import Fachlogik.Lagerverwaltung.Regal;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class ArtikelanzeigeView extends JFrame implements IBeobachter{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4445243356675954599L;
	private DefaultTableModel tabellenModel;
	private JTable artikelTabelle;

	private Regalverwaltung regalverwaltung;	
	private Controller controller;
	
	public ArtikelanzeigeView(Controller controller, IDTO regaldto) {
		super("Artikelanzeige");
		this.controller = controller;
		RegalDTO dto= (RegalDTO) regaldto;
		this.regalverwaltung = new Regalverwaltung(dto.getDAO(), dto.getListe(), dto.getArtikelverwaltung());
		setSize(500, 200);
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
		String[] spaltenNamen = {"Regal", "Artikel", "Anzahl"};
		tabellenModel = new DefaultTableModel(spaltenNamen, 0);
		artikelTabelle = new JTable(tabellenModel);
		artikelTabelle.setPreferredSize(new Dimension(420, 300));		
		fuelleTabelle();
		tabellenPanel.add(artikelTabelle);		
		panel.add("North",tabellenPanel);
		
		add(panel);
		setVisible(true);
	}
	
	
	
	private void fuelleTabelle() {
		Object[] zeile = new Object[3];
		//Tabellenkopf
		zeile[0] = "Regal";
		zeile[1] = "Artikel";
		zeile[2] = "Anzahl";
		tabellenModel.addRow(zeile);
	
		//Tabelleninhalt
		ArrayList<Regal> regalliste = new ArrayList<Regal>();
		regalliste = regalListeKlonen(regalverwaltung.getRegalListe());		
		for (Regal r : regalliste) {
				zeile[0] = r.getPlatzbezeichnung();
				zeile[1] = r.getArtikelListe().get(0).getBezeichnung();
				zeile[2] = r.getArtikelListe().size();
				tabellenModel.addRow(zeile);
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

	@Override
	public void update() {
		while (tabellenModel.getRowCount() > 0) {
		       tabellenModel.removeRow(0);
		}
		fuelleTabelle();
	}
}
