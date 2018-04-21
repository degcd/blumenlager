package UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hauptmenue extends JFrame{

	private Controller controller;
	
	private JLabel label;
	private JButton einlagern;
	private JButton auslagern;
	private JButton anzeigen;
	private JPanel panel;
	
	public Hauptmenue(Controller controller) {
		super("Blumenlager");
		this.controller = controller;
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		JPanel panel = new JPanel();
		JButton einlagern = new JButton("Einlagern");
		JButton auslagern = new JButton("Auslagern");
		JButton anzeigen = new JButton("Artikel anzeigen");
		panel.add(einlagern);
		panel.add(auslagern);
		panel.add(anzeigen);
		add(panel);
		setVisible(true);
	}
}
