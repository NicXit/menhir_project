package fr.utt.isi.lo02.menhir.modele.joueur;

import fr.utt.isi.lo02.menhir.modele.strategy.*;


public class IA extends Joueur{
	private Strategy strategy;
	
	public IA(String nom){	
		super(nom);
		this.strategy=choisirStrategy();
		
	}
	
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
