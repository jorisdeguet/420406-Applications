package org.deguet.service;

import org.deguet.exceptions.MauvaisPost;
import org.deguet.exceptions.MauvaisReponse;
import org.deguet.modele.ElementContenu;
import org.deguet.modele.Post;
import org.deguet.modele.Reponse;

import java.util.List;

/**
 * Created by joris on 16-11-15.
 */
public interface Service {

    void creerPost(Post post) throws MauvaisPost;

    void creerReponse(Reponse reponse) throws MauvaisReponse;

    List<Post> tousLesPosts();

    List<Reponse> reponsesPour(ElementContenu elt);

    List<Reponse> tousLesReponses();
}
