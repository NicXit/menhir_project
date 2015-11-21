package fr.utt.isi.lo02.menhir.modele.carte;

public class CarteIngredient extends Carte {
	public int[] value;
	
	public CarteIngredient(String nom, int[] v) {
		super(nom);
		this.value = v;
	}
	
}