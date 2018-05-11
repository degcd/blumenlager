package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AuslagernView extends JFrame{

	
	//über Konstruktor Regalliste angeben --> Drei-Schichten-Architektur???
	public AuslagernView(){
		super("Auslagern");
		setSize(1000, 300);
		setLocationRelativeTo(null);
		baueEinlagernView();
	}
	
	private void baueEinlagernView()
	{
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JLabel header = new JLabel("Wie viele von den jeweiligen Artikeln möchten Sie auslagern?");
		
		JPanel buttonPanel = new JPanel();
		JButton auslagernButton = new JButton("Auslagern");
		
		JButton hauptmenueButton = new JButton("Hauptmenü");
		hauptmenueButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				close();
			}
		});
		
		buttonPanel.add(auslagernButton);
		buttonPanel.add(hauptmenueButton);
		
		
		JPanel lagerplatzPanel = new JPanel(new GridLayout(6,3, 5, 5));
		
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Blume1"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Blume2"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Blume3"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Regalnr. 2"));
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Blume4"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Blume5"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Blume6"));
		lagerplatzPanel.add(new JTextField("0"));

		
		mainPanel.add("North", header);
		mainPanel.add("Center", lagerplatzPanel);
		mainPanel.add("South",buttonPanel);
		
		this.add(mainPanel);
		this.setVisible(true);
	}
	
	public void close() {
		this.setVisible(false);
	}
}
