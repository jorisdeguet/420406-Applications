package org.deguet.stupide;

import org.deguet.ArgentObjet;
import org.deguet.TiroirArgent;

public class StupideTiroir implements TiroirArgent{

	public int nombreItemsPour(ArgentObjet m) {
		return Integer.MAX_VALUE;
	}
    public void retirerItems(ArgentObjet m, int number) {}
    public void ajouterItem(ArgentObjet m, int nombre) {}
    public double valeurTotale() {
		return Double.MAX_VALUE;
	}
	public int nombreTotalItems() {
		return Integer.MAX_VALUE;
	}
	public int capaciteMaxPour(ArgentObjet m) {
		return Integer.MAX_VALUE;
	}
	
}
