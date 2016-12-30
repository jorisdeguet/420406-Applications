package org.deguet;

/**
 * Interface pour le calcul du change et la gestion de tiroir caisse.
 *
 * L'interface ne fait pas l'hypothèse qu'un seul tiroir caisse existe.
 */
public interface ServiceArgent {

    class ArgentException extends Exception{}

    /**
     * Calcul le change a rendre pour le montant fourni en utilisant ce qui est disponible
     * dans le TiroirArgent.
     *
     * Le TiroirArgent est modifié par la méthode qui y enlève des ArgentObjet qui se
     * retrouve dans le change.
     *
     * Les objets ArgentObjet du Change renvoyé sont ceux qui sont pris dans TiroirArgent:
     * la somme des valeurs totales entre le tiroir avant et le tiroir + le change après devrait
     * être le même montant.
     *
     * @param montant
     * @param tiroir
     * @return
     * @throws ArgentException
     */
    Change calculerChange(double montant, TiroirArgent tiroir) ;

    /**
     * Calcul l'arrondi à 5 sous tel que décrit ici
     * http://www.cra-arc.gc.ca/gncy/lmntnpnny/menu-fra.html
     *
     * @param montant
     * @return
     */
    double arrondiA5sous(double montant);

    /**
     * Renvoie un tiroir caisse plein.
     * @return
     */
    TiroirArgent tiroirPlein();
	
}
