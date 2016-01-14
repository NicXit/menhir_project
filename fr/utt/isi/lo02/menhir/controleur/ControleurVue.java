package fr.utt.isi.lo02.menhir.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.carte.Paquet;
import fr.utt.isi.lo02.menhir.modele.enumeration.Action;
import fr.utt.isi.lo02.menhir.modele.enumeration.Saison;
import fr.utt.isi.lo02.menhir.modele.enumeration.TypePartie;
import fr.utt.isi.lo02.menhir.modele.joueur.Humain;
import fr.utt.isi.lo02.menhir.modele.joueur.IA;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;
import fr.utt.isi.lo02.menhir.vue.VueChiensDeGarde;
import fr.utt.isi.lo02.menhir.vue.VueChoixPartieAvancee;
import fr.utt.isi.lo02.menhir.vue.VuePartie;
import fr.utt.isi.lo02.menhir.vue.VueTaupeGeante;

/**
 * Classe qui permet de controler la vue graphique et le modele
 * @author Mathieu DELALANDE, Nicolas GRANET
 */
public class ControleurVue {
	
	public static void main(String[] args) {
		  
		ControleurVue c = new ControleurVue();		
		
	}

	private Paquet paquet;	
	private Partie p;
	private VuePartie vp;
	
	int valeurJuste = 0, indiceChoix =0, choixAction=1, choixCarte =0, value = 0, valCarte[], valueCarteAllie = 0;
	String nomJoueurGagnant, typePartie;
	char reponseBonusAvancee, choixTypePartie;
	Action[] tabChoixAction = Action.values();
	Saison[] tabSaison = Saison.values();
	
	/**
	 * Constructeur, initialise la partie, les cartes et l'interface graphique du jeu 
	 */
	public ControleurVue(){
		paquet = new Paquet();
		p = new Partie();
		vp = new VuePartie(p, this);
	}
	
	/**
	 * Initialise le type de partie (rapid/avancée) et le nombre de joueurs humains
	 * @param nbJoueursHumain Nombre de joueurs humains
	 * @param rdbtRapide Boolean qui prend pour valeur vrai si l'utilisateur a choisi partie rapide et faux si l'utilisateur a choisi partie avancée
	 */
	public void paramPartie(int nbJoueursHumain, boolean rdbtRapide){
		if(rdbtRapide) p.setTypePartie(TypePartie.rapide);
		else p.setTypePartie(TypePartie.avancée);
		p.setNbHumains(nbJoueursHumain);
	}

	/**
	 * Ajoute un joueur humain par l'intermédiaire de la méthode ajouterHumain2 de la classe Partie et trie les joueurs quand tous
	 * les joueurs sont ajoutés à la partie
	 * @param nom Le nom du joueur à ajouter
	 * @param age L'age du joueur à ajouter
	 * @param genre Le genre du joueur à ajouter
	 */
	public void ajouterHumain(String nom, String age, String genre){
		int ageInt;
		char genreF;
		ageInt =Integer.parseInt(age);
		if(genre == "masculin") genreF='n';
		else genreF='o';		
		p.ajouterHumain2(nom, ageInt, genreF);
		if (p.listeHumains.size()== p.getNbHumains())
			p.triOrdreJeu();		
	}
	
	/**
	 * Ajoute un joueur IA par l'intermédiaire de la méthode ajouterIA2 de la classe Partie 
	 * @param nom Le nom du joueur IA à ajouter
	 */
	public void ajouterIA(String nom){
		p.ajouterIA2(nom);	
	}
	
	/**
	 * Initialise le lancement de la partie (avancée ou rapide).
	 */
	public void lancerPartie(){		

		if(p.getTypePartie().equals(TypePartie.rapide)){
			p.initGrainesPartieRapide();
			p.setNbManche(1);
			paquet.genererPaquetIngredient();
			paquet.distribuerCartesIngredientsJoueur(p.ordreJeu);					 						
			vp.vueManche(p.ordreJeu.get(0), p, false);			
		}	
		
		else{
			lancerPartieAvancée();
		}
		
	}
	
	/**
	 * Lance la partie avancée
	 */
	public void lancerPartieAvancée(){
		int compteur = 1;
		p.setNbManche(p.ordreJeu.size());
		paquet.genererPaquetAllie();
		VueChoixPartieAvancee vCPA = new VueChoixPartieAvancee(p.ordreJeu.get(0), this, p.ordreJeu.size(), compteur, p.ordreJeu);
	}
	
	/**
	 * Lance une nouvelle manche de la partie avancée
	 */
	public void NouvelleManchePartieAvancée(){
			p.setNumManche(p.getNumManche()+1);
			paquet.genererPaquetIngredient();
			paquet.distribuerCartesIngredientsJoueur(p.ordreJeu);
			if (p.ordreJeu.get(0).getCarteAllieJoueur() != null && p.ordreJeu.get(0).getCarteAllieJoueur().getNom() != "")    					 						
	    				vp.vueManche(p.ordreJeu.get(0), p, true);
	    			else
	    				vp.vueManche(p.ordreJeu.get(0), p, false);
	}														
	
	
	/**
	 * Initialise le choix des IA en partie avancée
	 * @param compteur La position du joueur dans la liste
	 */
	public void initialiserIA(int compteur){
		boolean continuer = true;
		do{
			if (p.ordreJeu.get(compteur) instanceof IA){
				int ran = (int)(Math.random()*2);
				if(ran == 0)
					initCarteAllies(p.ordreJeu.get(compteur), false);
				else{
					initCarteAllies(p.ordreJeu.get(compteur), true);
				}
				compteur++;
				if(p.ordreJeu.size() - compteur == 0)
					continuer = false;
			}
			else
				continuer = false;
		}while(continuer == true);
	}
	/**
	 * Ajoute 2 graines ou distribue une carte Alliés au joueur passé en paramètre 
	 * @param j Le joueur qui reçoit les graines ou une carte Alliés
	 * @param rdGraines Boolean qui prend pour valeur vrai le joueur choisit les graines et faux si le joueur choisit la carte Alliés 
	 */
	public void initCarteAllies(Joueur j, boolean rdGraines){
		if (rdGraines){
			j.setNbGraines(2);
			j.setCarteAllieJoueur(new CarteAllie("",null));									
		}
		else{
			paquet.distribuerCarteAllieJoueur(j);
		}
	}
	
	/**
	 * Effectue l'action de jeu après validation du choix de l'utilisateur
	 * @param j Joueur qui a validé son choix
	 * @param engrais le choix du joueur était engrais
	 * @param farfadets le choix du joueur était farfadets
	 * @param nomJoueurAttaque nom du joueur attaqué si farfadets
	 * @param numCarte position de la carte dans la main du joueur
	 */
	public void validationJoueur (Joueur j, boolean engrais, boolean farfadets, String nomJoueurAttaque, int numCarte){
		boolean stop = false;
		//on récupère la valeur de l'action
		valCarte = j.getCarteIngredientJoueur().get(numCarte-1).getValue();
		if(engrais)
			choixAction=2;
		else if(farfadets)
			choixAction=3;
		else
			choixAction=1;
			
		indiceChoix = valCarte.length/tabChoixAction.length * (choixAction-1) + tabSaison.length - j.getCarteIngredientJoueur().size();
		value = valCarte[indiceChoix];
			
		if(engrais)
			p.effectuerActionEngrais(value, j);
		else if (farfadets){
			//Si le joueur a une carte chien de garde
			if (p.getTypePartie().equals(TypePartie.avancée) && stringToJoueur(nomJoueurAttaque).getCarteAllieJoueur().getNom().equals("Chien de garde")){
				//Si le joueur n'est pas le dernier de la partie
				
				if(p.ordreJeu.indexOf(j)+1 < p.ordreJeu.size()){
					stop = true;
					utiliserChienDeGarde(p.ordreJeu.indexOf(j)+1, j, stringToJoueur(nomJoueurAttaque), value, p, numCarte);
				}
				else{
					stop = true;
					utiliserChienDeGarde(666, j, stringToJoueur(nomJoueurAttaque), value, p, numCarte);
				}
			}
			else
				p.effectuerActionFarfadets(value, j,stringToJoueur(nomJoueurAttaque));
		}
		else
			p.effectuerActionGeant(value, j);
		
		if(!stop){
				//on supprime la carte quand le joueur a fini de jouer
				j.getCarteIngredientJoueur().remove(numCarte-1);
				
				int numOrdreJoueur = p.ordreJeu.indexOf(j);	
				if(numOrdreJoueur+1 < p.ordreJeu.size()){
					if (p.ordreJeu.get(numOrdreJoueur+1) instanceof IA)
						finTour();
					else if (p.ordreJeu.get(numOrdreJoueur+1).getCarteAllieJoueur() != null && p.ordreJeu.get(numOrdreJoueur+1).getCarteAllieJoueur().getNom() != ""){
						if (p.ordreJeu.get(numOrdreJoueur+1).getCarteAllieJoueur().getNom().equals("La taupe géante")){
							VueTaupeGeante vt = new VueTaupeGeante(2, p,this,p.ordreJeu.get(numOrdreJoueur+1));
							vt.setVisible(true);
						}
						vp.vueManche(p.ordreJeu.get(numOrdreJoueur+1), p, true);
					}
					else
						vp.vueManche(p.ordreJeu.get(numOrdreJoueur+1), p, false);
			}

		}
	}
	
	/**
	 * Fonction qui permet de terminer un tour de jeu et initialiser les bonnes fonctions selon le déroulement de la partie
	 */
	public void finTour(){
		//Les IA jouent
		for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
			Joueur j = (Joueur) it.next();
			if (j instanceof IA)
				System.out.println(((IA) j).getStrategy().jouer(j, j.getCarteIngredientJoueur(), tabSaison.length - j.getCarteIngredientJoueur().size() + 1, p));
		}
		
		
		if(p.getSaison() == Saison.hiver && p.getTypePartie().equals(TypePartie.avancée)){
			//On calcule le nombre de points de chacun
			for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
				Joueur j = (Joueur) it.next();
				j.setNbPoints(j.getNbPoints()+j.getNbMenhir());
				j.setNbMenhir(0);
				j.setNbGraines(0);
			}
			if(p.getNumManche() == p.ordreJeu.size()){
				p.triOrdreScore();
				finPartie();
			}
			else{
				p.setSaison(Saison.printemps);
				lancerPartieAvancée();
			}
		}
		else if(p.getSaison() != Saison.hiver){
			int i = 0;
			boolean continuer = true;
			 Saison tabSaison[] = Saison.values();
			 do{
				 if (tabSaison[i] == p.getSaison()){
					 continuer = false;
				 }
				 i++;
			 }while(continuer == true);
			 p.setSaison(tabSaison[i]);
			 if (p.ordreJeu.get(0).getCarteAllieJoueur() != null && p.ordreJeu.get(0).getCarteAllieJoueur().getNom() != ""){ 
				 if (p.ordreJeu.get(0).getCarteAllieJoueur().getNom().equals("La taupe géante")){
						VueTaupeGeante vt = new VueTaupeGeante(2, p,this,p.ordreJeu.get(0));
						vt.setVisible(true);
				}
 				vp.vueManche(p.ordreJeu.get(0), p, true);
			 }
 			 else
 				vp.vueManche(p.ordreJeu.get(0), p, false);
		}
		else{
			p.triOrdreScore();
			finPartie();
		}
	}
	
	/**
	 * Fait appel à la vue de la fin de la partie
	 */
	public void finPartie(){
		vp.vueFinPartie(p);
	}
		 
	
	/**
	 * Retourne un joueur (type Joueur) à partir de son nom (String)
	 * @param nom Le nom du joueur (String)
	 * @return Le joueur à partir de son nom
	 */
	public Joueur stringToJoueur(String nom){
		Joueur j = null;
		for(int i=0;i<p.ordreJeu.size();i++){
			if (nom == p.ordreJeu.get(i).getNom())
				j = p.ordreJeu.get(i);
		}
		return j;
	}
	
	/**
	 * Fait appel à la vue chiens de garde pour savoir si le joueur veut utiliser sa carte
	 * @param joueurSuivant Joueur qui joue ensuite
	 * @param joueurActif Joueur attaquant
	 * @param joueurAttaque Joueur attaqué
	 * @param attaque Valeur de l'attaque farfadet
	 * @param p Partie actuelle
	 * @param numCarte Position de la carte farfadet du joueurActif
	 */
	public void utiliserChienDeGarde(int joueurSuivant, Joueur joueurActif, Joueur joueurAttaque, int attaque, Partie p, int numCarte){
		int[] valeurs = joueurAttaque.getCarteAllieJoueur().getValue();
		int valeur = 0;
		if(p.getSaison() == Saison.printemps)
			valeur = valeurs[0];
		else if(p.getSaison() == Saison.été)
			valeur = valeurs[1];
		else if(p.getSaison() == Saison.automne)
			valeur = valeurs[2];
		else if(p.getSaison() == Saison.hiver)
			valeur = valeurs[3];
		
		VueChiensDeGarde vcdg = new VueChiensDeGarde(joueurSuivant, joueurActif, joueurAttaque, attaque, p, valeur,this,vp, numCarte);
		vp.setVisible(false);
		vcdg.setVisible(true);
	}
	
}
