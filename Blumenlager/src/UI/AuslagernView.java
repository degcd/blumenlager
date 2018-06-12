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

public class AuslagernView extends JFrame implements Subjekt{

	private static final long serialVersionUID = -4578963789180819752L;
	private ArrayList<JTextField> textfelder;
	private ArrayList<JLabel> regalnummern;
	private Controller controller;
	private ArrayList<Beobachter> beobachterliste = new ArrayList<Beobachter>();

	
	//Ã¼ber Konstruktor Regalliste angeben --> Drei-Schichten-Architektur???
	public AuslagernView(Controller c){
		super("Auslagern");
		this.controller = c;
		setSize(1000, 300);
		setLocationRelativeTo(null);

		registriere(controller.getAktuelleArtikelanzeigeView());
		registriere(controller.getAktuelleFotoAnzeigeView());

		baueAuslagernView();
	}
	
	private void baueAuslagernView()
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
				benachrichtige();
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
		
		JTextField platz1 = new JTextField("0");
		JTextField platz2 = new JTextField("0");
		JTextField platz3 = new JTextField("0");
		JTextField platz4 = new JTextField("0");
		JTextField platz5 = new JTextField("0");
		JTextField platz6 = new JTextField("0");
		textfelder.add(platz1);
		textfelder.add(platz2);
		textfelder.add(platz3);
		textfelder.add(platz4);
		textfelder.add(platz5);
		textfelder.add(platz6);
		
		JLabel regalLabel1 = new JLabel("Regalnummer 1");
		JLabel regalLabel2 = new JLabel("Regalnummer 2");
		JLabel regalLabel3 = new JLabel("Regalnummer 3");
		JLabel regalLabel4 = new JLabel("Regalnummer 4");
		JLabel regalLabel5 = new JLabel("Regalnummer 5");
		JLabel regalLabel6 = new JLabel("Regalnummer 6");
		regalnummern.add(regalLabel1);
		regalnummern.add(regalLabel2);
		regalnummern.add(regalLabel3);
		regalnummern.add(regalLabel4);
		regalnummern.add(regalLabel5);
		regalnummern.add(regalLabel6);
		
		lagerplatzPanel.add(regalLabel1);
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Bindegruen"));
		lagerplatzPanel.add(platz1);
		lagerplatzPanel.add(regalLabel2);
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Tulpe"));
		lagerplatzPanel.add(platz2);
		lagerplatzPanel.add(regalLabel3);
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Lilie"));
		lagerplatzPanel.add(platz3);
		lagerplatzPanel.add(regalLabel4);
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Sonnenblume"));
		lagerplatzPanel.add(platz4);
		lagerplatzPanel.add(regalLabel5);
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Rose"));
		lagerplatzPanel.add(platz5);
		lagerplatzPanel.add(regalLabel6);
		lagerplatzPanel.add(new JLabel("Bezeichnung:" + "Orchidee"));
		lagerplatzPanel.add(platz6);

		
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
		boolean fehler = false;

		for(int i = 0; i < 6; i++)
		{
			try{
				int anzahlArtikel = Integer.parseInt(textfelder.get(i).getText());
				String regalbezeichnung = regalnummern.get(i).getText();
				controller.auslagern(regalbezeichnung, anzahlArtikel);
			}catch(Exception e){
				System.out.println("Probleme beim Auslagern: " + e.getMessage());
				fehler = true;
			}
		}
		if (fehler == false) 
		{
			controller.zeigeAuslagernHinweis();
			close();
		}
		else
		{
			controller.zeigeFehlerAuslagern();
		}

		}
	
	@Override
	public void registriere(Beobachter b) {
		beobachterliste.add(b);		
	}


	@Override
	public void deregistriere(Beobachter b) {
		beobachterliste.remove(b);		
	}

	@Override
	public void benachrichtige() {
		for (Beobachter b : beobachterliste) {
			b.update();
		}		
	}
	
	}


