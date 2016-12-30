package org.mon_nom;

public enum ArgentObjet {

	billet100	(10000, 	"billet 100$ "),
	billet50	(5000, 	    "billet 50$"),
	billet20	(2000, 	    "billet 20$"),
	billet10	(1000, 	    "billet 10$ "),
	billet5	    (500, 	    "billet 5$ "),
	piece2	    (200, 	    "pièce 2$ "),
	piece1	    (100, 	    "pièce 1$ "),
    piece25s	(25, 	    "pièce 0.25$ "),
    piece10s	(10, 	    "pièce 0.10$ "),
    piece5s	    (5, 	    "pièce 0.5$ "),
    piece1s	    (1, 	    "pièce 0.1$ ");
	
	public final int valeurEnCents;
	
	public final String nomLisible;
	
	ArgentObjet(int c, String pretty){
		this.valeurEnCents = c;
		this.nomLisible = pretty;
	}
	
	public Double valeur(){
		return valeurEnCents /100.0;
	}
	
	public String nomLisible(){return this.nomLisible;}
	
}
