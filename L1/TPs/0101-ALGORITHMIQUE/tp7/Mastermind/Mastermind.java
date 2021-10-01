import java.util.Scanner;

class Mastermind
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		int[] solution = rempliSolution(4);
		int iteration = 0;
		boolean end;

		System.out.println("\nMASTERMIND\n");
		System.out.println("Saisir une suite de 4 chiffres :");
		System.out.println("(separez les par des espaces)\n");

		do
		{
			System.out.print(">>> ");
			end = afficheResult(saisiProposition(4, cin), solution);
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

	private static int[] rempliSolution(int n)
	{
		int taille = n>0 ? n : 1;
		int[] solution = new int[taille];
		for(int i=0; i<solution.length; i++)
		{
			solution[i] = aleatoire(0, 9);
		}
		return solution;
	}

	private static int aleatoire(int inf, int sup)
	{
		return (int)(Math.random()*(sup-inf+1))+inf;
	}

	private static int[] saisiProposition(int n, Scanner cin)
	{
		int taille = n>0 ? n : 1;
		int[] prop = new int[taille];
		do
		{
			for(int i=0; i<prop.length; i++)
			{
				prop[i] = cin.nextInt();
			}
		}while(!verifyTab(prop));
		return prop;
	}

	private static boolean verifyTab(int[] t)
	{
		boolean bool = true;
		for(int i=0; i<t.length; i++)
		{
			if(t[i]<0 || t[i]>9)
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
		char[] comp = new char[prop.length];
		for(int i=0; i<prop.length; i++)
		{
			if(malPlacee(solution, prop[i], i))
				comp[i] = 'M';
			else if(bienPlacee(solution, prop[i], i))
				comp[i] = 'B';
			else
				comp[i] = ' ';
		}
		return comp;
	}

	private static boolean gagne(char[] comp)
	{
		boolean bool = true;
		int i=0;
		while(i<comp.length && bool)
		{
			if(comp[i] != 'B')
				bool = false;
			i++;
		}
		return bool;
	}

	private static boolean afficheResult(int[] prop, int[] solution)
	{
		char[] tmp = compare(prop, solution);

		System.out.println("\nResultat :");
		afficheIntTab(prop);
		System.out.println();
		afficheCharTab(tmp);
		System.out.println();

		return gagne(tmp);
	}
}