package fr.utt.isi.lo02.menhir.modele.partie;

import java.util.ArrayList;

import fr.utt.isi.lo02.menhir.modele.enumeration.Saison;
import fr.utt.isi.lo02.menhir.modele.enumeration.TypePartie;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;

public class Partie {
	private TypePartie typePartie;
	private Saison saison;
	private ArrayList<Joueur> ordreJeu;
	private int nbJoueur, manche, tour;
	
	public Partie() {
		this.saison=Saison.printemps;
		this.ordreJeu = new ArrayList<Joueur>();
	}
	
	public void ajouterJoueurPartie(Joueur joueur){
		this.ordreJeu.add(joueur);
	}
	
	public void definirOrdreJeu(){
		
	}
	
	
}


