package org.deguet;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by joris on 17-01-09.
 */
public class TestCalculImpot {

    @Test(timeout=1000, expected = ExceptionRevenuNegatif.class)
    public void testCalculMoins10000() throws ExceptionRevenuNegatif {
        CalculImpot calcul = new CalculImpot();
        Double res = calcul.calculerImpot(-10000.0);
        System.out.println("Le resultat est "+ res);
        //Assert.assertEquals(48000.0,res,0.0000000001);
    }

    @Test(timeout=1000)
    public void testCalcul19999() throws ExceptionRevenuNegatif {
        CalculImpot calcul = new CalculImpot();
        Double res = calcul.calculerImpot(19999.0);
        System.out.println("Le resultat est "+ res);
        Assert.assertEquals(1999.9,res,0.0000000001);
    }

    @Test(timeout=1000)
    public void testCalcul20000() throws ExceptionRevenuNegatif {
        CalculImpot calcul = new CalculImpot();
        Double res = calcul.calculerImpot(20000.0);
        System.out.println("Le resultat est "+ res);
        Assert.assertEquals(2000.0,res,0.0000000001);
    }

    @Test(timeout=1000)
    public void testCalcul20001() throws ExceptionRevenuNegatif {
        CalculImpot calcul = new CalculImpot();
        Double res = calcul.calculerImpot(20001.0);
        System.out.println("Le resultat est "+ res);
        Assert.assertEquals(2000.2,res,0.0000000001);
    }

    @Test(timeout=1000)
    public void testCalcul200000() throws ExceptionRevenuNegatif {
        CalculImpot calcul = new CalculImpot();
        Double res = calcul.calculerImpot(200000.0);
        System.out.println("Le resultat est "+ res);
        Assert.assertEquals(48000.0,res,0.0000000001);
    }

}
