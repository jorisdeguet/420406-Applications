package org.mon_nom.interfaces;

import org.mon_nom.utils.ArgentObjet;

/**
 * Interface pour le calcul du change et la gestion de tiroir caisse.
 *
 * La classe d'implantation doit avoir un constructeur sans paramètre.
 *
 * Cette classe doit maintenir l'état correspondant à un tiroir caisse soit
 * l'argent actuellement contenu dans le service.
 *
 * Ce constructeur doit renvoyer un nouvel objet service :
 * - à moitié plein pour tous billets
 * - à moitié plein pour toutes les pièces
 *
 */
public interface ServiceArgent {

    class ArgentException extends Exception{}

    /**
     * Calcul le change a rendre pour le montant fourni en utilisant l'argent disponible.
     *
     * Le contenu est modifié par la méthode si la transaction est possible
     * - y ajoute les objets du change donné en paramètre
     * - y enlève les objets qui se retrouve dans le change rendu.
     *
     * Les objets ArgentObjet du Change renvoyé sont ceux qui sont pris dans le service:
     * la somme des valeurs totales entre
     * - le service avant
     * - le service après + le change après
     * devraient être le même montant, et le même nombre d'objets pour chaque type d'objet.
     *
     * @param montantDu est le montant du par la personne
     * @param argentDonne l'argent donné par la personne pour payer le montant dû
     * @return un change dont le montant correspond à la différence entre l'argent donné et le montant du arrondi
     * à 5 sous
     * @throws ArgentException dans les cas où un paramètre est mauvais ou si l'argent donné n'est pas suffisant pour
     * le montant dû
     */
    Change calculerChange(double montantDu, Change argentDonne) ;

    /**
     * Calcul l'arrondi à 5 sous tel que décrit ici
     * http://www.cra-arc.gc.ca/gncy/lmntnpnny/menu-fra.html
     *
     * @param montant
     * @return
     */
    double arrondiA5sous(double montant);

    /**
     * Doit renvoyer le nom de l'étudiant dont ceci est le travail.
     * @return
     */
    String nomEtudiant();

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
     * Doit renvoyer 40 pour chaque type billet
     * Doit renvoyer 50 pour chaque type pièce
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
