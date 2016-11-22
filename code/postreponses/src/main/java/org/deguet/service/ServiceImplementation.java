package org.deguet.service;

import org.deguet.exceptions.MauvaisPost;
import org.deguet.exceptions.MauvaisReponse;
import org.deguet.modele.ElementContenu;
import org.deguet.modele.Post;
import org.deguet.modele.Reponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 16-11-15.
 */
public class ServiceImplementation implements Service {

    private List<Post> posts = new ArrayList<Post>();

    private List<Reponse> reponses = new ArrayList<Reponse>();

    public void creerPost(Post post) throws MauvaisPost {
        // validation des données
        if (post.contenu == null) throw new MauvaisPost();
        if (post.contenu.length() < 2) throw new MauvaisPost();
        // si tout va bien ajouter les données
        posts.add(post);
    }

    public void creerReponse(Reponse reponse) throws MauvaisReponse{
        // validation des données
        if (reponse.contenu == null) throw new MauvaisReponse();
        if (reponse.contenu.length() < 2) throw new MauvaisReponse();
        if (posts.contains(reponse.element) || reponses.contains(reponse.element)){
            // tout va bien
        }
        else{
            throw new MauvaisReponse();
        }
        // si tout va bien ajouter les données
        reponses.add(reponse);
    }

    public List<Post> tousLesPosts() {
        return new ArrayList<Post>(posts);
    }

    public List<Reponse> reponsesPour(ElementContenu elt) {
        List<Reponse> resultat = new ArrayList<Reponse>();
        for (Reponse reponse : reponses){
            if (reponse.element.equals(elt)){
                resultat.add(reponse);
            }
        }
        return resultat;
    }

    public List<Reponse> tousLesReponses() {
        return new ArrayList<Reponse>(reponses);
    }
}
