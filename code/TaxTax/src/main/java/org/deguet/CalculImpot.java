package org.deguet;

/**
 * Created by joris on 17-01-09.
 */
public class CalculImpot {

    /**
     * Cette méthode calcule l'impot sur le revenu
     * @param revenu
     * @return
     * @throws ExceptionRevenuNegatif si le revenu est négatif
     */
    public Double calculerImpot(Double revenu) throws ExceptionRevenuNegatif {
        // Double.PositiveInfinity Double.NaN
        if (revenu < 0){
            throw new ExceptionRevenuNegatif();
        }
        Double resultat = 0.0;
        if (revenu <= 20000){
            return revenu * 0.10;
        }
        // revenu > 20000 revenue <= 100000
        else if (revenu <= 100000){
            resultat = 2000.0;
            resultat += (revenu-20000) * 0.20;
            return resultat;
        }
        else{
            resultat = 2000.0;
            resultat += 16000.0;
            resultat += (revenu-100000) * 0.30;
            return resultat;
        }
    }

}
