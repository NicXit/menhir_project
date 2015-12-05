package fr.utt.isi.lo02.menhir.modele.strategy;

import java.util.ArrayList;

import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;

public class OffensiveStrategy implements Strategy {
	public String jouer(Joueur j, ArrayList<CarteIngredient> cartesIngredient, int saison, Partie p){
		int vReferenceEngrais = 0;
		int vReferenceFarfadet = 0;
		int numCarteEngrais = 0;
		int numCarteFarfadet = 0;
		int vReferenceJoueur = 0;
		int vReferenceGeant = 0;
		int numCarteGeant = 0;
		int numPos = 0;
		
		//On parcours les cartes pour connaitre la plus haute valeur de l'action engrais
		for (int i = 0; i < cartesIngredient.size(); i++){
			int v = cartesIngredient.get(i).getValuePrecise(2,saison);
			if (vReferenceEngrais < v){
				vReferenceEngrais = v;
				numCarteEngrais = i; 
			}
		}
		
		//On regarde si l'IA dispose de plus de 3 graines et si c'est le cas on joue cette action
		if(j.getNbGraines() >= 3){
			j.setNbGraines(j.getNbGraines()- vReferenceEngrais);
			j.setNbMenhir(j.getNbMenhir()+ vReferenceEngrais);
			j.getCarteIngredientJoueur().remove(numCarteEngrais);
			return new String(j.getNom() + "OFF a choisi l'action engrais de valeur" + vReferenceEngrais);
		}
		//Si l'IA ne dispose pas d'assez de graines, il joue la meilleur carte pour l'action farfadet
		else{
			vReferenceFarfadet = 0;
			numCarteFarfadet = 0;
			for (int i = 0; i < cartesIngredient.size(); i++){
				int v = cartesIngredient.get(i).getValuePrecise(2,saison);
				if (vReferenceFarfadet < v){
					vReferenceFarfadet = v;
					numCarteFarfadet = i; 
				}
			}
			if(vReferenceFarfadet != 0){
				boolean ok = false;
				vReferenceJoueur = 0;
				numPos = 0;
				for (int i = 0; i < p.ordreJeu.size(); i++){
					int v = p.ordreJeu.get(i).getNbGraines();
					if (vReferenceJoueur < v && j != p.ordreJeu.get(i)){
						vReferenceJoueur = v;
						numPos = i; 
					}
				}
					Joueur joueur = p.ordreJeu.get(numPos);
					if (joueur.getNbGraines() >= vReferenceFarfadet){
							j.setNbGraines(j.getNbGraines()+ vReferenceFarfadet);
							joueur.setNbGraines(joueur.getNbGraines()- vReferenceFarfadet);
							j.getCarteIngredientJoueur().remove(numCarteFarfadet);
							return new String(j.getNom() + "OFF a choisi l'action farfadet de valeur " + vReferenceFarfadet + " contre "+ joueur.getNom());
					}
					else{
						j.setNbGraines(j.getNbGraines()+ joueur.getNbGraines());
						joueur.setNbGraines(0);
						j.getCarteIngredientJoueur().remove(numCarteFarfadet);
						return new String(j.getNom() + "OFF a choisi l'action farfadet de valeur " + vReferenceFarfadet+ " contre "+ joueur.getNom());
						}

			
				
			}
			else
			{
				vReferenceGeant = 0;
				numCarteGeant = 0;
				for (int i = 0; i < cartesIngredient.size(); i++){
					int v = cartesIngredient.get(i).getValuePrecise(0,saison);
					if (vReferenceGeant < v){
						vReferenceGeant = v;
						numCarteGeant = i; 
					}
				}
				j.setNbGraines(j.getNbGraines()+ vReferenceGeant);
				j.getCarteIngredientJoueur().remove(numCarteGeant);
				return new String(j.getNom() + "OFF a choisi l'action geant de valeur" + vReferenceGeant);
			}
		}
	}
}

