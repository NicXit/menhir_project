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
	
	/**
	 * méthode pour afficher les cartes ingrédients d'un joueur
	 * 
	public String afficherCarteIngredientJoueur(CarteIngredient[]){	
		
			return (nom+"\n"+"G : "+value[0]+" "+value[1]+" "+value[2]+" "+value[3]
					+"\n"+"E : "+value[4]+" "+value[5]+" "+value[6]+" "+value[7]+"\n"
					+"F : "+value[8]+" "+value[9]+" "+value[10]+" "+value[11]+"\n");
	}*/
	
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
