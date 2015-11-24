package fr.utt.isi.lo02.menhir.modele.joueur;

import java.util.ArrayList;
import java.util.Iterator;

import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;

public abstract class Joueur{
	protected int nbMenhir, nbPoints, nbGraines;
	protected String nom;
	private ArrayList<CarteIngredient> cartesIngredientsJoueur;
	private CarteAllie carteAllie;
	
	public Joueur(String nom){
		this.nom=nom;		
		this.nbMenhir=0;
		this.nbPoints=0;
		this.nbGraines=0;
		this.cartesIngredientsJoueur = new ArrayList<CarteIngredient>();
		
	}
	
	public String getNom(){
		return this.nom;
	}

	public ArrayList<CarteIngredient> getCarteIngredientJoueur(){
		if (this.cartesIngredientsJoueur.isEmpty())
			System.out.println("vide");
		else
			System.out.println("complet");
		return this.cartesIngredientsJoueur;
	}	
	
	public void ajouterCarteIngredientJoueur(CarteIngredient carte){
		cartesIngredientsJoueur.add(carte);		
	}
	
	public void setCarteIngredientJoueur( ArrayList<CarteIngredient> cartesIngredientsJoueur){
		this.cartesIngredientsJoueur = cartesIngredientsJoueur;
		/*for(Iterator<CarteIngredient> it = this.cartesIngredientsJoueur.iterator(); it.hasNext();){
			CarteIngredient carte = (CarteIngredient) it.next();
			System.out.println(carte.toString());
		}
		if (this.cartesIngredientsJoueur.isEmpty())
			System.out.println("vide");
		else
			System.out.println("complet");*/
	}
	
	public CarteAllie getCarteAllieJoueur(){
		return this.carteAllie;
	}
	
	public void setCarteAllieJoueur(CarteAllie c){
		this.carteAllie = c;		
	}
	
	
}
