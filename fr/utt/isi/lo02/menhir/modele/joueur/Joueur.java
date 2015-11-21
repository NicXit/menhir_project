package fr.utt.isi.lo02.menhir.modele.joueur;

import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;

public abstract class Joueur{
	protected int nbMenhir, nbPoints, nbGraines;
	protected String nom;
	private CarteIngredient carteIngredient[] = new CarteIngredient[4];
	private CarteAllie carteAllie;
	
	public Joueur(String nom){
		this.nom=nom;		
		this.nbMenhir=0;
		this.nbPoints=0;
		this.nbGraines=0;
		
	}
	
	public String getNom(){
		return this.nom;
	}

	public CarteIngredient[] getCarteIngredientJoueur(){
		return this.carteIngredient;
	}
	
	public void setCarteIngredientJoueur(CarteIngredient c, int i){
		this.carteIngredient[i] = c;
	}
	
	public CarteAllie getCarteAllieJoueur(){
		return this.carteAllie;
	}
	
	public void setCarteAllieJoueur(CarteAllie c){
		this.carteAllie = c;
	}
	
	
}
