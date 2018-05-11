package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Fachlogik.Artikelverwaltung.Artikel;

public class Hauptmenue extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4642355566112266090L;

	private Controller controller;	
	private java.util.List<Artikel> artikelliste;
	
	public Hauptmenue(Controller controller) {
		super("Blumenlager");
		this.controller = controller;
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		JPanel panel = new JPanel();
		
		JButton einlagern = new JButton("Einlagern");
//		ClickMouseListener clickEinlagern = new ClickMouseListener();
		einlagern.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent evt) {
			EinlagernView einlagernView = new EinlagernView();
//			einlagernView.setLocationRelativeTo(Hauptmenue.this);
			einlagernView.setVisible(true);
		}
		});
		panel.add(einlagern);

		
		JButton auslagern = new JButton("Auslagern");
//		ClickMouseListener clickAuslagern = new ClickMouseListener();
		auslagern.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				AuslagernView auslagernView = new AuslagernView();
//				auslagernView.setLocationRelativeTo(Hauptmenue.this);
				auslagernView.setVisible(true);
			}
		});
		panel.add(auslagern);
		
		
		JButton anzeigen = new JButton("Artikel anzeigen");
//		ClickMouseListener clickArtikel = new ClickMouseListener();
		anzeigen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				ArtikelanzeigeView anzeigeView = new ArtikelanzeigeView(controller, artikelliste);
//				anzeigeView.setLocationRelativeTo(Hauptmenue.this);
				anzeigeView.setVisible(true);
			}
		}
		);
		panel.add(anzeigen);		
		
		add(panel);
		setVisible(true);
	}
}
