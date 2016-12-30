package org.deguet.stupide;

import org.deguet.ArgentObjet;
import org.deguet.Change;

import java.util.LinkedList;
import java.util.List;


public class StupideChange implements Change {

	List<ArgentObjet> items = new LinkedList<ArgentObjet>();
	
	public int nombreItemsPour(ArgentObjet m) {
		int result = 0;
		for (ArgentObjet i : items)
			if (i.equals(m))
				result++;
		return result;
	}

    public void ajouterItem(ArgentObjet m, int nombre) {
		for (int i = 0; i < nombre; i++){
			items.add(m);
		}
	}

	public double valeurTotale() {
		return 0;
	}
	public int nombreTotalItems() {
		return 0;
	}
}
