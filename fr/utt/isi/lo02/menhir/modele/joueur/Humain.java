package fr.utt.isi.lo02.menhir.modele.joueur;


public class Humain extends Joueur implements Comparable<Humain>{
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
