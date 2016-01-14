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

/**
 * Classe qui repr�sente une partie
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class Partie {
	private TypePartie typePartie;
	private Saison saison;
	private int nbManche, numManche;
	private int nbHumains, nbIA;

	public ArrayList<Humain> listeHumains;
	public ArrayList<Joueur> ordreJeu;
	
	/**
	 * Constructeur, initialise la saison � printemps, cr�e les listes d'humains et de joueurs, initialise le nombre d'humains et le nombre 
	 * de manches � 0;
	 */
	public Partie() {
		this.saison=Saison.printemps;
		this.listeHumains = new ArrayList<Humain>();
		this.ordreJeu = new ArrayList<Joueur>();
		this.nbHumains=0;
		this.numManche=0;
	}

	
	/**
	 * Ajoute un joueur humain � la liste des humains
	 * @param nom Le nom du joueur
	 * @param age L'age du joueur
	 * @param genreF Le genre du joueur
	 */
	public void ajouterHumain2(String nom, int age, char genreF){
		this.listeHumains.add(new Humain(nom,age,genreF));
	}
	
	/**
	 * Ajoute un joueur IA � la liste des joueurs
	 * @param nom Le nom du joueur
	 */
	public void ajouterIA2(String nom){
		this.ordreJeu.add(new IA(nom));	
	}
	
	 /**
	  * Trie les joueurs
	  */
	public void triOrdreJeu(){	 
		Collections.sort(this.listeHumains);
		for(Humain h : this.listeHumains){
			this.ordreJeu.add(h);
		}
	}
	
	/**
	 * Trie les joueurs en fonction de leur score. Le joueur ayant le score le plus grand occupera la premi�re place de la collection
	 */
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
	
	public int getNumManche() {
		return numManche;
	}
	public void setNumManche(int numManche) {
		this.numManche = numManche;
	}

	public int getNbManche(){
		return this.nbManche;
	}
	
	public void setNbManche(int nbManche){
		this.nbManche=nbManche;
	}
	
	/**
	 * Correspond � l'action Geant. Le joueur voit son nombre de graines augmenter de la valeur du param�tre valAction.
	 * @param valAction Le nombre de graines � ajouter
	 * @param joueur Le joueur qui re�oit les graines
	 */
	public void effectuerActionGeant(int valAction, Joueur joueur){	
			joueur.setNbGraines(joueur.getNbGraines() + valAction);
	}
	
	/**
	 * Correspond � l'action Engrais. Le joueur transforme ses graines en menhirs. Le nombre de graines transform�es d�pend de valAction et du nombre
	 * de graines que dispose le joueur. 
	 * @param valAction Le nombre de graines maximum qui peuvent �tre transform�es
	 * @param joueur Le joueur pour lequel les graines sont transform�es.
	 */
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
	
	/**
	 * Correspond � l'action Farfadets. Le joueur "joueur" vole des graines au joueur "joueurAttaque". Le nombre de graines vol�es d�pend du nombre de
	 * graines du joueur "joueurAttaque" et de valAction.
	 * @param valAction Le nombre de graines maximum qui peuvent �tre vol�es
	 * @param joueur Le joueur qui vole
	 * @param joueurAttaque Le joueur qui se fait voler
	 */
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
	
	/**
	 * Correspond � l'action TaupeGeante. Le nombre de menhirs du joueur "joueurAttaque" diminue. Le nombre de menhirs d�truits d�pend du nombre de
	 * menhirs du joueur "joueurAttaque" et de valAction.
	 * @param valAction Le nombre de menhirs d�truits au maximum
	 * @param joueurAttaque Le joueur qui perd des menhirs
	 */
	public void effectuerActionTaupeGeante(int valAction, Joueur joueurAttaque){
		if (valAction <= joueurAttaque.getNbMenhir())			
			joueurAttaque.setNbMenhir(joueurAttaque.getNbMenhir()-valAction);			
		else
			joueurAttaque.setNbMenhir(0);
	}
	
	/**
	 * Initialise le nombre de graines � 2 pour tous les joueurs de la partie
	 */
	public void initGrainesPartieRapide(){
		for(Iterator<Joueur> it = this.ordreJeu.iterator(); it.hasNext();){
			Joueur j = (Joueur) it.next();
			j.setNbGraines(2);							
		}
	}
			
}
