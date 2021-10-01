import java.util.Scanner;

class Exercice
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);

		System.out.println("TRI PAR SELECTION\n");
		System.out.println("Allouer un tableau de reels aleatoires :");
		System.out.print("Nombres de cases >> ");
		double[] t1, t2;
		t1 = allocation(cin.nextInt());
		System.out.println("Dans quel intervalle :");
		System.out.print("Borne inferieure >> ");
		int inf = cin.nextInt();
		System.out.print("Borne superieure >> ");
		int sup = cin.nextInt();
		System.out.print("Precision (puissance de 10) >> ");
		int cst = cin.nextInt();
		remplirAleatoire(t1, inf, sup, cst);
		System.out.println("\nVoici le tableau :");
		afficher(t1);
		t2 = triSelection(t1);
		System.out.println("\n");
		System.out.println("Voici le tableau trie :");
		afficher(t2);
	}

	private static double[] allocation(int n)
	{
		return new double[positif(n)];
	}

	private static int positif(int n)
	{
		return n>0 ? n : 1;
	}

	private static double aleatoire(int a, int b, final int cst)
	{
		return (double) ((int) (((Math.random()*(b-a))+a)*cst) ) / cst;
	}

	private static void remplirAleatoire(double[] t, int inf, int sup, final int cst)
	{
		for(int i=0; i<t.length; i++)
		{
			t[i] = aleatoire(inf, sup, cst);
		}
	}

	private static void afficher(double[] t)
	{
		for(int i=0; i<t.length; i++)
		{
			System.out.print(t[i] + " ");
		}
	}

	private static int indiceMin(double[] t)
	{
		double min = t[0];
		int index = 0;
		for(int i=1; i<t.length; i++)
		{
			if(t[i] < min)
			{
				min = t[i];
				index = i;
			}
		}
		return index;
	}

	private static double maximum(double[] t)
	{
		double max = t[0];
		for(int i=1; i<t.length; i++)
		{
			if(t[i] > max)
				max = t[i];
		}
		return max;
	}

	private static double[] triSelection(double[] t)
	{
		double tri[] = new double[t.length];
		int index;
		for(int k=0; k<tri.length; k++)
		{
			index = indiceMin(t);
			tri[k] = t[index];
			t[index] = maximum(t);
		}
		return tri;
	}
}