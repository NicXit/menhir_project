package fr.utt.isi.lo02.menhir.modele.joueur;

import fr.utt.isi.lo02.menhir.modele.partie.Partie;

public class Humain extends Joueur{
	private int age;
	private boolean genreF;
	
	public Humain(String nom, int age, boolean genreF){
		super(nom);
		this.age=age;
		this.genreF=genreF;
	}
	
	public boolean getGenreF(){
		return this.genreF;
	}
	
	public int getAge(){
		return this.age;
	}


}
