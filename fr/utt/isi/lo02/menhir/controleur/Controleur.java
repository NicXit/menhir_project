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
		int valeurJuste = 0, indiceChoix =0, nbHumain = 0, choixAction=1, choixCarte =0;
		String nomJoueurGagnant;
		Action[] tabChoixAction = Action.values();
		Saison[] tabSaison = Saison.values();

		
		System.out.println("*** JEU MENHIR ***");

		
		System.out.println("Veuillez choisir un type de partie parmi :");
		//typePartie();
		
		do{
			System.out.println("Combien de joueurs Humains (1..6) ?");
			nbHumain = sc.nextInt();
			
			if(nbHumain < 1 || nbHumain > 6){
				System.out.println("Entrée incorrecte !");
				valeurJuste = 0;
			}
			else{
				for(int i=0; i < nbHumain; i++){
					p.ajouterHumain(i+1);
					System.out.println("Joueur ajouté à la partie !");
				}
				valeurJuste = 1;
			}
		}while (valeurJuste == 0);
		
		p.triOrdreJeu();
		
		do{
			System.out.println("Combien de joueurs IA (0..5) ?");
			int nbIA = sc.nextInt();
			
			if((nbHumain + nbIA) < 2 || (nbHumain + nbIA) > 6){
				System.out.println("Entrée incorrecte !");
				valeurJuste = 0;
			}
			else{	
				for(int i=0; i < nbIA; i++){
					p.ajouterIA(i+1);
					System.out.println("Joueur ajouté à la partie !");
				}
				valeurJuste = 1;
			}
		}while (valeurJuste == 0);
		
		
		
		paquet.distribuerCartesIngredientsJoueur(p.ordreJeu);
		
		/*System.out.println("Choisir le type de partie : " );
		p.typePartie();
		if (p.getTypePartie()== TypePartie.rapide){
			
		}
		else if (p.getTypePartie() == TypePartie.avancée){
			paquet.distribuerCarteAllieJoueur(p.ordreJeu.get(0));
		}*/
		
		// On parcourt chaque saison pour correspondre à un tour de jeu
		for (Saison saison : Saison.values()){
			System.out.println(newLine+"Saison en cours : "+saison);
			
			//on rappelle le nombre de graines et de menhirs de chacun
			for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
				Joueur j = (Joueur) it.next();
				System.out.println(j.getNom()+" a " + j.getNbGraines() + " graines et " + j.getNbMenhir() + " menhirs.");
			}
			//on fait jouer les joueurs les uns après les autres
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
				
				//on demande à l'utilisateur de choisir une action
				do{
					System.out.println("Choisir le numero de l'action : ");
					choixAction = sc.nextInt();	
					sc.nextLine();
					
					if (choixAction > tabChoixAction.length || choixAction <= 0){						
						System.out.println("numéro d'action incorrecte");
						sc.next();
					}						
				}while (choixAction > tabChoixAction.length || choixAction <= 0);				
				
				//on récupère la valeur de l'action
				int valCarte[] = actif.getCarteIngredientJoueur().get(choixCarte-1).getValue();
				indiceChoix = valCarte.length/tabChoixAction.length * (choixAction-1) + tabSaison.length - actif.getCarteIngredientJoueur().size();
				int value = valCarte[indiceChoix];
				System.out.println("Vous avez choisi l'action " + tabChoixAction[choixAction-1] + " qui a pour valeur " + value);
				
				//en fonction du choix de l'action on appelle sa méthode
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
					
					//on parcourt la liste de joueurs en comparant chaque nom de joueur au nom rentré par l'utilisateur
					for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
						Joueur joueurAttaque = (Joueur) it.next();
						
						//si le joueur éxiste on appelle la fonction farfadet
						if(joueurAttaque.getNom().equals(nomJoueurAttaque)){							
							System.out.println("Le joueur : " + actif.getNom() +" vole des graines à " +joueurAttaque.getNom() + " avec sa carte de valeur " + value);
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
		System.out.println("La partie est finie.");
		
		//rappelle le nombre de graines et de menhirs de chacun
		for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
			Joueur j = (Joueur) it.next();
			System.out.println(j.getNom()+" a " + j.getNbGraines() + " graines et " + j.getNbMenhir() + " menhirs.");
		}
		
		
		
	}
}
