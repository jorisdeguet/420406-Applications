package org.mon_nom.app;

import org.mon_nom.Change;
import org.mon_nom.TiroirCaisse;
import org.mon_nom.impl.ServiceArgentMon_Nom;
import org.mon_nom.impl.TiroirCaisseMon_Nom;
import org.mon_nom.service.ServiceArgent;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ConsoleApp
{

	public static void main( String[] args )
	{
		Locale.setDefault(Locale.CANADA);
		Random rand = new Random();
		Scanner s = new Scanner(System.in);
		
		/**
		 * Changez ici pour tester vos propres classes
		 */
		TiroirCaisse r = new TiroirCaisseMon_Nom(); // changez la caisse par votre caisse
		ServiceArgent m = new ServiceArgentMon_Nom().serviceAvecTiroirMoitiePlein();  // changez le monnayeur par le vôtre
		
		while(true){
			double amount = 0.0;
			System.out.println("Entrez un montant : (x POUR UN MONTANT AU HASARD)");
			if(!s.hasNextDouble()){
				s.next();
				amount = rand.nextInt(10000)*1.0 / 100;
			} 
			else{
				amount = s.nextDouble();
			}
			System.out.println("################################## Calcul en cours pour "+amount);
			try{
				Change c = m.calculerChange(amount);
				System.out.println("Change total : " + c.valeurTotale());
				System.out.println(StringUtils.toString(c));

				System.out.println(StringUtils.toString(r));
			}catch(Throwable e){
				e.printStackTrace();
			}
			System.out.println("##################################");
		}
	}
}
