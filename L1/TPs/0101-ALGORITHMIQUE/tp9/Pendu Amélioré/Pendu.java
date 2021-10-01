import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.Error;

class Pendu
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("LE JEU DU PENDU !");
		char[] solution;
		try
		{
			solution = initSolution(lecture("liste_francais.txt"));
			if(solution == null)
			{
				throw new Error("Une erreur s'est produite.");
			}
			char[] masque = creerMasque(solution.length);
			int nbEssais = 0;
			do
			{
				afficheEssais(nbEssais, masque);
				if(nbEssais != 5)
				{
					System.out.print("Entrer une lettre : ");
					if(!jouer(solution, masque, cin.nextLine().charAt(0)))
						nbEssais++;
				}else{
					nbEssais++;
				}
			}while(nbEssais <= 5 && !estFini(masque));
			if(nbEssais < 5)
				System.out.println("GAGNE !");
			else
				System.out.println("PENDU !");
		}
		catch(Error e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	private static boolean estValide(String mot)
	{
		boolean lettre = true;
		int i=0;
		if(mot.length() >= 4)
		{
			while(i<mot.length() && lettre)
			{
				if((mot.charAt(i) < 'a' || mot.charAt(i) > 'z') && (mot.charAt(i) < 'A' || mot.charAt(i) > 'Z'))
					lettre = false;
				i++;
			}
		}else{
			lettre = false;
		}
		return lettre;
	}

	private static char[] convertir(String mot)
	{
		char[] rep = new char[mot.length()];
		for(int i=0; i<mot.length(); i++)
		{
			rep[i] = mot.charAt(i);
		}
		return rep;
	}

	private static char[] initSolution(String[] dico)
	{
		char[] solution;
		String mot = dico[aleatoire(0, dico.length-1)];
		if(estValide(mot))
			solution = convertir(mot);
		else
			solution = null;
		return solution;
	}

	private static int aleatoire(int a, int b)
	{
		return (int)(Math.random()*(b-a+1))+a;
	}

	private static void affiche(char[] t)
	{
		for(int i=0; i<t.length; i++)
		{
			System.out.print(t[i]);
		}
	}

	private static char[] creerMasque(int n)
	{
		char[] masque = new char[n];
		for(int i=0; i<n; i++)
		{
			masque[i] = '_';
		}
		return masque;
	}

	private static boolean jouer(char[] solution, char[] masque, char lettre)
	{
		boolean bool = false;
		if(existe(solution, lettre))
		{
			for(int i=0; i<solution.length; i++)
			{
				if(solution[i] == lettre)
					masque[i] = lettre;
			}
			bool = true;
		}
		return bool;
	}

	private static boolean existe(char[] solution, char lettre)
	{
		boolean exist = false;
		int i=0;
		while(i<solution.length && !exist)
		{
			if(solution[i] == lettre)
				exist = true;
			i++;
		}
		return exist;
	}

	private static void afficheEssais(int nbEssais, char[] masque)
	{
		affiche(masque);
		System.out.println();
		switch(nbEssais)
		{
			case 5: // La potence en entier et le pendu
			    System.out.println(" /---\\\n |   |\n |   O\n |  /|\\\n |  / \\\n-^-");
			    break;
			case 4: // La potence en entier
			    System.out.println(" /---\\\n |   |\n |\n |\n |\n-^-");
			    break;
			case 3: // La potence sans la corde
			    System.out.println(" /---\\\n |\n |\n |\n |\n-^-");
			    break;
			case 2: // Le corps de la potence
			    System.out.println("\n |\n |\n |\n |\n-^-");
			    break;
			case 1: // Le pied de la potence
			    System.out.println("\n\n\n\n\n-^-");
			    break;
		}
		System.out.println("\nIl vous reste " + (5-nbEssais) + " coups.");
	}

	private static boolean estFini(char[] masque)
	{
		boolean bool = true;
		int i=0;
		while(i<masque.length && bool)
		{
			if(masque[i] == '_')
				bool = false;
			i++;
		}
		return bool;
	}

    public static int nbLignes(String nomFichier)
    {
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

    private static String[] lecture(String nomFichier)
    {
    	int n = nbLignes(nomFichier);
    	String[] dico = new String[n];
    	try
    	{
    		File f = new File(nomFichier);
    		Scanner scan = new Scanner(f);
	    	for(int i=0; i<n; i++)
	    	{
	    		if(scan.hasNextLine())
	    			dico[i] = scan.nextLine();
	    	}
	    	scan.close();
    	}
    	catch(IOException e)
    	{
    		System.err.println("Erreur lors de la lecture du fichier.");
            System.err.println(e);
            System.exit(0);
    	}
    	return dico;
    }
}