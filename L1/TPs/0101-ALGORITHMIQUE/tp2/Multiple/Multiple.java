import java.util.Scanner;

class Multiple
{
	public static void main(String[] args)
	{
		Scanner clav = new Scanner(System.in);
		System.out.println("Précisez les bornes de l'intervalle :");

		System.out.print("a : ");
		int a = clav.nextInt();

		System.out.print("b : ");
		int b = clav.nextInt();

		System.out.println("Saisissez n :");
		int n = clav.nextInt();

		if(a<b)
		{
			System.out.println("Les multiples sont :");
			multiple(n, a, b);
		}
		else
		{
			System.out.println("Erreur : intervalle incorrecte");
		}
	}

	private static void multiple(int n, int a, int b)
	{
		for(int i=a; i<=b; i++)
		{
			if(i%n == 0)
				System.out.println(i);
		}
	}
}