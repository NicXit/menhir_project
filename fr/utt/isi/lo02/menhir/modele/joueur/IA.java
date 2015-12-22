package fr.utt.isi.lo02.menhir.modele.joueur;

import fr.utt.isi.lo02.menhir.modele.strategy.*;

/**
 * Classe qui définit un joueur iA
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class IA extends Joueur{
	private Strategy strategy;
	
	/**
	 * Constructeur, définit un joueur IA par son nom et sa stratégie.
	 * @param nom Le nom du joueur
	 */
	public IA(String nom){	
		super(nom);
		this.strategy=choisirStrategy();
		
	}

	public Strategy getStrategy(){
		return this.strategy;
	}
	
	/**
	 * Choisie aléatoirement une stratégie.
	 * @return La stratégie choisie.
	 */
	private Strategy choisirStrategy(){
		double a = Math.random();
		if (a<=0.33)
			return new DefensiveStrategy();
		else if (0.33<a && a<=0.66)
			return new OffensiveStrategy();
		else
			return new RandomStrategy();
	}
}
