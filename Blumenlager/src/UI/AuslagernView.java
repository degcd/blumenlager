package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AuslagernView extends JFrame{

	private ArrayList<JTextField> textfelder;
	private ArrayList<JLabel> regalnummern;
	private Controller controller;
	
	
	//über Konstruktor Regalliste angeben --> Drei-Schichten-Architektur???
	public AuslagernView(Controller c){
		super("Auslagern");
		this.controller = c;
		setSize(1000, 300);
		setLocationRelativeTo(null);
		baueEinlagernView();
	}
	
	private void baueEinlagernView()
	{
		textfelder = new ArrayList<JTextField>();
		regalnummern = new ArrayList<JLabel>();
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JLabel header = new JLabel("Wie viele von den jeweiligen Artikeln möchten Sie auslagern?(mind. 1 Artikel muss noch im Regal bleiben)");
		
		JPanel buttonPanel = new JPanel();
		JButton auslagernButton = new JButton("Auslagern");
		auslagernButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				auslagern();
				for(JTextField j : textfelder)
				{
					j.setText("0");
				}
			}
		});
		
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
	
	public void auslagern(){
		for(int i = 0; i < 6; i++)
		{
			try{
				int anzahlArtikel = Integer.parseInt(textfelder.get(i).getText());
				String regalbezeichnung = regalnummern.get(i).getText();
				controller.einlagern(regalbezeichnung, anzahlArtikel);
			}catch(Exception e){
				System.out.println("Probleme beim Einlagern: " + e.getMessage());
			}

		}
	}
}
