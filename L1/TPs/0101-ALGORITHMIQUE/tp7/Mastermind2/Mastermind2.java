import java.util.Scanner;

class Mastermind2
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		int iteration = 0;
		boolean end;
		int n, inf, sup;

		System.out.println("\nMASTERMIND AMELIORE\n");
		System.out.print("Entrez le nombre de valeurs dans la combinaison : ");
		do
		{
			n = cin.nextInt();
			if(n<=1)
				System.out.println("Nombre de valeurs impossible. Reessayez.");
		}while(n<=1);
		System.out.println("Jouer sur quel intervalle ?");
		System.out.print("Borne inferieure : ");
		do
		{
			inf = cin.nextInt();
			if(inf<0)
				System.out.println("Les valeurs doivent etre positives. Reessayez.");
		}while(inf<0);
		System.out.print("Borne superieure : ");
		do
		{
			sup = cin.nextInt();
			if(sup<=inf)
				System.out.println("Cette borne doit etre superieure a la premiere. Reessayez.");
		}while(sup<=inf);

		int[] solution = rempliSolution(n, inf, sup);
		System.out.println("Saisir une suite de " + n + " chiffres :");
		System.out.println("(separez les par des espaces)");
		do
		{
			System.out.print("\n>>> ");
			end = afficheResult(saisiProposition(n, inf, sup, cin), solution);
			iteration++;
		}while(!end);

		System.out.println("\nVous avez gagne !");
		System.out.println("Nombre de tours : " + iteration);
	}

	private static void afficheIntTab(int[] t)
	{
		for(int i=0; i<t.length; i++)
		{
			System.out.print(t[i] + " ");
		}
	}

	private static void afficheCharTab(char[] t)
	{
		String str = new String(t);
		for(int i=0; i<t.length; i++)
		{
			System.out.print(str.charAt(i) + " ");
		}
	}

	private static int[] rempliSolution(int n, int inf, int sup)
	{
		int taille = n>0 ? n : 1;
		int[] solution = new int[taille];
		int tmp;
		for(int i=0; i<solution.length; i++)
		{
			do
			{
				tmp = aleatoire(inf, sup);
			}while(!verifyIteration(tmp, solution, i));
			solution[i] = tmp;
		}
		return solution;
	}

	private static int aleatoire(int inf, int sup)
	{
		return (int)(Math.random()*(sup-inf+1))+inf;
	}

	private static boolean verifyIteration(int val, int[] tab, int i)
	{
		boolean bool = true;
		int k=0;
		while(k<i && bool)
		{
			if(tab[k] == val)
				bool = false;
			k++;
		}
		return bool;
	}

	private static int[] saisiProposition(int n, int inf, int sup, Scanner cin)
	{
		int taille = n>0 ? n : 1;
		int[] prop = new int[taille];
		do
		{
			for(int i=0; i<prop.length; i++)
			{
				prop[i] = cin.nextInt();
			}
		}while(!verifyTab(prop, inf, sup));
		return prop;
	}

	private static boolean verifyTab(int[] t, int inf, int sup)
	{
		boolean bool = true;
		for(int i=0; i<t.length; i++)
		{
			if(t[i]<inf || t[i]>sup)
			{
				System.out.println(t[i] + " n'est pas une valeur correcte. Reessayez.");
				bool = false;
			}
		}
		return bool;
	}

	private static boolean bienPlacee(int[] solution, int val, int index)
	{
		return solution[index] == val;
	}

	private static boolean estDansTab(int[] solution, int val)
	{
		boolean bool = false;
		int i=0;
		while(i<solution.length && !bool)
		{
			if(solution[i] == val)
				bool = true;
			i++;
		}
		return bool;
	}

	private static boolean malPlacee(int[] solution, int val, int index)
	{
		return estDansTab(solution, val) && !bienPlacee(solution, val, index);
	}

	private static char[] compare(int[] prop, int[] solution)
	{
		int taille=0;
		for(int k=0; k<prop.length; k++)
		{
			if(malPlacee(solution, prop[k], k) || bienPlacee(solution, prop[k], k))
				taille++;
		}
		if(taille == 0)
		{
			return null;
		}
		char[] comp = new char[taille];
		for(int i=0, j=0; i<prop.length; i++)
		{
			if(malPlacee(solution, prop[i], i))
			{
				comp[j] = 'M';
				j++;
			}
			else if(bienPlacee(solution, prop[i], i))
			{
				comp[j] = 'B';
				j++;
			}
		}
		return comp;
	}

	private static boolean gagne(char[] comp, int tot)
	{
		boolean bool = true;
		int i=0;
		if(comp.length == tot)
		{
			while(i<comp.length && bool)
			{
				if(comp[i] != 'B')
					bool = false;
				i++;
			}
		}else{
			bool = false;
		}
		return bool;
	}

	private static boolean afficheResult(int[] prop, int[] solution)
	{
		char[] tmp = compare(prop, solution);
		System.out.println("\nResultat :");
		afficheIntTab(prop);
		System.out.println();

		if(tmp != null)
		{
			afficheCharTab(tmp);
			System.out.println();
			return gagne(tmp, solution.length);
		}

		return false;
	}
}