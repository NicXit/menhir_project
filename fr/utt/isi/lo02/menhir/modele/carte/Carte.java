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
	 */
	public Carte(String nom) {
		this.nom = nom;
	}
	
	public String getNom(){
		return this.nom;
	}
}
