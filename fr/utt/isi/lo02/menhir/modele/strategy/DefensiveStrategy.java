package fr.utt.isi.lo02.menhir.modele.strategy;

import java.util.ArrayList;
import java.util.Iterator;

import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.enumeration.Action;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;
/**
 * Classe qui définie la strategy de jeu d'un IA defensif
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class DefensiveStrategy implements Strategy {	
	/**
	 * Effectue les actions de l'IA lors d'un tour de jeu
	 * @param j L'IA qui joue
	 * @param cartesIngredient La liste des cartes de l'IA
	 * @param saison La saison en cours
	 * @param p La partie en cours
	 */
	public String jouer(Joueur j, ArrayList<CarteIngredient> cartesIngredient, int saison, Partie p){
		int vReference = 0;
		int numCarte = 0;
		
		//On parcours les cartes pour connaitre la plus haute valeur de l'action engrais
		for (int i = 0; i < cartesIngredient.size(); i++){
			int v = cartesIngredient.get(i).getValuePrecise(1,saison);
			if (vReference < v){
				vReference = v;
				numCarte = i; 
			}
		}
		
		//On regarde si l'IA dispose d'assez de graines et si c'est le cas on joue cette action
		if(j.getNbGraines() >= vReference && j.getNbGraines() != 0){
			j.setNbGraines(j.getNbGraines()- vReference);
			j.setNbMenhir(j.getNbMenhir()+ vReference);
			j.getCarteIngredientJoueur().remove(numCarte);
			return new String(j.getNom() + " a choisi l'action engrais de valeur" + vReference);
		}
		//Si l'IA ne dispose pas d'assez de graines, il joue la meilleur carte pour l'action geant
		else{
			vReference = 0;
			numCarte = 0;
			for (int i = 0; i < cartesIngredient.size(); i++){
				int v = cartesIngredient.get(i).getValuePrecise(0,saison);
				if (vReference < v){
					vReference = v;
					numCarte = i; 
				}
			}
			j.setNbGraines(j.getNbGraines()+ vReference);
			j.getCarteIngredientJoueur().remove(numCarte);
			return new String(j.getNom() + " a choisi l'action geant de valeur" + vReference);	
		}
	}
}
