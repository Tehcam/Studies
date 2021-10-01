import personne.*;
import java.util.*;

/**
 * Classe permettant de tester les classes du package personne.
 * @author Cyril Rabat
 * @author Jessica Jonquet
 * @version 20/03/2021
 */
public class TestPersonne1 {
    
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

    public static Vacataire creerVacataire() {
        String nom, prenom;
        double salaire;
        String entreprise;

        System.out.println("Création d'un vacataire :");
        System.out.print("Nom               : ");
        nom = clavier.nextLine();
        System.out.print("Prénom            : ");
        prenom = clavier.nextLine();
        System.out.print("Salaire           : ");
        salaire = clavier.nextDouble();
        System.out.print("Entreprise        : ");
        entreprise = clavier.nextLine();
        clavier.nextLine();

        return new Vacataire(nom, prenom, salaire, entreprise);
    }
    
    /** 
     * Méthode principale.
     * @param args les arguments
     */
    public static void main(String args[]) {
        Personne tableau[] = new Personne[4];
        Personne[] copie = new Personne[4];

        /* Initialisation du tableau */
        tableau[0] = creerPersonne();
        tableau[1] = creerEtudiant();
        tableau[2] = creerEnseignant();
        tableau[3] = creerVacataire();

        for(int i=0; i<4; i++)
        {
            copie[i] = (Personne)tableau[i].clone();
        }
        
        /* Affichage du contenu du tableau */
        System.out.println("RESUME : ");
        for(int i = 0; i < tableau.length; i++)
        {
            System.out.println(tableau[i]);
            System.out.println(copie[i]);
        }
    }
    
}