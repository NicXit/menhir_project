package fr.utt.isi.lo02.menhir.modele.carte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;

public class Paquet {
	public ArrayList<CarteIngredient> cartesIngredient;
	public ArrayList<CarteAllie> cartesAllie;
	
	public Paquet() {
		this.cartesIngredient = new ArrayList<CarteIngredient>();
		this.cartesAllie = new ArrayList<CarteAllie>();
	}
	
	
	public void genererPaquetIngredient() {
		try
		{
		    File f = new File ("carteIngredient.txt");
		    Scanner scanner = new Scanner (f);
		 
		    String nom[] = new String[3];
		    String nomCarte;
		    int valeur[] = new int[12];
		 
		    while (true)
		    {
		        try
		        {
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
	
	
	
	public void genererPaquetAllie() {
		try
		{
		    File f = new File ("carteAllie.txt");
		    Scanner scanner = new Scanner (f);
		 
		    String nom[] = new String[3];
		    String nomCarte;
		    int valeur[] = new int[4];
		 
		    while (true)
		    {
		        try
		        {
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
	
	public void distribuerCartesIngredientsJoueur(ArrayList<Joueur> ordreJeu){
		Collections.shuffle(cartesIngredient);
		for (Iterator<Joueur> it = ordreJeu.iterator(); it.hasNext(); ){
			Joueur j = (Joueur) it.next();
			for (int i=0; i<4; i++)
				j.setCarteIngredientJoueur(cartesIngredient.get(i),i);
			}
		}
		
	public void distribuerCarteAllieJoueur(Joueur joueur){
		Collections.shuffle(cartesAllie);
		joueur.setCarteAllieJoueur(cartesAllie.get(1));
		cartesAllie.remove(1);
	}

}

	