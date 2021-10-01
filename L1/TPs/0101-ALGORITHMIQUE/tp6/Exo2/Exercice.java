import java.util.Scanner;

class Exercice
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Combien de notes voulez-vous entrer ? : ");
		double tab[] = new double[cin.nextInt()];
		System.out.println();
		initTab(tab, cin);
		System.out.println();
		afficheTab(tab);
		System.out.println("\nMoyenne des notes sur 20 : " + moyenne(tab));
	}

	private static void initTab(double[] t, Scanner cin)
	{
		double tmp, sur;
		int k;
		for(int i=0; i<t.length; i++)
		{
			k=i+1;
			do
			{
				System.out.print("Valeur de la "+k+"e note : ");
				tmp = cin.nextDouble();
				System.out.print("sur ");
				sur = cin.nextDouble();
			}while(tmp < 0 || tmp > sur);
			t[i] = (tmp*20)/sur;
		}
	}

	private static void afficheTab(double[] t)
	{
		int k;
		for(int i=0; i<t.length; i++)
		{
			k=i+1;
			System.out.println("Note n"+k+" : "+t[i]+" sur 20");
		}
	}

	private static double moyenne(double[] t)
	{
		double tot = 0;
		for(int i=0; i<t.length; i++)
		{
			tot += t[i];
		}
		return tot/t.length;
	}
}