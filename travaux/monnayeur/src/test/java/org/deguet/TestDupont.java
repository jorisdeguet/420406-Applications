package org.deguet;

import org.deguet.stupide.StupideService;
import org.junit.Assert;
import org.junit.Test;


public class TestDupont implements TestChangeService {

    @Test
    public void testCalculateur999Dollars()  {

        String nom =            this.nomEtudiant();
        ServiceArgent m =        this.service();
        TiroirArgent cash = service().tiroirPlein();
        Change result = m.calculerChange((float) 111.00, cash);
        System.out.println("Change ::: " + StringUtils.toString(result));
        Assert.assertEquals("Ouch for  " + nom, result.nombreItemsPour(ArgentObjet.billet100), 1);
        Assert.assertEquals("Ouch for  " + nom, result.nombreItemsPour(ArgentObjet.billet10), 1);
        Assert.assertEquals("Ouch for  " + nom, result.nombreItemsPour(ArgentObjet.piece1), 1);

    }

	public ServiceArgent service() {
		return new StupideService();
	}
	public String nomEtudiant() {
		return "Dark Vador";
	}
	
}
