import java.util.Scanner;
// import java.util.Arrays;
import java.util.Date;

class Tri
{
	public static void main(String[] args)
	{
		System.out.println("TRI DANS DES TABLEAUX\n");
		Scanner cin = new Scanner(System.in);
		System.out.println("Entrer le nombre de cases du tableau :");
		int n, a, b;
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
		// System.out.println("\nLe tableau a trier :");
		int[] alea = genereTab(n, a, b);
		// affiche(alea);
		// System.out.println("\nLe tableau trie :");
		int[] copy = clone(alea);
		long before = getTemps();
		triSelection(copy);
		long after = getTemps() - before;
		// affiche(copy);
		// System.out.println("\nLe tableau trie :");
		int[] copy2 = clone(alea);
		before = getTemps();
		triSelectionEchange(copy2);
		long after_echange = getTemps() - before;
		// affiche(copy2);
		// System.out.println("\nLe tableau trie :");
		int[] copy3 = clone(alea);
		before = getTemps();
		triInsertion(copy3);
		long after_insertion = getTemps() - before;
		// affiche(copy3);
		System.out.println("\nTemps necessaire au tri par selection : " + after + " ms.");
		System.out.println("Temps necessaire au tri par selection/echange : " + after_echange + " ms.");
		System.out.println("Temps necessaire au tri par insertion : " + after_insertion + " ms.");
	}

	private static void affiche(int[] tab)
	{
		for(int i=0; i<tab.length; i++)
		{
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

	private static int aleatoire(int inf, int sup)
	{
		return (int)(Math.random()*(sup-inf+1))+inf;
	}

	private static long getTemps()
	{
		Date d = new Date();
		return d.getTime();
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

	private static int[] clone(int[] t)
	{
		int[] newTab = new int[t.length];
		for(int i=0; i<t.length; i++)
		{
			newTab[i] = t[i];
		}
		return newTab;
	}

	private static void triSelection(int[] tab)
	{
		int[] tmp = clone(tab);
		int maj = maximum(tmp);
		int min;
		for(int i=0; i<tab.length; i++)
		{
			min = indexMin(tmp);
			tab[i] = tmp[min];
			tmp[min] = maj;
		}
	}

	private static void triSelectionEchange(int[] tab)
	{
		int tmp;
		int min;
		for(int i=0; i<tab.length-1; i++)
		{
			min = indexMinIntervalle(tab, i, tab.length-1);
			tmp = tab[i];
			tab[i] = tab[min];
			tab[min] = tmp;
		}
	}

	private static void triInsertion(int[] tab)
	{
		for(int i=1; i<tab.length; i++)
		{
			echange(tab, placeIntervalle(tab, i, tab[i]), i);
		}
	}

	private static int maximum(int[] t)
	{
		int max = t[0];
		for(int i=1; i<t.length; i++)
		{
			if(t[i] > max)
				max = t[i];
		}
		return max;
	}

	private static int indexMin(int[] t)
	{
		return indexMinIntervalle(t, 0, t.length-1);
	}

	private static int indexMinIntervalle(int[] t, int inf, int sup)
	{
		int min = t[inf];
		int index = inf;
		for(int i=inf+1; i<=sup; i++)
		{
			if(t[i] < min)
			{
				min = t[i];
				index = i;
			}
		}
		return index;
	}
	private static int placeIntervalle(int[] t, int ind, int val)
	{
		int i=0;
		while(i<=ind && t[i] < val)
		{
			i++;
		}
		return i;
	}

	private static void echange(int[] t, int inf, int sup)
	{
		int tmp = t[sup];
		for(int i=sup; i>inf; i--)
		{
			t[i] = t[i-1];
		}
		t[inf] = tmp;
	}
}