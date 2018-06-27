package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.IDTO;
import DTO.RegalDTO;
import Fachlogik.Lagerverwaltung.IRegalverwaltung;
import Fachlogik.Lagerverwaltung.Regal;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class ArtikelanzeigeView extends JFrame implements IBeobachter, ISprachBeobachter{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4445243356675954599L;
	private DefaultTableModel tabellenModel;
	private JTable artikelTabelle;

	private Regalverwaltung regalverwaltung;	
	private Controller controller;
	ResourceBundle bundle;
	JButton hauptmenueButton;
	
	public ArtikelanzeigeView(Controller controller, IRegalverwaltung regalverwaltung) {
		super();
		this.controller = controller;
		this.regalverwaltung = (Regalverwaltung)regalverwaltung;
		setSize(500, 200);
		setLocationRelativeTo(null);
		if (LanguageController.getLanguageController().getFlag() == 0)
		bundle = ResourceBundle.getBundle("Bundle_de_DE");
		if (LanguageController.getLanguageController().getFlag() == 1)
		bundle = ResourceBundle.getBundle("Bundle_en_GB");
		this.setTitle(bundle.getString("artAnzView"));
		baueArtikelanzeigeView();
		setVisible(true);
		LanguageController.getLanguageController().registriere(this);
	}
	
	private void baueArtikelanzeigeView() {
		JPanel panel = new JPanel(new BorderLayout());
			
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
		zeile[0] = bundle.getString("regal");
		zeile[1] = bundle.getString("art");
		zeile[2] = bundle.getString("anz");
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
	
	@Override 
	public void dispose() {
		super.dispose();
		LanguageController.getLanguageController().deregistriere(this);
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

	@Override
	public void spracheAendern() {
		if (LanguageController.getLanguageController().getFlag() == 0) { //auf deutsch ändern
			bundle = ResourceBundle.getBundle("Bundle_de_DE");
		}
		if (LanguageController.getLanguageController().getFlag() == 1) { //auf englisch ändern
			bundle = ResourceBundle.getBundle("Bundle_en_GB");
		}
		this.setTitle(bundle.getString("artAnzView"));
		hauptmenueButton.setText(bundle.getString("HM"));
		while (tabellenModel.getRowCount() > 0) {
		       tabellenModel.removeRow(0);
		}
		fuelleTabelle();
	}

}
