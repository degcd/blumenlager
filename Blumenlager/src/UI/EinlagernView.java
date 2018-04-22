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
	
	public EinlagernView(){
		super("Einlagern");
		setSize(1000, 300);
		setLocationRelativeTo(null);
		baueEinlagernView();
	}
	
	private void baueEinlagernView()
	{
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JLabel header = new JLabel("Wie viele von den jeweiligen Artikeln möchten Sie einlagern?");
		
		JPanel buttonPanel = new JPanel();
		JButton einlagernButton = new JButton("Einlagern");
		JButton hauptmenueButton = new JButton("Hauptmenü");
		buttonPanel.add(einlagernButton);
		buttonPanel.add(hauptmenueButton);
		
		
		JPanel lagerplatzPanel = new JPanel(new GridLayout(6,3, 5, 5));
		
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JLabel("Regalnr. 2"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Tulpe"));
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Tulpe"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Regalnr. 2"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JTextField("0"));
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Tulpe"));
		lagerplatzPanel.add(new JLabel("Regalnr. 1"));
		lagerplatzPanel.add(new JTextField("0"));
//		
//		//LagerplatzPanel
//		JPanel lagerplatzPanel = new JPanel(new GridLayout(2,3));
//		
//		JPanel lagerplatz1 = new JPanel(new GridLayout(3,1));
//		//Box lagerplatz1 = new Box(BoxLayout.Y_AXIS);
//		//Test später erweitern mit Lagerplatzliste
//		lagerplatz1.add(new JLabel("Regalnr. 1"));
//		lagerplatz1.add(new JLabel("Tulpe"));
//		JTextField anzahl1 = new JTextField("0", 3);
//		anzahl1.setLocation(0, 0);
//		
//		JPanel textField1 = new JPanel(new FlowLayout(FlowLayout.LEFT,50,30));
//		//textField1.setSize(50,30 );
//		textField1.add(anzahl1);
//		textField1.setLocation(0, 0);
//		
//		lagerplatz1.add(textField1);
//		
//		
//		lagerplatzPanel.add(lagerplatz1);
////		lagerplatzPanel.add(lagerplatz2)
		
		mainPanel.add("North", header);
		mainPanel.add("Center", lagerplatzPanel);
		mainPanel.add("South",buttonPanel);
		
		this.add(mainPanel);
		this.setVisible(true);
	}

}
