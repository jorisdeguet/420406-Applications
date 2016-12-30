package org.deguet.stupide;

import org.deguet.ArgentObjet;
import org.deguet.ServiceArgent;
import org.deguet.Change;
import org.deguet.TiroirArgent;

import java.util.Random;


public class StupideService implements ServiceArgent {

	public Change calculerChange(double montant, TiroirArgent tiroir) {
		Change result = new StupideChange();
		
		double remaining = montant;
		Random r = new Random();
		while (remaining > 0.01){
            ArgentObjet random = ArgentObjet.values()[r.nextInt(ArgentObjet.values().length)];
			double coin  = random.valeur();
			if (coin < remaining){
				remaining -= coin;
				result.ajouterItem(random, 1);
			}
		}
		return result;
	}

    public double arrondiA5sous(double montant) {
        return montant;
    }

    public TiroirArgent tiroirPlein() {
        return new StupideTiroir();
    }
}

