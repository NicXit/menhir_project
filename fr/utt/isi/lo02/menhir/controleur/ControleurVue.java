package fr.utt.isi.lo02.menhir.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Scanner;

import fr.utt.isi.lo02.menhir.modele.carte.Paquet;
import fr.utt.isi.lo02.menhir.modele.enumeration.Action;
import fr.utt.isi.lo02.menhir.modele.enumeration.Saison;
import fr.utt.isi.lo02.menhir.modele.enumeration.TypePartie;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;
import fr.utt.isi.lo02.menhir.vue.VuePartie;

public class ControleurVue {	
	private Paquet paquet;	
	private Partie p;
	private VuePartie vp;
	
	int valeurJuste = 0, indiceChoix =0, choixAction=1, choixCarte =0, numManche=0, value = 0, valCarte[], valueCarteAllie = 0;
	String nomJoueurGagnant, typePartie;
	char reponseBonusAvancee, choixTypePartie;
	Action[] tabChoixAction = Action.values();
	Saison[] tabSaison = Saison.values();
	
	public ControleurVue(){
		paquet = new Paquet();
		p = new Partie();
		vp = new VuePartie(p, this);
	}
	
	public void paramPartie(int nbJoueursHumain, int nbJoueursIA, boolean rdbtRapide, boolean rdbtAvance){
		if(rdbtRapide) p.setTypePartie(TypePartie.rapide);
		else p.setTypePartie(TypePartie.avancée);
		p.setNbHumains(nbJoueursHumain);
	}
	
	public void ajouterHumain(String nom, String age, String genre){
		int ageInt;
		char genreF;
		ageInt =Integer.parseInt(age);
		if(genre == "masculin") genreF='n';
		else genreF='o';		
		p.ajouterHumain2(nom, ageInt, genreF);
		if (p.listeHumains.size()== p.getNbHumains())
			p.triOrdreJeu();
	}
	
	/**
	 * Méthode qui ajoute les joueurs IA et qui appelle la méthode qui initialise le nombre de manches et pour la partie rapide le 
	 * nombre de graines.
	 * 
	 * @param nom
	 */
	public void ajouterIA(String nom){
		p.ajouterIA2(nom);
		
		if(p.ordreJeu.size() == (p.getNbHumains()+p.getNbIA())){
			if(p.getTypePartie().equals(TypePartie.rapide)){
				p.initGrainesPartieRapide();
				p.setNbManche(1);
			}
			else
				p.setNbManche(p.ordreJeu.size());	
		}			
	}
	
}
