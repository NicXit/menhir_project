package fr.utt.isi.lo02.menhir.vue;

import java.util.Observer;
import javax.swing.JFrame;

import fr.utt.isi.lo02.menhir.controleur.Controleur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;


public class VuePartie implements Observer{	
	private Partie partie;
	private Controleur controleur;
	private JFrame fenetre;
	
	public VuePartie(Partie p, Controleur c){
		this.partie=p;
		this.controleur=c;
		partie.addObserver(this);
		this.InitFenetrePartie();		
	}
	
	public void InitFenetrePartie(){
		fenetre= new JFrame("Partie Menhir");		
		fenetre.setSize(700, 600);		    
		fenetre.setLocationRelativeTo(null);		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	

	
}
