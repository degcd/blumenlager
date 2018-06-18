package UI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Hauptmenue extends JFrame{

	private static final long serialVersionUID = -4642355566112266090L;	
	
	private static Hauptmenue hm;
	private Controller controller ;
	
	private Hauptmenue() {

	}
	
	public void createHauptmenue(Controller controller) {
		this.controller = controller;
		hm.setTitle("Blumenlager");
		setSize(600, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel labelPanel = new JPanel();
		JLabel label = new JLabel("Hauptmenü");
		JPanel buttonPanel = new JPanel();
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
				controller.getController().zeigeLagerDetailsView();
			}
		}
		);
		buttonPanel.add(lagerAnzeigen);
		
		JButton speichern = new JButton("Speichern");
		anzeigen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				speichern();
			}
		}
		);
		buttonPanel.add(speichern);	
		
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
	
	public void speichern(){
		controller.getController().speichern();
	}
	
}
