package fr.utt.isi.lo02.menhir.modele.joueur;

import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;

public abstract class Joueur{
	protected int nbMenhir, nbPoints, nbGraines;
	protected String nom;
	public CarteIngredient carteIngredient[] = new CarteIngredient[4];

	
	public Joueur(String nom){
		this.nom=nom;		
		this.nbMenhir=0;
		this.nbPoints=0;
		this.nbGraines=0;
		
	}
	
	public String getNom(){
		return this.nom;
	}

	
	
}
