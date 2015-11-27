package fr.utt.isi.lo02.menhir.modele.partie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import fr.utt.isi.lo02.menhir.modele.enumeration.Saison;
import fr.utt.isi.lo02.menhir.modele.enumeration.TypePartie;
import fr.utt.isi.lo02.menhir.modele.joueur.*;

public class Partie{
	private TypePartie typePartie;
	private Saison saison;
	private int nbJoueur, manche;
	public ArrayList<Humain> listeHumains;
	public ArrayList<Joueur> ordreJeu;
	
	public Partie() {
		this.saison=Saison.printemps;
		this.listeHumains = new ArrayList<Humain>();
		this.ordreJeu = new ArrayList<Joueur>();
	}
	

	/*
	 * Méthode qui choisit le type de la partie
	 * 
	 * ajouter while ou exception
	 */
	public void typePartie(){
		for (TypePartie t : TypePartie.values()) {
			System.out.println(t);
		}		
		try(Scanner in = new Scanner(System.in)){
			String typePartie = in.nextLine();		
			for (TypePartie t : TypePartie.values()) {
		        if (t.name().equals(typePartie)) {
		            this.typePartie=TypePartie.valueOf(typePartie);	            
		        }	        
			}
		}
	}

	
	/*
	 * Méthode qui initialise les joueurs humains
	 */
	public void ajouterHumain(int i){
			Scanner joueur = new Scanner(System.in);
			System.out.println("Veuillez saisir le nom du joueur " + i + " (humain) : ");
			String nom = joueur.nextLine();
			
			System.out.println("Veuillez sasir l'age du joueur " + i + " : ");
			int age = joueur.nextInt();
			
			joueur.nextLine();
			System.out.println("Le joueur est-il du genre féminin (o/n) ?");
			char genreF = joueur.nextLine().charAt(0);
			
			this.listeHumains.add(new Humain(nom,age,genreF));			
		}
	
	public void ajouterIA(int i){
		Scanner ia = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom de l'IA " + i + " : ");
		String nom = ia.nextLine();

		this.ordreJeu.add(new IA(nom));		
	}
	
	 
	public void triOrdreJeu(){	 
		Collections.sort(this.listeHumains);
		for(Humain h : this.listeHumains){
			this.ordreJeu.add(h);
		}
	}
		
		public TypePartie getTypePartie(){
			return this.typePartie;
		}
		
		public Joueur getJoueurActif(int numOrdreJoueur){
			return this.ordreJeu.get(numOrdreJoueur);
		}
		
		public Saison getSaison(){
			return this.saison;
		}
		
		public void effectuerActionGeant(int valAction, Joueur joueur){	
				joueur.setNbGraines(joueur.getNbGraines() + valAction);
		}
		
		public void effectuerActionEngrais(int valAction, Joueur joueur){
			if (valAction <= joueur.getNbGraines()){
				joueur.setNbMenhir(joueur.getNbMenhir()+valAction);
				joueur.setNbGraines(joueur.getNbGraines()-valAction);
			}
			else
				joueur.setNbMenhir(joueur.getNbMenhir()+joueur.getNbGraines());		
		}
		
		public void effectuerActionFarfadets(int valAction, Joueur joueur, Joueur joueurAttaque){			
			if (valAction <= joueurAttaque.getNbGraines()){							
				joueur.setNbGraines(joueur.getNbGraines()+valAction);
				joueurAttaque.setNbGraines(joueurAttaque.getNbGraines()-valAction);
			}
			else{
				joueur.setNbGraines(joueur.getNbGraines()+joueurAttaque.getNbGraines());
				joueurAttaque.setNbGraines(0);
			}
		}
		
			
}
	



