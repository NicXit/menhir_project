package fr.utt.isi.lo02.menhir.modele.joueur;

import fr.utt.isi.lo02.menhir.modele.partie.Partie;

public abstract class Joueur {
	protected int nbMenhir, nbPoints, nbGraines;
	protected String nom;
	protected Partie partie;
	
	public Joueur(String nom, Partie partie){
		this.nom=nom;
		this.partie=partie;
		this.nbMenhir=0;
		this.nbPoints=0;
		this.nbGraines=0;
		
	}
	
	

	
	
}
