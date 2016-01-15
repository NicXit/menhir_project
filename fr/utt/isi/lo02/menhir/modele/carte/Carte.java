package fr.utt.isi.lo02.menhir.modele.carte;
/**
 * Classe abstraite qui définit ce que doit avoir une carte
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public abstract class Carte {
	public String nom;
	
	/**
	 * Constructeur de Carte
	 * @param nom Le nom de la carte
	 */
	public Carte(String nom) {
		this.nom = nom;
	}
	/**
	 * 
	 * @return Le détail de ce qu'a joué l'IA
	 */
	public String getNom(){
		return this.nom;
	}
}
