package org.deguet;

/**
 * Created by joris on 16-01-27.
 */
public interface TestChangeService {

    /**
     * Renvoie le calculateur que vous avez implanté
     * @return
     */
    ServiceArgent service();

    /**
     * Renvoie vos nom et prénom
      * @return
     */
    String nomEtudiant() ;
}
