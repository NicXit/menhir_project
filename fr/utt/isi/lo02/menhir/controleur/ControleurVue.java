package fr.utt.isi.lo02.menhir.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;
import fr.utt.isi.lo02.menhir.vue.VueChoixPartieAvancee;
import fr.utt.isi.lo02.menhir.vue.VuePartie;

/**
 * Classe qui permet de controler la vue graphique et le modele
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class ControleurVue {	
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
	 * Initialise le nombre de manches, le choix des graines ou de la carte Alliés en partie avancée et lance la partie.
	 */
	public void lancerPartie(){		
			if(p.getTypePartie().equals(TypePartie.rapide)){
				p.initGrainesPartieRapide();
				p.setNbManche(1);				
			}
			else{
				p.setNbManche(p.ordreJeu.size());
			}
			
		for (int numManche = 1; numManche <= p.getNbManche(); numManche++){
			p.setNumManche(numManche);
			paquet.genererPaquetIngredient();
			paquet.genererPaquetAllie();
			paquet.distribuerCartesIngredientsJoueur(p.ordreJeu);	
			if (p.getTypePartie().equals(TypePartie.avancée)){				
				for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
					Joueur j = (Joueur) it.next();
					//Si c'est un humain on lui propose un choix
						if (j instanceof Humain){
							VueChoixPartieAvancee vCPA = new VueChoixPartieAvancee(j, this);																
						}
						// si c'est un IA le choix est random
						else{
								int ran = (int)(Math.random()*2);
								if(ran == 0)
									paquet.distribuerCarteAllieJoueur(j);	
								else{
									j.setNbGraines(j.getNbGraines()+2);
									j.setCarteAllieJoueur(new CarteAllie("",null));									
								}
							}
						
				}
			}
			/**
			for (Saison saison : Saison.values()){
    			p.setSaison(saison);    			
    			
    			//on fait jouer les joueurs les uns après les autres
    			//for(int numOrdreJoueur = 0; numOrdreJoueur < p.ordreJeu.size(); numOrdreJoueur++){
    				//Joueur actif = p.getJoueurActif(numOrdreJoueur);
    				Joueur actif = p.getJoueurActif(0);  
    				//choix de la carte et de l'action pour un humain
    				if (actif instanceof Humain){     					
    					if (p.getTypePartie().equals(TypePartie.avancée) && actif.getCarteAllieJoueur() != null && (actif.getCarteAllieJoueur().getNom().equals("La taupe géante") || 
    							actif.getCarteAllieJoueur().getNom().equals("Chien de garde"))){    						
    						vp.vueManche(actif,p, true);
        				}
    					else{    						
    						vp.vueManche(actif, p, false);
    					}
    				}
    					
    			//}
    			
				
			}**/
					
			vp.vueManche(p.ordreJeu.get(0), p, false);
		}
			
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
	
	public void validationJoueur (Joueur j, boolean engrais, boolean farfadets, String nomJoueurAttaque, int numCarte){
		//on récupère la valeur de l'action
		valCarte = j.getCarteIngredientJoueur().get(numCarte-1).getValue();
		if(engrais)
			indiceChoix = valCarte.length/tabChoixAction.length * (choixAction-1) + tabSaison.length - j.getCarteIngredientJoueur().size();
		else if(farfadets)
			indiceChoix = valCarte.length/tabChoixAction.length * 2 + tabSaison.length - j.getCarteIngredientJoueur().size();
		else
			indiceChoix = tabSaison.length - j.getCarteIngredientJoueur().size();

		value = valCarte[indiceChoix];
		
		if(engrais)
			p.effectuerActionEngrais(value, j);
		//else if (farfadets)
			//p.effectuerActionFarfadets(value, j,stringToJoueur(nomJoueurAttaque) );
		else
			p.effectuerActionGeant(value, j);
		
		int numOrdreJoueur = p.ordreJeu.indexOf(j);	
		if(numOrdreJoueur+1 < p.ordreJeu.size()){
			vp.vueManche(p.ordreJeu.get(numOrdreJoueur+1), p, false);
		}
		
	}
	
	public void finTour(){
		if(p.getSaison() != Saison.hiver){
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
			 vp.vueManche(p.ordreJeu.get(0), p, false);
		}
		else{
			finManche();
		}
		 
	}
	
}
