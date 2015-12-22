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
 * Classe qui cr�e les paquets de cartes
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class Paquet {
	public ArrayList<CarteIngredient> cartesIngredient;
	public ArrayList<CarteAllie> cartesAllie;
	
	/**
	 * Constructeur, cr�e une liste de cartes Ingr�dients et une liste de carte Alli�s
	 */
	public Paquet() {
		this.cartesIngredient = new ArrayList<CarteIngredient>();
		this.cartesAllie = new ArrayList<CarteAllie>();
	}
	
	/**
	 * G�n�re le paquet des cartes ingr�dients � partir du fichier texte carteIngredient.txt
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
		    System.out.println ("Le fichier n'a pas �t� trouv�");
		}

	}
	
	
	/**
	 * G�n�re le paquet des cartes alli�s � partir du fichier texte carteAllie.txt
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
		    System.out.println ("Le fichier n'a pas �t� trouv�");
		}

	}
	
	/**
	 * Distribue les cartes ingr�dients � chaque joueur de la partie
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
	 * Distribue les cartes alli�s au joueur sp�cifi�
	 * @param joueur Le joueur qui re�oit la carte alli�s
	 */
	public void distribuerCarteAllieJoueur(Joueur joueur){
		Collections.shuffle(cartesAllie);
		joueur.setCarteAllieJoueur(cartesAllie.remove(0));		
	}

}