package fr.utt.isi.lo02.menhir.modele.joueur;

/**
 * Classe qui définit un joueur humain
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class Humain extends Joueur implements Comparable<Humain>{
	private int age;
	private boolean genreF;
	
	/**
	 * Constructeur, définit un humain par son nom, son age et son genre
	 * @param nom Le nom du joueur humain
	 * @param age L'age du joueur humain
	 * @param genreF Le genre du joueur humain ('o' si féminin et 'n' si masculin)
	 */
	public Humain(String nom, int age, char genreF){
		super(nom);
		this.age=age;
		if (genreF == 'o')
			this.genreF=true;
		else if (genreF == 'n')
			this.genreF=false;
	}
	
	public boolean getGenreF(){
		return this.genreF;
	}
	
	public int getAge(){
		return this.age;
	}
	
	/**
	 * Compare les instances de la classes Humain entre elles et les trie selon leur genre puis leur age.
	 * @param autreHumain L'humain à comparer
	 */
	public int compareTo(Humain autreHumain)
	   {
	      int resultat = 0;
	      if (this.genreF == true){
	    	  if (autreHumain.genreF == false)
	    		  resultat = -1;
	    	  if (this.age > autreHumain.age && autreHumain.genreF == true)
	    		  resultat = 1;
	    	  if (this.age < autreHumain.age && autreHumain.genreF == true)
	    		  resultat = -1;
	    	  if (this.age == autreHumain.age && autreHumain.genreF == true)
	    		  resultat = 0;
	      }
	      else{
	    	  if (autreHumain.genreF == true)
	    		  resultat = 1;
	    	  if (this.age > autreHumain.age && autreHumain.genreF == false)
	    		  resultat = 1;
	    	  if (this.age < autreHumain.age && autreHumain.genreF == false)
	    		  resultat = -1;
	    	  if (this.age == autreHumain.age && autreHumain.genreF == false)
	    		  resultat = 0;
	      }
	      return resultat;
	   }


}
