package org.mon_nom;

public interface TiroirCaisse {

    /**
     * Renvoie le nombre d'items de ce type contenu dans cet objet
     * @param m type
     * @return
     */
    int nombreItemsPour(ArgentObjet m);

    /**
     * Ajouter un objet du type spécifié m fois.
     * @param m
     * @param nombre
     */
    void ajouterItem(ArgentObjet m, int nombre);

    /**
     * Renvoie la valeur totale de l'objet en dollars
     * @return
     */
    double valeurTotale();

    /**
     * Renvoie le nombre total d'items contenu dans cet objet.
     * @return
     */
    int nombreTotalItems();
    
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
