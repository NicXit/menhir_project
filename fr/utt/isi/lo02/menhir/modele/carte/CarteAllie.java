package fr.utt.isi.lo02.menhir.modele.carte;

public class CarteAllie extends Carte{
	public int[] value;
	
	public CarteAllie(String nom, int[] v) {
		super(nom);
		this.value = v;
	}
}
