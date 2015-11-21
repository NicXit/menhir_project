package fr.utt.isi.lo02.menhir.modele.carte;

public class CarteAllie extends Carte{
	public int[] value;
	
	public CarteAllie(String nom, int[] v) {
		super(nom);
		this.value = v;
	}
	
	public String toString(){
		return (this.nom+"\n"+this.value[0]+" "+this.value[1]+" "+this.value[2]+" "+this.value[3]+"\n");
	}
}
