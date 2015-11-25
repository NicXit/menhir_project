package fr.utt.isi.lo02.menhir.controleur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.carte.Paquet;
import fr.utt.isi.lo02.menhir.modele.enumeration.Saison;
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
		int valeurJuste = 0;
		int nbHumain = 0;

		
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
		//paquet.distribuerCarteAllieJoueur(p.ordreJeu.get(0));
		
		for (Saison saison : Saison.values()){
			System.out.println(newLine+"Saison en cours : "+saison);
			//if (p.getTypePartie() == TypePartie.rapide){
			for(int numOrdreJoueur = 0; numOrdreJoueur < p.ordreJeu.size(); numOrdreJoueur++){
				Joueur actif = p.getJoueurActif(numOrdreJoueur);
				System.out.println(newLine+"C'est au tour de " + actif.getNom()+ " de jouer !");
				System.out.println("Choisir une carte : ");			
				for(Iterator<CarteIngredient> it = actif.getCarteIngredientJoueur().iterator(); it.hasNext();){
					CarteIngredient carte = (CarteIngredient) it.next();
					System.out.println(carte.toString());
				}
				int choixCarte = sc.nextInt();
				System.out.println("Vous avez choisi la carte : " + newLine + actif.getCarteIngredientJoueur().get(choixCarte-1));
				System.out.println("Choisir une action : ");
				
								
				//}
			}
		}
		
		
	}
}
