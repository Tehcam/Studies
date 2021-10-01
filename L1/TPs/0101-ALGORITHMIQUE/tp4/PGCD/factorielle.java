import java.util.Scanner;

class factorielle
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Entrer la valeur de la factorielle : ");
		int n = cin.nextInt();
		System.out.println("La factorielle de " + n + " est " + fac(n));
	}

	private static int fac(int n)
	{
		int f = 1;
		for(int i=2; i<=n; i++)
		{
			f *= i;
		}
		return f;
	}
}