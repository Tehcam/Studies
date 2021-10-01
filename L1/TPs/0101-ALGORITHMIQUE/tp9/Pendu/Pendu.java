import java.util.Scanner;

class Pendu
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("LE JEU DU PENDU !");
		System.out.println("Entrer le mot a deviner :");
		System.out.print(">>> ");
		char[] solution;
		do
		{
			solution = initSolution(cin);
			if(solution == null)
			{
				System.out.println("Erreur. Ce mot n'est pas valide.");
				System.out.print(">>> ");
			}
		}while(solution == null);
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

	private static boolean estValide(String mot)
	{
		boolean lettre = true;
		int i=0;
		if(mot.length() >= 4)
		{
			while(i<mot.length() && lettre)
			{
				if(mot.charAt(i) < 'A' || mot.charAt(i) > 'Z')
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

	private static char[] initSolution(Scanner cin)
	{
		char[] solution;
		String mot = cin.nextLine();
		if(estValide(mot))
			solution = convertir(mot);
		else
			solution = null;
		return solution;
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
}