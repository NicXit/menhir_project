package fr.utt.isi.lo02.menhir.controleur;

import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.carte.Paquet;
import java.util.Scanner;

public class Controleur {

	public static void main(String[] args) {
		/** TEST
		Paquet paquet = new Paquet();
		paquet.genererPaquetIngredient();
		
	       for(CarteIngredient c: paquet.cartesIngredient)
	       {
	       	 System.out.println (c.nom);
	       	 for(int v: c.value)
		     {
	       		 System.out.println (v);
		     }
	       }
	       
	       paquet.genererPaquetAllie();
			
	       for(CarteAllie c: paquet.cartesAllie)
	       {
	       	 System.out.println (c.nom);
	       	 for(int v: c.value)
		     {
	       		 System.out.println (v);
		     }
	       }**/
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*** JEU MENHIR ***");
		
		
		System.out.println("Veuillez choisir un type de partie (rapide/avancée) ?");
		String choix = sc.nextLine();
		//choisirPartie(choix);
		
		System.out.println("Combien de joueurs Humains (2..6) ?");
		int nbHumain = sc.nextInt();
		
		for(int i=0; i < nbHumain; i++){
			//ajouterHumain();
		}
		
		System.out.println("Combien de joueurs IA (2..5) ?");
		int nbIA = sc.nextInt();
		
		for(int i=0; i < nbIA; i++){
			//ajouterIA();
		}
	}		
}
