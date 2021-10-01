import java.util.Scanner;

class Factorielle
{
	public static void main(String[] args)
	{
		Scanner clav = new Scanner(System.in);
		System.out.print("Saisir un entier : ");
		int n = clav.nextInt();
		System.out.println("Voici sa factorielle : " + fac(n));
	}

	private static int fac(int n)
	{
		int result = 1;
		for(int i=2; i<=n; i++)
		{
			result *= i;
		}

		return result;
	}
}