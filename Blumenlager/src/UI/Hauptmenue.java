package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Fachlogik.Lagerverwaltung.Regal;

import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class Hauptmenue extends JFrame{

	private static final long serialVersionUID = -4642355566112266090L;	
	
	private Controller controller;
	
	private static Hauptmenue hm = new Hauptmenue();
	
	private Hauptmenue() {

	}
	
	public void createHauptmenue(Controller controller) {
		hm.setTitle("Blumenlager");
		setSize(600, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel labelPanel = new JPanel();
		JLabel label = new JLabel("Hauptmenü");
		JPanel buttonPanel = new JPanel();
//		ImageIcon image = new ImageIcon("/Hintergrund.jpg");
//		JLabel hintergrund = new JLabel(image);
//		hintergrund.setSize(600, 150);
//		add(hintergrund);
;		JButton einlagern = new JButton("Einlagern");

		einlagern.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent evt) {
			controller.getController().zeigeEinlagernView();
		}
		});
		buttonPanel.add(einlagern);

		
		JButton auslagern = new JButton("Auslagern");
    
		auslagern.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controller.getController().zeigeAuslagernView();
			}
		});
		buttonPanel.add(auslagern);
		
		
		JButton anzeigen = new JButton("Artikel anzeigen");
		anzeigen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controller.getController().zeigeArtikelanzeigeView();
			}
		}
		);
		buttonPanel.add(anzeigen);	
		
		
		JButton lagerAnzeigen = new JButton("Lager anzeigen");
		lagerAnzeigen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controller.getController().zeigeFotoAnzeigeView();
			}
		}
		);
		buttonPanel.add(lagerAnzeigen);
		
		labelPanel.add(label);
		panel.add("North", labelPanel);
		panel.add("Center", buttonPanel);
		add(panel);
		setVisible(true);
	}
	
		
	public static Hauptmenue getInstance() {
		if (hm == null) {
			hm = new Hauptmenue();
		}
		return hm;
	}
}
