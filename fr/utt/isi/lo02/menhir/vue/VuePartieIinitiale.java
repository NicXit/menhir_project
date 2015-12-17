package fr.utt.isi.lo02.menhir.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.utt.isi.lo02.menhir.controleur.Controleur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;

public class VuePartieIinitiale extends JFrame implements Observer {
	
	private Partie partie;
	private Controleur controleur;
	private JFrame fenetre;
	private JButton BouttonCommencer = new JButton("Commencer");
	private JPanel container = new JPanel();
	
	public VuePartieIinitiale(Partie p, Controleur c){
		this.partie=p;
		this.controleur=c;
		partie.addObserver(this);
		this.initFenetrePartie();
		this.initPageAccueil();
		this.setVisible(true);
	}
	
	public void initFenetrePartie(){
		this.setTitle("Partie Menhir");		
		this.setSize(700, 600);		    
		this.setLocationRelativeTo(null);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void initPageAccueil(){
		
		FlowLayout f = new FlowLayout();
		container.setLayout(f);
		container.add(BouttonCommencer);
		this.setContentPane(container);
	}
	
	public void InitContentPane(){
		
	}
	
	public void update(Observable arg0, Object arg1){
		
	}
	
}