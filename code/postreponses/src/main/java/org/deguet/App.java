package org.deguet;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import org.deguet.exceptions.MauvaisPost;
import org.deguet.exceptions.MauvaisReponse;
import org.deguet.modele.Post;
import org.deguet.modele.Reponse;
import org.deguet.service.Service;
import org.deguet.service.ServiceImplementation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Service service = new ServiceImplementation();
        Scanner scan = new Scanner(System.in);
        int choix = 0;
        boolean inputIncorrect = true;
        
        System.out.println( "Bonjour, bienvenue dans posts et réponses" );
        do{
            montrerUsage();
            
             while(inputIncorrect) {
                if(scan.hasNextInt()) {
                    choix = scan.nextInt();
                    inputIncorrect = false;
                }
                else {
                    System.out.println("Veuillez entrer un chiffre inclu dans la liste de choix");
                    scan.next();
                }
            }
            
            System.out.println("Vous avez choisi " + choix);
            switch (choix){
                case 1:
                    creerPost(scan, service);
                    break;
                case 2:
                    creerReponse(scan, service);
                    break;
                case 3:
                    montrerTout(scan, service);
                    break;
                case 4:
                    sauvegarder(scan, service);
                    break;
                case 5:
                    service  = charger(scan, service);
                    break;
            }
        }while(choix != 6);

    }

    private static void sauvegarder(Scanner scan, Service service) {
        System.out.println("Nom du fichier?");
        String fichier = scan.next();
        String aSauver = new Gson().toJson(service);
        System.out.println(aSauver);
        try {
            Files.write(aSauver, new File(fichier), Charsets.UTF_8);
            System.out.println("Sauvegarde réussie");
        } catch (IOException e) {
            System.out.println("Erreur de sauvegarder");
        }
    }

    private static Service charger(Scanner scan, Service service) {
        System.out.println("Nom du fichier?");
        String fichier = scan.next();
        try {
            String charge = Files.toString(new File(fichier), Charsets.UTF_8);
            System.out.println(charge);
            Service serv = new Gson().fromJson(charge, ServiceImplementation.class);
            return serv;
        } catch (IOException e) {
            System.out.println("Erreur de chargement");
        }
        return null;
    }

    private static void montrerTout(Scanner scan, Service service) {
        System.out.println("Tous les posts");
        for (Post post : service.tousLesPosts()){
            System.out.println(" POST :: "+ post.contenu);
            for (Reponse r : service.reponsesPour(post)){
                System.out.println("       reponse  :: "+ r.contenu);
                for (Reponse rr : service.reponsesPour(r)){
                    System.out.println("           reponse  :: "+ rr.contenu);
                }
            }
        }
    }

    private static void creerPost(Scanner scan, Service service){
        System.out.println("Vous avez choisi de créer un post");
        System.out.println("Veuillez entrer le contenu : ");
        String contenu = scan.next();
        Post p = new Post();
        p.contenu = contenu;
        try {
            service.creerPost(p);
            System.out.println("  :-) post créé");
        } catch (MauvaisPost mauvaisPost) {
            System.out.println("  :-( post annulé exception");
        }
    }

    private static void creerReponse(Scanner scan, Service service){
        System.out.println("Vous avez choisi de créer une reponse");
        System.out.println("Veuillez entrer le contenu : ");
        String contenu = scan.next();
        // element sur lequel porte la réponse
        System.out.println("Reponse à un post ou à une réponse: ");
        System.out.println("1 post");
        System.out.println("2 reponse");
        int type = scan.nextInt();
        if (type == 1 ){
            // post
            System.out.println("Veuillez choisir l'élément : ");
            int index = 0;
            for (Post post : service.tousLesPosts()){
                System.out.println(index + "POST  "+ post.contenu);
                index++;
            }
            int choix = scan.nextInt();
            System.out.println("Vous avex choisi : "+ choix + " " + service.tousLesPosts().get(choix).contenu);
            Reponse r = new Reponse();
            r.contenu = contenu;
            r.element = service.tousLesPosts().get(choix);
            try {
                service.creerReponse(r);
                System.out.println("  :-) reponse créée");
            } catch (MauvaisReponse mauvaisReponse) {
                System.out.println("  :-( reponse annulée exception");
                mauvaisReponse.printStackTrace();
            }
        }
        else {
            // reponse
            System.out.println("Veuillez choisir l'élément : ");
            int index = 0;
            for (Reponse rep : service.tousLesReponses()){
                System.out.println(index + " Reponse  "+ rep.contenu);
                index++;
            }
            int choix = scan.nextInt();
            System.out.println("Vous avex choisi : "+ choix + " " + service.tousLesReponses().get(choix).contenu);
            Reponse r = new Reponse();
            r.contenu = contenu;
            r.element = service.tousLesReponses().get(choix);
            try {
                service.creerReponse(r);
                System.out.println("  :-) reponse créée");
            } catch (MauvaisReponse mauvaisReponse) {
                System.out.println("  :-( reponse annulée exception");
                mauvaisReponse.printStackTrace();
            }

        }

    }

    private static void montrerUsage(){
        System.out.println( "Choisissez une option suivante : " );
        System.out.println( "1 Créer un post " );
        System.out.println( "2 Créer une réponse " );
        System.out.println( "3 Voir tous les posts " );
        System.out.println( "4 Sauvegarder" );
        System.out.println( "5 Charger" );
        System.out.println( "6 Quitter" );
    }

}
