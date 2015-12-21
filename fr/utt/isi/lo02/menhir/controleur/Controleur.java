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
import fr.utt.isi.lo02.menhir.modele.joueur.Humain;
import fr.utt.isi.lo02.menhir.modele.joueur.IA;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.*;
import fr.utt.isi.lo02.menhir.vue.VuePartie;

public class Controleur {
	
	
	public static void main(String[] args) {
		// TEST
		
		Paquet paquet = new Paquet();
		String newLine = System.getProperty("line.separator");
		
		Scanner sc = new Scanner(System.in);
		Partie p = new Partie();
		int valeurJuste = 0, indiceChoix =0, nbHumain = 0, choixAction=1, choixCarte =0, numManche=0, value = 0, valCarte[], valueCarteAllie = 0;
		String nomJoueurGagnant, typePartie;
		char reponseBonusAvancee, choixTypePartie;
		Action[] tabChoixAction = Action.values();
		Saison[] tabSaison = Saison.values();
		
		//-------------------------Ajout interface graphique----------------
		  
		ControleurVue c = new ControleurVue();
		
		//---------------------Fin interface grapique--------------------
		
		System.out.println("*** JEU MENHIR ***");

		do{
			System.out.println("Combien de joueurs Humains (1..6) ?");
			nbHumain = sc.nextInt();
			sc.nextLine();
			
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
			System.out.println("Combien de joueurs IA (0.."+(6-nbHumain)+") ?");
			int nbIA = sc.nextInt();
			sc.nextLine();
			
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
		
		
		
		
		do{
			//on choisit le type de partie
			System.out.println("Choisir le type de partie (r/a)");
			for (TypePartie t : TypePartie.values()) {
				System.out.println(t);
			}	
			choixTypePartie = sc.nextLine().charAt(0);
			
			//initialisation des graines des joueurs
			for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
				Joueur j = (Joueur) it.next();
				j.setNbGraines(2);							
			}
			switch (choixTypePartie){
			
				//si partie rapide on initialise le nombre de graines des joueurs à 2 et le nombre de manche à 1		
				case 'r' :	   		
		            p.setTypePartie(TypePartie.rapide);
		            p.setNbManche(1);
		            
		            
		            	           
		            break;
		            /**
		             * si partie avancée on demande à l'utilisateur s'il préfère les graines ou une carte Alliés 
		             * et on initialise le nombre de manches au nombre de joueurs
		             */
				case 'a' :				
						p.setTypePartie(TypePartie.avancée);						
						p.setNbManche(p.ordreJeu.size());
					break;
					default :
						System.out.println("type de partie incorrect");
		        }
		}while (choixTypePartie != 'r' && choixTypePartie != 'a');		
		System.out.println("Vous avez choisi la partie " + p.getTypePartie());
		
		for (numManche = 1; numManche <= p.getNbManche(); numManche++){
			paquet.genererPaquetIngredient();
			paquet.genererPaquetAllie();
			paquet.distribuerCartesIngredientsJoueur(p.ordreJeu);	
			if (p.getTypePartie().equals(TypePartie.avancée)){
				for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
					Joueur j = (Joueur) it.next();							
					
					//Si c'est un humain on lui propose un choix
						if (j instanceof Humain){
							do{
								System.out.println(j.getNom() + " voulez vous prendre 2 graines ou piocher une carte Alliés ? (g/a)");
								reponseBonusAvancee = sc.nextLine().charAt(0);
								if (reponseBonusAvancee == 'g'){
									j.setNbGraines(j.getNbGraines()+2);
									j.setCarteAllieJoueur(new CarteAllie("",null));
									System.out.println("Vous avez récupéré 2 graines !");
								}
								else  if (reponseBonusAvancee == 'a'){
									paquet.distribuerCarteAllieJoueur(j);
									System.out.println("Vous avez pioché une carte " + j.getCarteAllieJoueur());
								}
								else
									System.out.println("réponse incorrect");
							}while (reponseBonusAvancee != 'g' && reponseBonusAvancee != 'a');
						}
						// si c'est un IA le choix est random
						else{
								int ran = (int)(Math.random()*2);
								if(ran == 0)
								{
									paquet.distribuerCarteAllieJoueur(j);
									System.out.println(j.getNom() +" a pioché une carte " + j.getCarteAllieJoueur().nom);
								}
								else
								{
									j.setNbGraines(j.getNbGraines()+2);
									j.setCarteAllieJoueur(new CarteAllie("",null));
									System.out.println(j.getNom() + " a récupéré 2 graines !");
								}
							}
						}
						
					
					
				}
			
			// On parcourt chaque saison pour correspondre à un tour de jeu
    		for (Saison saison : Saison.values()){
    			p.setSaison(saison);
    			System.out.println(newLine+"Saison en cours : "+saison+newLine);
    			
    			//on rappelle le nombre de graines et de menhirs de chacun
    			for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
    				Joueur j = (Joueur) it.next();
    				System.out.println(j.getNom()+" a " + j.getNbGraines() + " graines et " + j.getNbMenhir() + " menhirs.");
    			}
    			
    			//PHASE DE JEU AVEC LES TAUPE GEANTES
    			if(p.getTypePartie().equals(TypePartie.avancée)){
    				for (Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
        				Joueur j = (Joueur) it.next();

        				
        				
        				//Si le joueur a une carte Allie de type taupe géante et est un humain
        					if (j.getCarteAllieJoueur().getNom().equals("La taupe géante") && j instanceof Humain){
	            					System.out.println(newLine+j.getNom() + " voulez vous jouer la carte (o/n)" +newLine + j.getCarteAllieJoueur());
	            					reponseBonusAvancee= sc.nextLine().charAt(0);
	            					if (reponseBonusAvancee == 'o'){
	            						for(Iterator<Joueur> it2 = p.ordreJeu.iterator(); it2.hasNext();){
	                						Joueur j2 = (Joueur) it2.next();
	                						System.out.println(j2.getNom()+" a " + j2.getNbGraines() + " graines et " + j2.getNbMenhir() + " menhirs.");
	                					}
	            						System.out.println("Quel joueur voulez vous attaquer ? ");
	                					String nomJoueurAttaque = sc.nextLine();
	                					
	    		        					//on parcourt la liste de joueurs en comparant chaque nom de joueur au nom rentré par l'utilisateur
	    	        					for(Iterator<Joueur> it2 = p.ordreJeu.iterator(); it2.hasNext();){
	    	        						Joueur joueurAttaque = (Joueur) it2.next();
	    	        						valCarte=j.getCarteAllieJoueur().getValue();
	    	        						
	    	        						//nombre de saisons - nombre de cartes du dernier joueur
	    	        						value=valCarte[tabSaison.length - p.ordreJeu.get(p.ordreJeu.size()-1).getCarteIngredientJoueur().size()];
	    	        						
	    	        						//si le joueur éxiste on appelle la fonction TaupeGeante
	    	        						if(joueurAttaque.getNom().equals(nomJoueurAttaque)){							
	    	        							System.out.println("Le joueur : " + j.getNom() +" a utilisé Taupe Géante et détruit "+value+" menhirs de " +joueurAttaque.getNom());
	    	        							p.effectuerActionTaupeGeante(value, joueurAttaque);
	    	        							j.setCarteAllieJoueur(new CarteAllie("",null));
	    	        							break;
	    	        						}
	    	            				}
	    	        						
	    	        				}
            					
    	        			}
        					else if(j.getCarteAllieJoueur().getNom().equals("La taupe géante")){
        						if(saison == Saison.automne){
        							valCarte=j.getCarteAllieJoueur().getValue();
	        						value=valCarte[tabSaison.length - p.ordreJeu.get(p.ordreJeu.size()-1).getCarteIngredientJoueur().size()];
	        						
	        						int place = (int)(Math.random()*p.ordreJeu.size());
        							Joueur joueur = p.ordreJeu.get(place);
        							if (joueur != j && joueur.getNbMenhir() != 0){
        								if (joueur.getNbMenhir() <= value){
        									j.setNbMenhir(j.getNbMenhir()+ joueur.getNbMenhir());
        									joueur.setNbMenhir(0);
        									j.setCarteAllieJoueur(new CarteAllie("",null));
        									System.out.println("Le joueur : " + j.getNom() +" a utilisé Taupe Géante et détruit "+value+" menhirs de " +joueur.getNom());
        								}
        								else{
        									j.setNbMenhir(j.getNbMenhir()+ joueur.getNbMenhir());
        									joueur.setNbMenhir(joueur.getNbMenhir() - value);
        									j.setCarteAllieJoueur(new CarteAllie("",null));
        									System.out.println("Le joueur : " + j.getNom() +" a utilisé Taupe Géante et détruit "+value+" menhirs de " +joueur.getNom());
        								}
        							}
        						}
        							
        					}
        				

        			}
	    		}  
    			//on fait jouer les joueurs les uns après les autres
    			for(int numOrdreJoueur = 0; numOrdreJoueur < p.ordreJeu.size(); numOrdreJoueur++){
    			  			
    				
    				Joueur actif = p.getJoueurActif(numOrdreJoueur);
    				System.out.println(newLine+"C'est au tour de " + actif.getNom()+ " de jouer !");
    				
    				//choix de la carte et de l'action pour un humain
    				if (actif instanceof Humain){
    					System.out.println("Choisir une carte (1/2/3/4) : ");
        				
        				//on affiche toutes les cartes d'un joueur
        				for(Iterator<CarteIngredient> it = actif.getCarteIngredientJoueur().iterator(); it.hasNext();){
        					CarteIngredient carte = (CarteIngredient) it.next();
        					System.out.println(carte.toString());
        				}	
        				choixCarte = sc.nextInt();
        				System.out.println("Choisir l'action à effectuer (1/2/3) : ");
        				System.out.println("1) G : "+actif.getCarteIngredientJoueur().get(choixCarte-1).getValuePrecise(0,tabSaison.length - actif.getCarteIngredientJoueur().size() + 1));
        				System.out.println("2) E : "+actif.getCarteIngredientJoueur().get(choixCarte-1).getValuePrecise(1,tabSaison.length - actif.getCarteIngredientJoueur().size() + 1));
        				System.out.println("3) F : "+actif.getCarteIngredientJoueur().get(choixCarte-1).getValuePrecise(2,tabSaison.length - actif.getCarteIngredientJoueur().size() + 1));
        				
        				//on demande à l'utilisateur de choisir une action
        				do{
        					choixAction = sc.nextInt();	
        					sc.nextLine();
        					
        					if (choixAction > tabChoixAction.length || choixAction <= 0){						
        						System.out.println("numéro d'action incorrecte");
        						sc.next();
        					}						
        				}while (choixAction > tabChoixAction.length || choixAction <= 0);
        				
        				//on récupère la valeur de l'action
        				valCarte = actif.getCarteIngredientJoueur().get(choixCarte-1).getValue();
        				indiceChoix = valCarte.length/tabChoixAction.length * (choixAction-1) + tabSaison.length - actif.getCarteIngredientJoueur().size();
        				value = valCarte[indiceChoix];
        				System.out.println("Vous avez choisi l'action " + tabChoixAction[choixAction-1] + " qui a pour valeur " + value);
    				}
    				/**
    				 * choix de l'action et de la carte pour un IA
    				 * A MODIFIER POUR LA SORTIE TEXTE
    				 */
    				else{
    					System.out.println(((IA) actif).getStrategy().jouer(actif, actif.getCarteIngredientJoueur(), tabSaison.length - actif.getCarteIngredientJoueur().size() + 1, p));
    				}
    				
    				//en fonction du choix de l'action on appelle sa méthode
    				if (actif instanceof Humain){
    				switch (choixAction)
    				{				
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
    					
    						System.out.println("Quel joueur voulez vous attaquer ? ");
        					String nomJoueurAttaque = sc.nextLine();
        					
        					//on parcourt la liste de joueurs en comparant chaque nom de joueur au nom rentré par l'utilisateur
        					for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
        						Joueur joueurAttaque = (Joueur) it.next();
        						
        						//si le joueur éxiste on appelle la fonction farfadet
        						if(joueurAttaque.getNom().equals(nomJoueurAttaque)){
        							
      
        							//on test si on est en partie avancée et si le joueur attaqué peut se défendre avec Chien de garde
        							if (p.getTypePartie().equals(TypePartie.avancée) && joueurAttaque.getCarteAllieJoueur() != null ){
        								
        	
        								if (joueurAttaque.getCarteAllieJoueur().nom.equals("Chien de garde")){
	        								System.out.println(joueurAttaque.getNom()+" voulez-vous utiliser la carte (o/n)"+ newLine + joueurAttaque.getCarteAllieJoueur());
	        								reponseBonusAvancee= sc.nextLine().charAt(0);
	        	        					if (reponseBonusAvancee == 'o'){
	        	        						valCarte=joueurAttaque.getCarteAllieJoueur().getValue();                    						
	                    						//nombre de saisons - nombre de cartes du dernier joueur
	                    						valueCarteAllie=valCarte[tabSaison.length - p.ordreJeu.get(p.ordreJeu.size()-1).getCarteIngredientJoueur().size()];
	                    						
	                    						if (value >= valueCarteAllie){
	                    							p.effectuerActionFarfadets(value-valueCarteAllie, actif, joueurAttaque);
	                    							System.out.println("Le joueur : " + actif.getNom() +" vole des graines à " +joueurAttaque.getNom() + " avec sa carte de valeur " 
	                    							+ value +" mais "+joueurAttaque.getNom()+" se défend avec sa carte "+newLine + joueurAttaque.getCarteAllieJoueur());
	                    						}
	                    						else{                    							
	                    							System.out.println("Le joueur : " + actif.getNom() +" ne vole pas de graine car "+ joueurAttaque.getNom()+" s'est défendu avec sa carte "
	                    							+ newLine + joueurAttaque.getCarteAllieJoueur());
	                    							}
	                    						joueurAttaque.setCarteAllieJoueur(new CarteAllie("",null));
	        	        					}
	        	        					else{
	            								System.out.println("Le joueur : " + actif.getNom() +" vole des graines à " +joueurAttaque.getNom() + " avec sa carte de valeur " + value);
	        	        						p.effectuerActionFarfadets(value, actif, joueurAttaque);
	        	        					}
        								}
        								else{
            								System.out.println("Le joueur : " + actif.getNom() +" vole des graines à " +joueurAttaque.getNom() + " avec sa carte de valeur " + value);
        									p.effectuerActionFarfadets(value, actif, joueurAttaque);
        								}
        							}
        							else{
        								System.out.println("Le joueur : " + actif.getNom() +" vole des graines à " +joueurAttaque.getNom() + " avec sa carte de valeur " + value);
        								p.effectuerActionFarfadets(value, actif, joueurAttaque);
        							}  							
        							break;
        						}
        					}
    					break;
    				}
    				
    				//on supprime la carte quand le joueur a fini de jouer
    				actif.getCarteIngredientJoueur().remove(choixCarte-1);
    				}	    			
    			}
    		}
    		for (Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
				Joueur j = (Joueur) it.next();
				j.setCarteAllieJoueur(new CarteAllie("",null));					
				if(p.getTypePartie().equals(TypePartie.avancée)){
					j.setNbGraines(0);
					j.setNbPoints(j.getNbPoints()+j.getNbMenhir());
					j.setNbMenhir(0);
					
					if(numManche != p.getNbManche())
						System.out.println(j.getNom()+" a " + j.getNbPoints() + " points.");						
					else						
						j.setNbMenhir(j.getNbPoints());
				}
    		}
		}
		
		System.out.println(newLine+"La partie est finie.");
		
		//On tri les joueurs par ordre de Score
		p.triOrdreScore();
		
		if(p.getTypePartie().equals(TypePartie.rapide)){
			//rappelle le nombre de graines et de menhirs de chacun
			for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
				Joueur j = (Joueur) it.next();
				System.out.println(j.getNom()+" a " + j.getNbGraines() + " graines et " + j.getNbMenhir() + " menhirs.");
			}
		}
		else{
			for(Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
				Joueur j = (Joueur) it.next();
				System.out.println(j.getNom()+" a " + j.getNbMenhir() + " points.");
			}
		}
	}

}
