package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class FotoAnzeigeView extends JFrame implements Beobachter{

	private Controller controller;
	private Regalverwaltung regalverwaltung;
	
	public FotoAnzeigeView(Controller controller, Regalverwaltung regalverwaltung) {
		super("Lagerbestand");
		this.controller = controller;
		this.regalverwaltung = regalverwaltung;
		setSize(500, 400);
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
		JPanel fotopanel = new JPanel(new GridLayout());
		panel.add("North", fotopanel);
		
		
		add(panel);
		setVisible(true);
	}
	
	
	
	public void close() {
		this.setVisible(false);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
