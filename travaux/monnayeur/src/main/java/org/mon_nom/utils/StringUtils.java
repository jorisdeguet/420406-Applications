package org.mon_nom.utils;

import org.mon_nom.interfaces.Change;
import org.mon_nom.interfaces.ServiceArgent;

/**
 * Classe permettant d'afficher facilement une caisse ou du change dans la console
 * @author joris
 *
 */
public class StringUtils {

	public static final String toString(ServiceArgent tiroir){
		String result = "Tiroir ::: \n";
		for (ArgentObjet m : ArgentObjet.values()){
			result += "  "+String.format("%10s", tiroir.nombreItemsPour(m)+"")+"    @    "+nomFrancaisDe(m)+"\n";
		}
		return result;
	}

	public static final String toString(Change change){
		String result = "Change ::: \n";
		for (ArgentObjet m : ArgentObjet.values()){
			if (change.nombreItemsPour(m) > 0){
				result += "  "+String.format("%10s", change.nombreItemsPour(m)+"")+"    @    "+nomFrancaisDe(m)+"\n";
			}
		}
		return result;
	}

	public static final String nomFrancaisDe(ArgentObjet ao){
		switch (ao){
			case billet100: return "billet 100$ ";
			case billet50: return  "billet 50$";
			case billet20: return "billet 20$";
			case billet10: return "billet 10$ ";
			case billet5: return "billet 5$ ";
			case piece2: return "pièce 2$ ";
			case piece1: return "pièce 1$ ";
			case piece25s: return  "pièce 0.25$ ";
			case	piece10s:	return  "pièce 0.10$ ";
			case	piece5s:	return  "pièce 0.05$ ";
		}
		throw new UnsupportedOperationException();
	}

}
