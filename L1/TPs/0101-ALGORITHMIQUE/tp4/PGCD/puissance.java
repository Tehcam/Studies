import java.util.Scanner;

class puissance
{
	public static void main(String[] args)
	{
		System.out.println("CALCUL DE PUISSANCE :");

		Scanner cin = new Scanner(System.in);
		System.out.print("Entrer une valeur reelle : ");
		double x = cin.nextDouble();
		System.out.print("Entrer son exposant (entier) : ");
		int y = cin.nextInt();

		System.out.println("Le calcul de " + x + " exposant "+ y + " est " + pwr(x, y));
	}

	private static double pwr(double x, int y)
	{
		double result = 1;
		for(int i=0; i<y; i++)
		{
			result *= x;
		}
		return result;
	}
}