package UI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Fachlogik.Lagerverwaltung.Regal;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class FotoAnzeigeView extends JFrame implements Beobachter{

	private Controller controller;
	private Regalverwaltung regalverwaltung;
	
	public FotoAnzeigeView(Controller controller, Regalverwaltung regalverwaltung) {
		super("Lagerbestand");
		this.controller = controller;
		this.regalverwaltung = regalverwaltung;
		setSize(700, 600);
		setLocationRelativeTo(null);
		baueFotoAnzeigeView();
		setVisible(true);
	}
	
	private void baueFotoAnzeigeView() {
		JPanel panel = new JPanel(new BorderLayout());
		
		//Button
		JPanel buttonPanel = new JPanel();	
		JButton hauptmenueButton = new JButton("Hauptmenü");

		hauptmenueButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				close();
			}
		});		
		buttonPanel.add(hauptmenueButton);
		panel.add("South",buttonPanel);
		
		
		//Inhalt
		JPanel fotopanel = new JPanel(new GridLayout(2,3, 150, 130));
		
//		JPanel fotopanel = new JPanel(new GridBagLayout());
		
//		ImageIcon image = new ImageIcon("https://www.google.de/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiZzefu1MbbAhUHLFAKHXpJBKkQjRx6BAgBEAU&url=https%3A%2F%2Fwww.garten-schlueter.de%2Fblumenzwiebeln%2Fherbst-blumenzwiebeln%2Ftulpen%2Ffruehe-tulpen%2Feinfache-fruehe-tulpe-prinses-irene-7-stueck&psig=AOvVaw3gFsSVhpkXjbsY4hxsXp5s&ust=1528636424712508");
//		JLabel label = new JLabel(image);
//		fotopanel.add(label);
		
		ArrayList<Regal> regalliste = new ArrayList<Regal>();
		regalliste = regalListeKlonen(regalverwaltung.getRegalListe());		
		for (Regal r : regalliste) {
			Box neu = new Box(BoxLayout.Y_AXIS);
			//Regalnummer
			JLabel label1 = new JLabel(r.getPlatzbezeichnung());
			neu.add(label1);
			label1.setHorizontalAlignment(JLabel.CENTER);
			neu.add(Box.createVerticalStrut(20));
			//Artikel
			JLabel label2 = new JLabel(r.getArtikelListe().get(0).getBezeichnung(), SwingConstants.CENTER);
			neu.add(label2);
//			neu.add(Box.createVerticalStrut(20));
			String id = "ID: " + Integer.toString(r.getArtikelListe().get(0).getId());
			JLabel label3 = new JLabel(id);
			neu.add(label3);
//			neu.add(Box.createVerticalStrut(20));
			String anzahl = "Anzahl: " + Integer.toString(r.getArtikelListe().size());
			JLabel label5 = new JLabel(anzahl);
			neu.add(label5);
			label5.setHorizontalAlignment(JLabel.CENTER);
//			neu.add(Box.createVerticalStrut(20));
			String verfuegbar = "verfuegbare Plätze: " + Integer.toString(berechneVerfuegbarePlaetze(r), SwingConstants.CENTER);
			JLabel label4 = new JLabel(verfuegbar);
			neu.add(label4);
			fotopanel.add(neu);
		}
		
		panel.add("North", fotopanel);
		
//		validate();
		
		
		add(panel);
		setVisible(true);		
	}
	
	
	public void fuelleInhalt() {

	}
	
	public void close() {
		this.setVisible(false);
	}
	
	public static ArrayList<Regal> regalListeKlonen(ArrayList<Regal> original)
	{
	    ArrayList<Regal> klon = new ArrayList<Regal>(original.size());
	    for (Regal r : original)
	        klon.add(r);
	    return klon;
	}
	
	public int berechneVerfuegbarePlaetze(Regal r) {
		return r.getMaxAnzahlArtikel() - r.getArtikelListe().size();
	}
	
	@Override
	public void update() {

//		panel.remove(fotopanel);
//		validate();
//		fuelleInhalt();		
//		fotopanel = new JPanel(new GridLayout(2,3, 150, 130));
//		panel.add("North", fotopanel);
		
//		JFrame.validate();
//		JFrame.update(JFrame.getGraphics());
	
		
	}
	

}
