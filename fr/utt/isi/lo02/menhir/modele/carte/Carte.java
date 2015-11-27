package fr.utt.isi.lo02.menhir.modele.carte;

public abstract class Carte {
	public String nom;
	
	public Carte(String nom) {
		this.nom = nom;
	}
	
	
	
	public String toString(){
		return this.nom;
	}
	
	public String getNom(){
		return this.nom;
	}
}
