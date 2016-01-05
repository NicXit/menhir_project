package fr.utt.isi.lo02.menhir.modele.joueur;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
/**
 * Classe qui définit les caractéristiques d'un joueur.
 * @author Mathieu DELALANDE, Nicolas GRANET
 */
public abstract class Joueur{
	private int nbMenhir, nbPoints, nbGraines;
	protected String nom;
	private ArrayList<CarteIngredient> cartesIngredientsJoueur;
	private CarteAllie carteAllie;
	
	/**
	 * Constructeur, définit un nom au joueur, initialise une liste pour ses cartes ingrédients et initialise son nombre de points, son nombre de
	 * menhirs et son nombre de graines à 0.
	 * @param nom Le nom du joueur
	 */
	public Joueur(String nom){
		this.nom=nom;		
		this.nbMenhir=0;
		this.nbPoints=0;
		this.nbGraines=0;
		this.cartesIngredientsJoueur = new ArrayList<CarteIngredient>();
		
	}
	
	public static Comparator<Joueur> comparatorScore = new Comparator<Joueur>(){
		 public int compare(Joueur j1, Joueur j2) {
               return j1.compareTo(j2);
           }};
	
   /**
    * Trie les joueurs en fonction de leur nombre de menhirs puis de leur nombre de graines
    * @param autreJoueur Le joueur à comparer
    * @return L'ordre du joueur
    */
	public int compareTo(Joueur autreJoueur)
	   {
	      int resultat = 0;
	      if (autreJoueur.nbPoints == this.nbPoints){
		      if (autreJoueur.nbMenhir == this.nbMenhir){
		    	  if(this.nbGraines < autreJoueur.nbGraines)
		    		  resultat = 1;
		    	  if(this.nbGraines > autreJoueur.nbGraines)
		    		  resultat = -1;
		    	  if(this.nbGraines == autreJoueur.nbGraines)
		    		  resultat = 0;
		      }
		      if (this.nbMenhir < autreJoueur.nbMenhir)
		    	  resultat = 1;
		      if (this.nbMenhir > autreJoueur.nbMenhir)
		    	  resultat = -1;
	      }
	      if (this.nbPoints < autreJoueur.nbPoints)
	    	  resultat = 1;
	      
	      if (this.nbPoints > autreJoueur.nbPoints)
	    	  resultat = -1;
	      
	      return resultat;
	   }
	
	public String getNom(){
		return this.nom;
	}

	public ArrayList<CarteIngredient> getCarteIngredientJoueur(){
		return this.cartesIngredientsJoueur;
	}		
	
	public void ajouterCarteIngredientJoueur(CarteIngredient carte){
		cartesIngredientsJoueur.add(carte);	
	}
	
	public CarteAllie getCarteAllieJoueur(){
		return this.carteAllie;
	}
	
	public void setCarteAllieJoueur(CarteAllie c){
		this.carteAllie = c;		
	}
	
	public int getNbGraines(){
		return this.nbGraines;
	}
	
	public void setNbGraines(int nbGraines){
		this.nbGraines = nbGraines;
	}
	
	public int getNbMenhir(){
		return this.nbMenhir;
	}
	public void setNbMenhir(int nbMenhir){
		this.nbMenhir=nbMenhir;
	}
	
	public int getNbPoints(){
		return this.nbPoints;
	}
	public void setNbPoints(int nbPoints){
		this.nbPoints=nbPoints;
	}
	
	
}
