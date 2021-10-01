import java.util.Scanner;

class max
{
	public static void main(String[] args)
	{
		System.out.println("MAXIMUM ENTRE 2 REELS :");

		Scanner cin = new Scanner(System.in);
		System.out.print("Entrer la premiere valeur : ");
		double a = cin.nextDouble();
		System.out.print("Entrer la seconde valeur : ");
		double b = cin.nextDouble();

		System.out.println("Le maximum entre les deux valeurs est : " + maximum(a,b));
	}

	private static double maximum(double a, double b)
	{
		return a>b ? a : b;
	}
}