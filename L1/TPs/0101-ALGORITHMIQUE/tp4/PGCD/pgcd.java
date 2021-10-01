import java.util.Scanner;

class pgcd
{
	public static void main(String[] args)
	{
		System.out.println("CALCUL DU PGCD");

		Scanner cin = new Scanner(System.in);
		int a, b;
		do
		{
			System.out.print("Entrer la premiere valeur : ");
			a = cin.nextInt();
			System.out.print("Entrer la seconde valeur : ");
			b = cin.nextInt();
			if(!estValide(a, b))
			{
				System.out.println("Les valeurs entrees ne sont pas valides. Reessayer.");
			}
		}
		while(!estValide(a, b));

		System.out.println("Le PGCD de " + a + " et " + b + " est " + pgcd(a, b));
	}

	private static int pgcd(int a, int b)
	{
		int r;
		while(a%b != 0)
		{
			r = a%b;
			a = b;
			b = r;
		}
		return b;
	}

	private static boolean estValide(int a, int b)
	{
		return a>0 && b>0;
	}
}