package fr.utt.isi.lo02.menhir.modele.carte;

public class CarteIngredient extends Carte {
	public int[] value = new int[12];

	
	public CarteIngredient(String nom, int[] v) {
		super(nom);
		this.value = v;
	}
	
	public String toString(){
		return (this.nom+"\n"+"G : "+this.value[0]+" "+this.value[1]+" "+this.value[2]+" "+this.value[3]
				+"\n"+"E : "+this.value[4]+" "+this.value[5]+" "+this.value[6]+" "+this.value[7]+"\n"
				+"F : "+this.value[8]+" "+this.value[9]+" "+this.value[10]+" "+this.value[11]+"\n");
	}
	
	public int[] getValue(){
		return this.value;
	}
		
}