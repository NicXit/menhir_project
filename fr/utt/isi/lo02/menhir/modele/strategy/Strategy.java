package fr.utt.isi.lo02.menhir.modele.strategy;

import java.util.ArrayList;

import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;
/**
 * Interface qui permet de définir la strategy d'un IA
 * @author Mathieu DELALANDE, Nicolas GRANET
 */
public interface Strategy {	
	
	/**
	 * Effectue les actions de l'IA lors d'un tour de jeu
	 * @param j L'IA qui joue
	 * @param cartesIngredient La liste des cartes de l'IA
	 * @param saison La saison en cours
	 * @param p La partie en cours
	 * @return Le détail de ce qu'a joué l'IA
	 */
	public String jouer(Joueur j, ArrayList<CarteIngredient> cartesIngredient, int saison, Partie p);
}

