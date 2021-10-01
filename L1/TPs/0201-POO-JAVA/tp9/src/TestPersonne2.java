import personne.*;
import java.util.*;

/**
 * Classe permettant de tester les classes du package personne.
 * @author Cyril Rabat
 * @author Jessica Jonquet
 * @version 20/03/2021
 */
public class TestPersonne2 {
    
    public static Scanner clavier = new Scanner(System.in);
    
    /**
     * Création d'une personne depuis des informations saisies au clavier.
     * @return la personne créée
     */
    public static Personne creerPersonne() {
        String nom, prenom;
        
        System.out.println("Création d'une personne :");
        System.out.print("Nom               : ");
        nom = clavier.nextLine();
        System.out.print("Prénom            : ");
        prenom = clavier.nextLine();

        return new Personne(nom, prenom);
    }
    /**
     * Création d'un étudiant depuis des informations saisies au clavier.
     * @return l'étudiant créé
     */
    public static Etudiant creerEtudiant() {
        String nom, prenom;
        int numero;
        
        System.out.println("Création d'un étudiant :");
        System.out.print("Nom               : ");
        nom = clavier.nextLine();
        System.out.print("Prénom            : ");
        prenom = clavier.nextLine();
        System.out.print("Numéro d'étudiant : ");
        numero = clavier.nextInt();
        clavier.nextLine(); /* Vidage du tampon */

        return new Etudiant(nom, prenom, numero);
    }

    /**
     * Création d'un enseignant depuis des informations saisies au clavier.
     * @return l'enseignant créé
     */
    public static Enseignant creerEnseignant() {
        String nom, prenom;
        double salaire;
        
        System.out.println("Création d'un enseignant :");
        System.out.print("Nom               : ");
        nom = clavier.nextLine();
        System.out.print("Prénom            : ");
        prenom = clavier.nextLine();
        System.out.print("Salaire           : ");
        salaire = clavier.nextDouble();
        clavier.nextLine();        
        
        return new Enseignant(nom, prenom, salaire);
    }

    /**
     * Création d'un vacataire depuis des informations saisies au clavier.
     * @return le vacataire créé
     */
    public static Vacataire creerVacataire() {
        String nom, prenom, entreprise;
        double salaire;
        
        System.out.println("Création d'un vacataire :");
        System.out.print("Nom               : ");
        nom = clavier.nextLine();
        System.out.print("Prénom            : ");
        prenom = clavier.nextLine();
        System.out.print("Salaire           : ");
        salaire = clavier.nextDouble();
        clavier.nextLine();        
        System.out.print("Entreprise        : ");
        entreprise = clavier.nextLine();        
        
        return new Vacataire(nom, prenom, salaire, entreprise);
    }
    
    /** 
     * Méthode principale.
     * @param args les arguments
     */
    public static void main(String args[]) {
        Personne p1, p2;

        /* Initialisation du tableau */
        p1 = creerPersonne();
        p2 = creerEtudiant();

        System.out.println("La personne saisie : " + p1);
        System.out.println("La personne copiee : " + p2);
        
        if(p1.equals(p2))
            System.out.println("Les personnes " + p1 + " et " + p2 + " sont identiques.");
        else
            System.out.println("Les personnes " + p1 + " et " + p2 + " sont différentes.");
    }
    
}