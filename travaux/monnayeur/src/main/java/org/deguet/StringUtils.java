package org.deguet;

/**
 * Classe permettant d'afficher facilement une caisse ou du change dans la console
 * @author joris
 *
 */
public class StringUtils {

	public static String toString(TiroirArgent tiroir){
		String result = "Tiroir ::: \n";
		for (ArgentObjet m : ArgentObjet.values()){
			result += "  "+String.format("%10s", tiroir.nombreItemsPour(m)+"")+"    @    "+m.nomLisible()+"\n";
		}
		return result;
	}

	public static String toString(Change change){
		String result = "Change ::: \n";
		for (ArgentObjet m : ArgentObjet.values()){
			if (change.nombreItemsPour(m) > 0){
				result += "  "+String.format("%10s", change.nombreItemsPour(m)+"")+"    @    "+m.nomLisible()+"\n";
			}
		}
		return result;
	}

}
