package fr.utt.isi.lo02.menhir.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.utt.isi.lo02.menhir.controleur.Controleur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;
import javax.swing.JTextField;

public class VuePartie extends JFrame implements Observer{
	
	private Partie partie;
	private Controleur controleur;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VuePartie(Partie p, Controleur c){
		this.partie=p;
		this.controleur=c;
		partie.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
	}
	
	public void update(Observable arg0, Object arg1){
		
	}

}
