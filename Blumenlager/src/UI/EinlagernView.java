package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EinlagernView extends JFrame{
	
	
	//�ber Konstruktor Regalliste angeben --> Drei-Schichten-Architektur???
	public EinlagernView(){
		super("Einlagern");
		setSize(1000, 300);
		setLocationRelativeTo(null);
		baueEinlagernView();
	}
	
	private void baueEinlagernView()
	{
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JLabel header = new JLabel("Wie viele von den jeweiligen Artikeln m�chten Sie einlagern?");
		
		JPanel buttonPanel = new JPanel();
		JButton einlagernButton = new JButton("Einlagern");
		JButton hauptmenueButton = new JButton("Hauptmen�");
		buttonPanel.add(einlagernButton);
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

}