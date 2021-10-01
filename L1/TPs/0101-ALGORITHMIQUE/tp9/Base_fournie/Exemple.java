import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Exemple {
    
    public static int nbLignes(String nomFichier) {
        int resultat = 0;
        String tmp;
        
        try {
            // Ouverture du fichier
            File f = new File(nomFichier);

            // Lecture de chaque ligne du fichier => compte les mots
            Scanner scanner = new Scanner(f);
            while(scanner.hasNextLine()) {
                tmp = scanner.nextLine();
                resultat++;
            }
            scanner.close();
        } catch(IOException e) {
            System.err.println("Erreur lors de la lecture du fichier.");
            System.err.println(e);
            System.exit(0);
        }
        
        return resultat;
    }
    
    public static void main(String[] args) {
        int nb = nbLignes("liste_francais.txt");
        
        System.out.println("Nombre de lignes : " + nb);
    }
    
}