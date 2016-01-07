package fr.utt.isi.lo02.menhir.modele.carte;
/**
 * Classe qui définit les caractéristiques d'une carteAlliés
 * @author Mathieu DELALANDE, Nicolas GRANET
 */
public class CarteAllie extends Carte{
	public int[] value;
	
	/**
	 * Constructeur, définit une carte Alliés avec son nom et ses valeurs
	 * @param nom Le nom de la carte
	 * @param v La valeur de la carte
	 */
	public CarteAllie(String nom, int[] v) {
		super(nom);
		this.value = v;
	}
	
	public String toString(){
		return (this.nom+"\n"+this.value[0]+" "+this.value[1]+" "+this.value[2]+" "+this.value[3]+"\n");
	}
	
	public int[] getValue(){
		return this.value;
	}
}
