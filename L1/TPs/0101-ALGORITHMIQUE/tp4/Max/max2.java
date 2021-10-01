import java.util.Scanner;

class max2
{
	public static void main(String[] args)
	{
		System.out.println("MAXIMUM ENTRE n REELS :");

		Scanner cin = new Scanner(System.in);
		System.out.print("Combien de valeurs voulez-vous comparer ? ");
		int n = cin.nextInt();
		double arr[] = new double[n];
		System.out.println("Entrez vos valeurs :");
		for(int i=0; i<n; i++)
		{
			arr[i] = cin.nextDouble();
		}
		double max = arr[0];
		for(int i=1; i<n; i++)
		{
			max = maximum(max, arr[i]);
		}

		System.out.println("Le maximum entre les " + n + " valeurs est : " + max);
	}

	private static double maximum(double a, double b)
	{
		return a>b ? a : b;
	}
}