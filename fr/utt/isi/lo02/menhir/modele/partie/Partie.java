package fr.utt.isi.lo02.menhir.modele.partie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import fr.utt.isi.lo02.menhir.modele.enumeration.Saison;
import fr.utt.isi.lo02.menhir.modele.enumeration.TypePartie;
import fr.utt.isi.lo02.menhir.modele.joueur.*;

public class Partie extends Observable{
	private TypePartie typePartie;
	private Saison saison;
	private int nbManche;
	private int nbHumains, nbIA;

	public ArrayList<Humain> listeHumains;
	public ArrayList<Joueur> ordreJeu;
	
	public Partie() {
		this.saison=Saison.printemps;
		this.listeHumains = new ArrayList<Humain>();
		this.ordreJeu = new ArrayList<Joueur>();
		this.nbHumains=0;
	}

	/*
	 * Méthode qui initialise les joueurs humains
	 */
	public void ajouterHumain(int i){
			Scanner joueur = new Scanner(System.in);
			System.out.println("Veuillez saisir le nom du joueur " + i + " (humain) : ");
			String nom = joueur.nextLine();
			
			System.out.println("Veuillez saisir l'age du joueur " + i + " : ");
			int age = joueur.nextInt();
			
			joueur.nextLine();
			System.out.println("Le joueur est-il du genre féminin (o/n) ?");
			char genreF = joueur.nextLine().charAt(0);
			
			this.listeHumains.add(new Humain(nom,age,genreF));			
		}
	
	/**
	 * ajouter humain avec l'iterface graphique
	 */
	public void ajouterHumain2(String nom, int age, char genreF){
		this.listeHumains.add(new Humain(nom,age,genreF));
	}
	
	public void ajouterIA(int i){
		Scanner ia = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom de l'IA " + i + " : ");
		String nom = ia.nextLine();

		this.ordreJeu.add(new IA(nom));		
	}
	
	public void ajouterIA2(String nom){
		this.ordreJeu.add(new IA(nom));	
	}
	
	 
	public void triOrdreJeu(){	 
		Collections.sort(this.listeHumains);
		for(Humain h : this.listeHumains){
			this.ordreJeu.add(h);
		}
	}
	
	public void triOrdreScore(){	 
		Collections.sort(this.ordreJeu,Joueur.comparatorScore);
	}
		
		public TypePartie getTypePartie(){
			return this.typePartie;
		}		
		public void setTypePartie(TypePartie typePartie){			
				this.typePartie=typePartie;			
		}
		
		public int getNbHumains(){
			return this.nbHumains;
		}
		public void setNbHumains(int nbHumains){
			this.nbHumains=nbHumains;
		}
		
		public int getNbIA() {
			return nbIA;
		}
		public void setNbIA(int nbIA) {
			this.nbIA = nbIA;
		}
		
		public Joueur getJoueurActif(int numOrdreJoueur){
			return this.ordreJeu.get(numOrdreJoueur);
		}
		
		public Saison getSaison(){
			return this.saison;
		}
		
		public void setSaison(Saison saison){
			this.saison=saison;
		}
		public int getNbManche(){
			return this.nbManche;
		}
		
		public void setNbManche(int nbManche){
			this.nbManche=nbManche;
		}
		
		public void effectuerActionGeant(int valAction, Joueur joueur){	
				joueur.setNbGraines(joueur.getNbGraines() + valAction);
		}
		
		public void effectuerActionEngrais(int valAction, Joueur joueur){
			if (valAction <= joueur.getNbGraines()){
				joueur.setNbMenhir(joueur.getNbMenhir()+valAction);
				joueur.setNbGraines(joueur.getNbGraines()-valAction);
			}
			else{
				joueur.setNbMenhir(joueur.getNbMenhir()+joueur.getNbGraines());
				joueur.setNbGraines(0);
			}
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
		
		public void effectuerActionTaupeGeante(int valAction, Joueur joueurAttaque){
			if (valAction <= joueurAttaque.getNbMenhir())			
				joueurAttaque.setNbMenhir(joueurAttaque.getNbMenhir()-valAction);			
			else
				joueurAttaque.setNbMenhir(0);
		}
		
		public void initGrainesPartieRapide(){
			for(Iterator<Joueur> it = this.ordreJeu.iterator(); it.hasNext();){
				Joueur j = (Joueur) it.next();
				j.setNbGraines(2);							
			}
		}
			
}
	



