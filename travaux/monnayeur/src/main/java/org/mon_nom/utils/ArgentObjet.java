package org.mon_nom.utils;

public enum ArgentObjet {

	billet100	(10000),
	billet50	(5000),
	billet20	(2000),
	billet10	(1000),
	billet5	    (500),
	piece2	    (200),
	piece1	    (100),
    piece25s	(25),
    piece10s	(10),
    piece5s	    (5);
	
	public final int valeurEnCents;

	/**
	 * Constructeur prenant une valeur en cents.
	 * @param c
	 */
	private ArgentObjet(int c){ this.valeurEnCents = c; }
	
	public final Double valeur(){
		return valeurEnCents /100.0;
	}

	public final boolean estUnBillet() { return this.valeurEnCents > 300; }
}
