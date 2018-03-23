package org.mon_nom.impl;

import org.mon_nom.interfaces.Change;
import org.mon_nom.interfaces.ServiceArgent;
import org.mon_nom.utils.ArgentObjet;


public class ServiceArgentMon_Nom implements ServiceArgent {

    public Change calculerChange(double montantDu, Change argentDonne) { throw new UnsupportedOperationException(); }

    public double arrondiA5sous(double montant) {
        throw new UnsupportedOperationException();
    }

    public String nomEtudiant() {
        throw new UnsupportedOperationException();
    }

    public int nombreItemsPour(ArgentObjet m) {
        throw new UnsupportedOperationException();
    }

    public void ajouterItem(ArgentObjet m, int nombre) {
        throw new UnsupportedOperationException();
    }

    public double valeurTotale() {
        throw new UnsupportedOperationException();
    }

    public int nombreTotalItems() {
        throw new UnsupportedOperationException();
    }

    public int capaciteMaxPour(ArgentObjet m) {
        throw new UnsupportedOperationException();
    }

    public void retirerItems(ArgentObjet m, int nombre) {
        throw new UnsupportedOperationException();
    }
}

