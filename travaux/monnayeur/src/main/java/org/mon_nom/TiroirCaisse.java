package org.mon_nom;

public interface TiroirCaisse extends Change{

    /**
     * Renvoie la capacité maximale de ce Tiroir pour ce type d'items
     * @param m
     * @return
     */
    int capaciteMaxPour(ArgentObjet m);

    /**
     * Retire plusieurs items du meme type
     * @param m le type
     * @param nombre le nombre d'items à retirer
     */
    void retirerItems(ArgentObjet m, int nombre);
	
}
