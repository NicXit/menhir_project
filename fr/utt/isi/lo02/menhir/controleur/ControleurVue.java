package fr.utt.isi.lo02.menhir.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Scanner;

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

public class ControleurVue {	
	private Paquet paquet;	
	private Partie p;
	private VuePartie vp;
	private int numManche;
	
	int valeurJuste = 0, indiceChoix =0, choixAction=1, choixCarte =0, value = 0, valCarte[], valueCarteAllie = 0;
	String nomJoueurGagnant, typePartie;
	char reponseBonusAvancee, choixTypePartie;
	Action[] tabChoixAction = Action.values();
	Saison[] tabSaison = Saison.values();
	
	public ControleurVue(){
		this.numManche=0;
		paquet = new Paquet();
		p = new Partie();
		vp = new VuePartie(p, this);
	}
	
	public void paramPartie(int nbJoueursHumain, int nbJoueursIA, boolean rdbtRapide, boolean rdbtAvance){
		if(rdbtRapide) p.setTypePartie(TypePartie.rapide);
		else p.setTypePartie(TypePartie.avancée);
		p.setNbHumains(nbJoueursHumain);
	}

	/**
	 * Méthode qui ajoute les joueurs Humains et qui les trie
	 * @param nom
	 * @param age
	 * @param genre
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
	 * Méthode qui ajoute les joueurs IA 
	 * @param nom
	 */
	public void ajouterIA(String nom){
		p.ajouterIA2(nom);	
	}
	
	/**
	 * Méthode qui initialise le nombre de manches, le choix des graines ou de la carte Alliés en partie avancée et qui lance la partie
	 */
	public void lancerPartie(){		
			if(p.getTypePartie().equals(TypePartie.rapide)){
				p.initGrainesPartieRapide();
				p.setNbManche(1);				
			}
			else{
				p.setNbManche(p.ordreJeu.size());
			}
			
		for (numManche = 1; numManche <= p.getNbManche(); numManche++){
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
			vp.vueManche(p.ordreJeu.get(0),p);
			
		}
			
	}
	
	public void initCarteAllies(Joueur j, boolean rdGraines, boolean rdCarte){
		if (rdGraines){
			j.setNbGraines(2);
			j.setCarteAllieJoueur(new CarteAllie("",null));									
		}
		else
			paquet.distribuerCarteAllieJoueur(j);
	}
	
}
