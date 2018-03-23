package org.mon_nom.interfaces;

import org.mon_nom.utils.ArgentObjet;

public interface Change {

    /**
     * Renvoie le nombre d'items de ce type contenu dans cet objet
     * @param m type
     * @return
     */
    int nombreItemsPour(ArgentObjet m);

    /**
     * Ajouter un objet du type spécifié m fois.
     * la valeur 0 comme nombre est accepté.
     * les valeurs négatives amènent une exception significative
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

}
