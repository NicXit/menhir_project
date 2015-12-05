package fr.utt.isi.lo02.menhir.modele.strategy;

import java.util.ArrayList;

import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.enumeration.Action;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;

public class RandomStrategy implements Strategy{

	public String jouer(Joueur j, ArrayList<CarteIngredient> cartesIngredient, int saison, Partie p){
		//On choisi une carte au hasard
		int carteRandom = (int) (Math.random()*cartesIngredient.size());
		CarteIngredient c = cartesIngredient.get(carteRandom);
		
		//On choisi une action au hasard
		Action[] actions = Action.values();
		int action = (int)(Math.random()*actions.length);
		int v = c.getValuePrecise(action,saison);
		
		switch(action){
		case 0 :
			j.setNbGraines(j.getNbGraines()+ v);
			j.getCarteIngredientJoueur().remove(carteRandom);
			return new String(j.getNom() + "RANDOMa choisi l'action geant de valeur" + v);
		case 1 :
			j.setNbGraines(j.getNbGraines()- v);
			j.setNbMenhir(j.getNbMenhir()+ v);
			j.getCarteIngredientJoueur().remove(carteRandom);
			return new String(j.getNom() + "RANDOMa choisi l'action engrais de valeur" + v);
		case 2 :
			boolean ok = false;
			do{
				int place = (int)(Math.random()*p.ordreJeu.size());
				Joueur joueur = p.ordreJeu.get(place);
				if (joueur != j){
					if (joueur.getNbGraines() <= v){
						j.setNbGraines(j.getNbGraines()+ joueur.getNbGraines());
						joueur.setNbGraines(0);
						j.getCarteIngredientJoueur().remove(carteRandom);
						ok = true;
						return new String(j.getNom() + "RANDOMa choisi l'action farfadet de valeur" + v);
					}
					else{
						j.setNbGraines(j.getNbGraines()+ v);
						joueur.setNbGraines(joueur.getNbGraines()-v);
						j.getCarteIngredientJoueur().remove(carteRandom);
						ok = true;
						return new String(j.getNom() + "RANDOMa choisi l'action farfadet de valeur" + v);
					}
				}
			}while (ok == false);
			
		}
		
		return new String("");
	}

}