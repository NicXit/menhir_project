package fr.utt.isi.lo02.menhir.modele.joueur;

import fr.utt.isi.lo02.menhir.modele.partie.Partie;

public class Humain extends Joueur{
	private int age;
	private boolean genre;
	
	public Humain(String nom, int age, boolean genre, Partie partie){
		super(nom,partie);
		this.age=age;
		this.genre=genre;
	}
	


}
