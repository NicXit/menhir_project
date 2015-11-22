package fr.utt.isi.lo02.menhir.controleur;

import java.util.Scanner;

<<<<<<< HEAD
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.carte.Paquet;
import fr.utt.isi.lo02.menhir.modele.enumeration.TypePartie;
=======
import fr.utt.isi.lo02.menhir.modele.carte.Paquet;
>>>>>>> dd5f13d282107cfee3e4e1f4bd55855f27ca642d
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.*;

public class Controleur {

	public static void main(String[] args) {
		// TEST
		Paquet paquet = new Paquet();
		paquet.genererPaquetIngredient();
		paquet.genererPaquetAllie();
		
		Scanner sc = new Scanner(System.in);
		Partie p = new Partie();
		int valeurJuste = 0;
		int nbHumain = 0;

		
		System.out.println("*** JEU MENHIR ***");
		
		
		System.out.println("Veuillez choisir un type de partie parmi :");
		//typePartie();
		
		do{
			System.out.println("Combien de joueurs Humains (1..6) ?");
			nbHumain = sc.nextInt();
			
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
		
		
		paquet.genererPaquetIngredient();
		paquet.distribuerCartesIngredientsJoueur(p.ordreJeu);
		
		//if (p.getTypePartie() == TypePartie.rapide){
			for(int tour = 0; tour < p.ordreJeu.size(); tour++){
				Joueur actif = p.getJoueurActif(tour);
				System.out.println("C'est au tour de " + actif.getNom()+ " de jouer !");
				
			}
			
		//}
	}
}
