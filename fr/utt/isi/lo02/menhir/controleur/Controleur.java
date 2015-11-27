package fr.utt.isi.lo02.menhir.controleur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.carte.Paquet;
import fr.utt.isi.lo02.menhir.modele.enumeration.Action;
import fr.utt.isi.lo02.menhir.modele.enumeration.Saison;
import fr.utt.isi.lo02.menhir.modele.enumeration.TypePartie;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.*;

public class Controleur {

	public static void main(String[] args) {
		// TEST
		Paquet paquet = new Paquet();
		paquet.genererPaquetIngredient();
		paquet.genererPaquetAllie();
		String newLine = System.getProperty("line.separator");
		
		Scanner sc = new Scanner(System.in);
		Partie p = new Partie();
		int valeurJuste = 0, indiceChoix =0, nbHumain = 0, choixAction=1, choixCarte =0, choixTypePartie=0;
		String nomJoueurGagnant, typePartie;
		char reponseBonusAvancee;
		Action[] tabChoixAction = Action.values();
		Saison[] tabSaison = Saison.values();
		
		System.out.println("*** JEU MENHIR ***");

		do{
			System.out.println("Combien de joueurs Humains (1..6) ?");
			nbHumain = sc.nextInt();
			sc.nextLine();
			
			if(nbHumain < 1 || nbHumain > 6){
				System.out.println("Entr�e incorrecte !");
				valeurJuste = 0;
			}
			else{
				for(int i=0; i < nbHumain; i++){
					p.ajouterHumain(i+1);
					System.out.println("Joueur ajout� � la partie !");
				}
				valeurJuste = 1;
			}
		}while (valeurJuste == 0);
		
		p.triOrdreJeu();
		
		do{
			System.out.println("Combien de joueurs IA (0..5) ?");
			int nbIA = sc.nextInt();
			sc.nextLine();
			
			if((nbHumain + nbIA) < 2 || (nbHumain + nbIA) > 6){
				System.out.println("Entr�e incorrecte !");
				valeurJuste = 0;
			}
			else{	
				for(int i=0; i < nbIA; i++){
					p.ajouterIA(i+1);
					System.out.println("Joueur ajout� � la partie !");
				}
				valeurJuste = 1;
			}
		}while (valeurJuste == 0);
		
		
		
		paquet.distribuerCartesIngredientsJoueur(p.ordreJeu);	
		
		//on choisit le type de partie
		System.out.println("Veuillez entrer le num�ro du type de partie :");
		for (TypePartie t : TypePartie.values()) {
			System.out.println(t);
		}	
		choixTypePartie = sc.nextInt();
		
		switch (choixTypePartie){
			case 1 :	       
	            p.setTypePartie(TypePartie.rapide);
	            for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
					Joueur j = (Joueur) it.next();
					j.setNbGraines(2);					
				}
	            System.out.println("Vous avez choisi la partie " + p.getTypePartie());
	         // On parcourt chaque saison pour correspondre � un tour de jeu
	    		for (Saison saison : Saison.values()){
	    			System.out.println(newLine+"Saison en cours : "+saison);
	    			
	    			//on rappelle le nombre de graines et de menhirs de chacun
	    			for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
	    				Joueur j = (Joueur) it.next();
	    				System.out.println(j.getNom()+" a " + j.getNbGraines() + " graines et " + j.getNbMenhir() + " menhirs.");
	    			}
	    			//on fait jouer les joueurs les uns apr�s les autres
	    			for(int numOrdreJoueur = 0; numOrdreJoueur < p.ordreJeu.size(); numOrdreJoueur++){
	    				Joueur actif = p.getJoueurActif(numOrdreJoueur);
	    				System.out.println(newLine+"C'est au tour de " + actif.getNom()+ " de jouer !");
	    				System.out.println("Choisir une carte : ");
	    				
	    				//on affiche toutes les cartes d'un joueur
	    				for(Iterator<CarteIngredient> it = actif.getCarteIngredientJoueur().iterator(); it.hasNext();){
	    					CarteIngredient carte = (CarteIngredient) it.next();
	    					System.out.println(carte.toString());
	    				}	
	    				choixCarte = sc.nextInt();
	    				System.out.println("Vous avez choisi la carte : " + newLine + actif.getCarteIngredientJoueur().get(choixCarte-1));
	    				
	    				//on demande � l'utilisateur de choisir une action
	    				do{
	    					System.out.println("Choisir le numero de l'action : ");
	    					choixAction = sc.nextInt();	
	    					sc.nextLine();
	    					
	    					if (choixAction > tabChoixAction.length || choixAction <= 0){						
	    						System.out.println("num�ro d'action incorrecte");
	    						sc.next();
	    					}						
	    				}while (choixAction > tabChoixAction.length || choixAction <= 0);				
	    				
	    				//on r�cup�re la valeur de l'action
	    				int valCarte[] = actif.getCarteIngredientJoueur().get(choixCarte-1).getValue();
	    				indiceChoix = valCarte.length/tabChoixAction.length * (choixAction-1) + tabSaison.length - actif.getCarteIngredientJoueur().size();
	    				int value = valCarte[indiceChoix];
	    				System.out.println("Vous avez choisi l'action " + tabChoixAction[choixAction-1] + " qui a pour valeur " + value);
	    				
	    				//en fonction du choix de l'action on appelle sa m�thode
	    				switch (choixAction){				
	    				case 1 :
	    					p.effectuerActionGeant(value, actif);					
	    					break;
	    				case 2 :
	    					p.effectuerActionEngrais(value, actif);
	    					break;
	    				case 3 :
	    					//rappelle le nombre de graines et de menhirs de chacun
	    					for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
	    						Joueur j = (Joueur) it.next();
	    						System.out.println(j.getNom()+" a " + j.getNbGraines() + " graines et " + j.getNbMenhir() + " menhirs.");
	    					}					
	    					System.out.println("Quelle joueur voulez vous attaquer ? ");
	    					String nomJoueurAttaque = sc.nextLine();
	    					
	    					//on parcourt la liste de joueurs en comparant chaque nom de joueur au nom rentr� par l'utilisateur
	    					for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
	    						Joueur joueurAttaque = (Joueur) it.next();
	    						
	    						//si le joueur �xiste on appelle la fonction farfadet
	    						if(joueurAttaque.getNom().equals(nomJoueurAttaque)){							
	    							System.out.println("Le joueur : " + actif.getNom() +" vole des graines � " +joueurAttaque.getNom() + " avec sa carte de valeur " + value);
	    							p.effectuerActionFarfadets(value, actif, joueurAttaque);
	    							break;
	    							}						
	    					}
	    					break;
	    				}
	    				//on supprime la carte quand le joueur a fini de jouer
	    				actif.getCarteIngredientJoueur().remove(choixCarte-1);	    			
	    			}
	    		}
	            break;
			case 2 :
				p.setTypePartie(TypePartie.avanc�e);
				for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
					Joueur j = (Joueur) it.next();
					System.out.println("Voulez vous prendre 2 graines ou piocher une carte Alli�s ? (g/a)");
					reponseBonusAvancee = sc.nextLine().charAt(0);
						if (reponseBonusAvancee == 'g')
							j.setNbGraines(2);
						else
							paquet.distribuerCarteAllieJoueur(j);
				}
				break;
	        }		
		
		System.out.println("La partie est finie.");
		
		//On tri les joueurs par ordre de Score
		p.triOrdreScore();
		//rappelle le nombre de graines et de menhirs de chacun
		for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
			Joueur j = (Joueur) it.next();
			System.out.println(j.getNom()+" a " + j.getNbGraines() + " graines et " + j.getNbMenhir() + " menhirs.");
		}
		

		
	}
}
