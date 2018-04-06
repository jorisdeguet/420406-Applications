package org.mon_nom.app;

import org.mon_nom.impl.ChangeMon_Nom;
import org.mon_nom.interfaces.Change;
import org.mon_nom.impl.ServiceArgentMon_Nom;
import org.mon_nom.interfaces.ServiceArgent;
import org.mon_nom.utils.ArgentObjet;
import org.mon_nom.utils.StringUtils;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ScrapApp
{

	public static void main( String[] args )
	{
		Locale.setDefault(Locale.CANADA);
		Random rand = new Random();
		Scanner s = new Scanner(System.in);
		
		/**
		 * Changez ici pour tester vos propres classes
		 */
		ServiceArgent m = new ServiceArgentMon_Nom();  // changez le monnayeur par le vôtre
		
		while(true){
			double amount = 0.0;
			System.out.println("Entrez un montant entre 0 et 100 $ : (x POUR UN MONTANT AU HASARD)");
			if(!s.hasNextDouble()){
				s.next();
				amount = rand.nextInt(1000)*1.0 / 100;
			}
			else{
				amount = s.nextDouble();
			}
			System.out.println("################################## Calcul en cours pour "+amount + " sur 100$");
			try{
				System.out.println("Contenu du service tiroir caisse total : " + m.valeurTotale());
				Change donne = new ChangeMon_Nom();
				donne.ajouterItem(ArgentObjet.billet100,1);
				Change c = m.calculerChange(amount, donne);
				System.out.println("Change total : " + c.valeurTotale());
				System.out.println(StringUtils.toString(c));
				System.out.println("Contenu du service tiroir caisse total : " + m.valeurTotale());
				System.out.println(StringUtils.toString(m));
			}catch(Throwable e){
				e.printStackTrace();
			}
			System.out.println("##################################");
		}
	}
}
