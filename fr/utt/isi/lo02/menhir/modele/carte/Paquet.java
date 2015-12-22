package fr.utt.isi.lo02.menhir.modele.carte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
/**
 * Classe qui crée les paquets de cartes
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class Paquet {
	public ArrayList<CarteIngredient> cartesIngredient;
	public ArrayList<CarteAllie> cartesAllie;
	
	/**
	 * Constructeur, crée une liste de cartes Ingrédients et une liste de carte Alliés
	 */
	public Paquet() {
		this.cartesIngredient = new ArrayList<CarteIngredient>();
		this.cartesAllie = new ArrayList<CarteAllie>();
	}
	
	/**
	 * Génère le paquet des cartes ingrédients à partir du fichier texte carteIngredient.txt
	 */
	public void genererPaquetIngredient() {
		try
		{
		    File f = new File ("carteIngredient.txt");
		    Scanner scanner = new Scanner (f);
		 
		    String nom[] = new String[3];
		    String nomCarte;
		    
		    while (true)
		    {
		        try
		        {
		        	int valeur[] = new int[12];
		        	for(int i=0;i<3;i++){
		        		nom[i] = scanner.next();
		        	 }
		        	 
		        	 for(int i=0;i<12;i++){
		             	valeur[i] = scanner.nextInt();
		        	 }
		  
		        	 nomCarte = nom[0] + " " + nom[1] + " " + nom[2];
		        	 this.cartesIngredient.add(new CarteIngredient(nomCarte,valeur));
		        }
		        catch (NoSuchElementException exception)
		        {
		            break;
		        }
		    }
		 
		    scanner.close();
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}

	}
	
	
	/**
	 * Génère le paquet des cartes alliés à partir du fichier texte carteAllie.txt
	 */
	public void genererPaquetAllie() {
		try
		{
		    File f = new File ("carteAllie.txt");
		    Scanner scanner = new Scanner (f);
		 
		    String nom[] = new String[3];
		    String nomCarte;
		    
		 
		    while (true)
		    {
		        try
		        {
		        	int valeur[] = new int[4];
		        	for(int i=0;i<3;i++){
		        		nom[i] = scanner.next();
		        	 }
		        	 
		        	 for(int i=0;i<4;i++){
		             	valeur[i] = scanner.nextInt();
		        	 }
		  
		        	 nomCarte = nom[0] + " " + nom[1] + " " + nom[2];
		        	 this.cartesAllie.add(new CarteAllie(nomCarte,valeur));
		        }
		        catch (NoSuchElementException exception)
		        {
		            break;
		        }
		    }
		 
		    scanner.close();
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println ("Le fichier n'a pas été trouvé");
		}

	}
	
	/**
	 * Distribue les cartes ingrédients à chaque joueur de la partie
	 * @param ordreJeu La liste des joueurs de la partie
	 */
	public void distribuerCartesIngredientsJoueur(ArrayList<Joueur> ordreJeu){
		Collections.shuffle(cartesIngredient);		
		for (Iterator<Joueur> it = ordreJeu.iterator(); it.hasNext(); ){
			Joueur j = (Joueur) it.next();
			for (int i=0; i<4; i++){
				j.ajouterCarteIngredientJoueur(cartesIngredient.get(0));
				cartesIngredient.remove(0);
				}
			}
		}
		
	/**
	 * Distribue les cartes alliés au joueur spécifié
	 * @param joueur Le joueur qui reçoit la carte alliés
	 */
	public void distribuerCarteAllieJoueur(Joueur joueur){
		Collections.shuffle(cartesAllie);
		joueur.setCarteAllieJoueur(cartesAllie.remove(0));		
	}

}