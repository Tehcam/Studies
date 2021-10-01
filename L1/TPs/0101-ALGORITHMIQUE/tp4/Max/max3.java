import java.util.Scanner;

class max3
{
	public static void main(String[] args)
	{
		System.out.println("MAXIMUM ENTRE n REELS :");

		Scanner cin = new Scanner(System.in);
		System.out.print("Combien de valeurs voulez-vous comparer ? ");
		int n = cin.nextInt();
		System.out.println("Entrez vos valeurs :");
		double max = cin.nextDouble();
		for(int i=1; i<n; i++)
		{
			max = maximum(max, cin.nextDouble());
		}
		System.out.println("Le maximum entre les " + n + " valeurs est : " + max);
	}

	private static double maximum(double a, double b)
	{
		return a>b ? a : b;
	}
}