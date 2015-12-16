package fr.utt.isi.lo02.menhir.modele.strategy;

import java.util.ArrayList;

import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;

public interface Strategy {	
	public String jouer(Joueur j, ArrayList<CarteIngredient> cartesIngredient, int saison, Partie p);
}

