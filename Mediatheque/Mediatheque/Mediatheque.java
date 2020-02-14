/*
*========================*
* Created  on 03-02-2020 22:09:13 *
* @author : VALLERICH Vincent*
*========================*
*/

package Mediatheque;

import java.util.*;
import Mediatheque.media.*;

class Mediatheque {
    static List<Media> mediatheque = new ArrayList<Media>();

    public static void addMedia() {
        String type;
        String title;
        String artist;
        int duration;

        System.out.println("Quel est le type du média : Livre, CD ou DVD");
        System.out.println("Votre choix : ");

        Scanner scan = new Scanner(System.in);
        type = scan.nextLine();

        System.out.print("Quel est son titre : ");
        title = scan.nextLine();

        System.out.print("Quel est le nom de son créateur : ");
        artist = scan.nextLine();

        if (type == "Livre") {
            System.out.print("Quel est son nombre de pages : ");
        } else {
            System.out.print("Quel est sa durée : ");
        }
        duration = scan.nextInt();

        Media media = new Media();
        media.setType(type);
        media.setTitle(title);
        media.setArtist(artist);
        media.setDuration(duration);

        mediatheque.add(media);
    }

    public static void deleteMedia() {

    }

    public static void findMedia() {
        System.out.print("Recherche : ");
        Scanner scan = new Scanner(System.in);
        String find = scan.nextLine();

        for (Media med : mediatheque) {
            String str = "Minutes : ";

            if (med.getTitle().contains(find) || med.getArtist().contains(find)) {
                if (med.getType().contains("Livre")) {
                    str = "Pages : ";
                }
                System.out.println("Titre : " + med.getTitle());
                System.out.println("Createur" + med.getArtist());
                System.out.println(str + med.getDuration());
            }
        }
    }

    public static void printType() {

    }

    public static void main(String[] args) {
        char choice;

        System.out.println("#=================#");
        System.out.println("\tMédiatheque");
        System.out.println("#=================#");

        do {
            System.out.println("a : Ajouter un média");
            System.out.println("s : Supprimer un média");
            System.out.println("f : Trouver un média");
            System.out.println("t : Afficher tout les types d'un média\n");

            System.out.println("Votre choix : ");
            Scanner scan = new Scanner(System.in);
            String strScan = scan.nextLine();
            choice = strScan.charAt(0);

            switch (choice) {
            case 'a':
                addMedia();
                break;
            case 's':
                deleteMedia();
                break;
            case 'f':
                findMedia();
                break;
            case 't':
                printType();
                break;
            default:
                System.out.println("Veuillez saisir une entrée valide !");
                break;
            }

        } while (choice != 'Q');
    }
}