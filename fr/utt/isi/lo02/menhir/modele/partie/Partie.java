package fr.utt.isi.lo02.menhir.modele.partie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import fr.utt.isi.lo02.menhir.modele.enumeration.Saison;
import fr.utt.isi.lo02.menhir.modele.enumeration.TypePartie;
import fr.utt.isi.lo02.menhir.modele.joueur.*;

public class Partie{
	private TypePartie typePartie;
	private Saison saison;
	private int nbJoueur, manche, tour;
	public ArrayList<Humain> listeHumains;
	public ArrayList<Joueur> ordreJeu;
	
	public Partie() {
		this.saison=Saison.printemps;
		this.listeHumains = new ArrayList<Humain>();
		this.ordreJeu = new ArrayList<Joueur>();
	}
	
	public void ajouterHumain(int i){
			Scanner joueur = new Scanner(System.in);
			System.out.println("Veuillez saisir le nom du joueur " + i + " (humain) : ");
			String nom = joueur.nextLine();
			
			System.out.println("Veuillez sasir l'age du joueur " + i + " : ");
			int age = joueur.nextInt();
			
			System.out.println("Le joueur est-il du genre féminin (true/false) ?");
			boolean genreF = joueur.nextBoolean();
			
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
		
		public Joueur getJoueurActif(int tour){
			return this.ordreJeu.get(tour);
		}
			
}
	



