package org.mon_nom.service;

import org.mon_nom.Change;
import org.mon_nom.TiroirCaisse;

/**
 * Interface pour le calcul du change et la gestion de tiroir caisse.
 */
public interface ServiceArgent {

    class ArgentException extends Exception{}

    /**
     * Calcul le change a rendre pour le montant fourni en utilisant ce qui est disponible
     * dans le TiroirCaisse.
     *
     * Le TiroirCaisse est modifié par la méthode qui y enlève des ArgentObjet qui se
     * retrouve dans le change.
     *
     * Les objets ArgentObjet du Change renvoyé sont ceux qui sont pris dans TiroirCaisse:
     * la somme des valeurs totales entre
     * - le tiroir avant
     * - le tiroir après + le change après
     * devraient être le même montant, et le même nombre d'objets pour chaque type d'objet.
     *
     * @param montant
     * @return
     * @throws ArgentException
     */
    Change calculerChange(double montant) ;

    /**
     * Calcul l'arrondi à 5 sous tel que décrit ici
     * http://www.cra-arc.gc.ca/gncy/lmntnpnny/menu-fra.html
     *
     * @param montant
     * @return
     */
    double arrondiA5sous(double montant);

    /**
     * Renvoie une référence vers le tiroir caisse de ce service.
     * Permet de consulter l'état du tiroir ou d'y rajouter de l'argent.
     * @return
     */
    TiroirCaisse getTiroir();

    /**
     * Doit renvoyer le nom de l'étudiant dont ceci est le travail.
     * @return
     */
    String nomEtudiant();

    /**
     * Doit renvoyer un nouvel objet service qui contient un TiroirCaisse:
     * - à moitié plein pour tous les objets (billets ou pièces)
     * - vide pour les pièces de 1 sou (puisqu'on ne peut pas en rendre, uniquement)
     * @return
     */
    ServiceArgent serviceAvecTiroirMoitiePlein();
	
}
