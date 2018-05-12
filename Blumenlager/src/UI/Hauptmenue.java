package UI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class Hauptmenue extends JFrame{

	private static final long serialVersionUID = -4642355566112266090L;

	private Controller controller;	
	private Regalverwaltung regalverwaltung;
	
	public Hauptmenue(Controller controller) {
		super("Blumenlager");
		this.controller = controller;
		setSize(500, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel labelPanel = new JPanel();
		JLabel label = new JLabel("Hauptmenü");
		JPanel buttonPanel = new JPanel();
		
		JButton einlagern = new JButton("Einlagern");

		einlagern.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent evt) {
			controller.zeigeEinlagernView();
		}
		});
		buttonPanel.add(einlagern);

		
		JButton auslagern = new JButton("Auslagern");
    
		auslagern.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				controller.zeigeAuslagernView();
			}
		});
		buttonPanel.add(auslagern);
		
		
		JButton anzeigen = new JButton("Artikel anzeigen");
//		ClickMouseListener clickArtikel = new ClickMouseListener();
		anzeigen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				ArtikelanzeigeView anzeigeView = new ArtikelanzeigeView(controller, regalverwaltung);
//				anzeigeView.setLocationRelativeTo(Hauptmenue.this);
				anzeigeView.setVisible(true);
			}
		}
		);
		buttonPanel.add(anzeigen);		
		
		labelPanel.add(label);
		panel.add("North", labelPanel);
		panel.add("Center", buttonPanel);
		add(panel);
		setVisible(true);
	}
}
