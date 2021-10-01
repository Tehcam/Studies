import java.util.Scanner;

class Question4
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);

		System.out.print("Entrer le nombre de cases du tableau : ");
		int tab[] = new int[cin.nextInt()];

		int k=0;
		while(k<tab.length)
		{
			System.out.print("Valeur de la case " + k + " : ");
			tab[k] = cin.nextInt();
			k++;
		}

		for(int i=0; i<tab.length; i++)
		{
			System.out.println(i + " => " + tab[i]);
		}

		System.out.println();

		afficheMax(tab);
	}

	private static void afficheMax(int[] t)
	{
		int max = t[0];
		int i=1;
		while(i<t.length)
		{
			if(t[i] > max)
				max = t[i];
			i++;
		}

		System.out.println("Valeur max = " + max);
	}
}