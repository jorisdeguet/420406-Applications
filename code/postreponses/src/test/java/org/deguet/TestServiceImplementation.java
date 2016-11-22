package org.deguet;

import org.deguet.exceptions.MauvaisPost;
import org.deguet.exceptions.MauvaisReponse;
import org.deguet.modele.Post;
import org.deguet.modele.Reponse;
import org.deguet.service.Service;
import org.deguet.service.ServiceImplementation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by joris on 16-11-15.
 */
public class TestServiceImplementation  {


    @Test
    public void testCreerPostPuisReponse() throws MauvaisPost, MauvaisReponse {
        Service service = new ServiceImplementation();
        Post p = new Post();
        p.contenu = "Coucou";
        service.creerPost(p);
        Reponse r = new Reponse();
        r.contenu = "Coucou aussi";
        r.element = p;
        service.creerReponse(r);
        for (Post post : service.tousLesPosts()){
            System.out.println(post.contenu);
            for (Reponse reponse : service.reponsesPour(post)){
                System.out.println("  >>> " +reponse.contenu);
            }
        }
    }

    @Test
    public void testCreerPostOk() throws MauvaisPost, MauvaisReponse {
        Service service = new ServiceImplementation();
        Post p = new Post();
        p.contenu = "Coucou";
        service.creerPost(p);
        Assert.assertEquals(1, service.tousLesPosts().size());
    }

    @Test(expected = MauvaisPost.class)
    public void testCreerPostTropCourt() throws MauvaisPost, MauvaisReponse {
        Service service = new ServiceImplementation();
        Post p = new Post();
        p.contenu = "C";
        service.creerPost(p);
    }

}
