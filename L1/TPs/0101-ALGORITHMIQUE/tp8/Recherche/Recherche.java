import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

class Recherche
{
	public static void main(String[] args)
	{
		System.out.println("RECHERCHE DANS DES TABLEAUX\n");
		Scanner cin = new Scanner(System.in);
		System.out.println("Entrer le nombre de cases du tableau :");
		int n, a, b, m, tmp;
		do
		{
			System.out.print(">>> ");
			n = cin.nextInt();
			if(n<1)
				System.out.println("Valeur incorrecte. Ressayer.");
		}while(n<1);
		System.out.println("Entrer le minimum :");
		System.out.print(">>> ");
		a = cin.nextInt();
		System.out.println("Entrer le maximum :");
		do
		{
			System.out.print(">>> ");
			b = cin.nextInt();
			if(b<=a)
				System.out.println("Valeur incorrecte. Ressayer.");
		}while(b<=a);
		System.out.println("Combien de valeurs voulez-vous rechercher ?");
		do
		{
			System.out.print(">>> ");
			m = cin.nextInt();
			if(m<1 || m>n)
				System.out.println("Valeur incorrecte. Ressayer.");
		}while(m<1 || m>n);
		// System.out.println("\nLe tableau de recherche :");
		int[] alea = genereTab(n, a, b);
		Arrays.sort(alea);
		// affiche(alea);
		// System.out.println("Les valeurs recherchees :");
		int[] search = genereTab(m, a, b);
		// affiche(search);
		System.out.println();
		long before = getTemps();
		for(int i=0; i<search.length; i++)
		{
			tmp = rechercheSequentielle(alea, search[i]);
			// System.out.print(search[i] + " : " + tmp + ", ");
		}
		long after = getTemps() - before;
		// System.out.println();
		before = getTemps();
		for(int i=0; i<search.length; i++)
		{
			tmp = rechercheSequentielleTriee(alea, search[i]);
			// System.out.print(search[i] + " : " + tmp + ", ");
		}
		long after_triee = getTemps() - before;
		// System.out.println();
		before = getTemps();
		for(int i=0; i<search.length; i++)
		{
			tmp = rechercheDichotomique(alea, search[i]);
			// System.out.print(search[i] + " : " + tmp + ", ");
		}
		long after_dichoto = getTemps() - before;
		// System.out.println();
		System.out.println("Temps necessaire a la recherche sequentielle : " + after + " ms.");
		System.out.println("Temps necessaire a la recherche sequentielle triee : " + after_triee + " ms.");
		System.out.println("Temps necessaire a la recherche dichotomique : " + after_dichoto + " ms.");
	}

	private static int aleatoire(int inf, int sup)
	{
		return (int)(Math.random()*(sup-inf+1))+inf;
	}

	private static int[] genereTab(int n, int inf, int sup)
	{
		// utilier un nombre positif de cases
		n = n>0 ? n : 1;
		// puis allouer le tableau
		int[] tab = new int[n];

		for(int i=0; i<tab.length; i++)
		{
			tab[i] = aleatoire(inf, sup);
		}
		return tab;
	}

	private static void affiche(int[] tab)
	{
		for(int i=0; i<tab.length; i++)
		{
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

	private static int rechercheSequentielle(int[] t, int val)
	{
		int i=0;
		while(i<t.length && t[i] != val)
		{
			i++;
		}
		return i==t.length ? -1 : i;
	}

	private static int rechercheSequentielleTriee(int[] t, int val)
	{
		int i=0;
		int result = -1;
		while(i<t.length && t[i] < val)
		{
			i++;
		}
		if(i<t.length && t[i] == val)
			result = i;
		return result;
	}

	private static long getTemps()
	{
		Date d = new Date();
		return d.getTime();
	}

	private static int rechercheDichotomique(int[] t, int val)
	{
		int a = 0, b = t.length-1;
		int p;
		do
		{
			p = (a+b)/2;
			if(t[p] >= val)
			{
				b = p;
			}
			else
			{
				a = p+1;
			}
		}while(a<b);
		return t[b] == val ? b : -1;
	}
}