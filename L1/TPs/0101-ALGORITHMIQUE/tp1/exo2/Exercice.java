import java.util.Scanner;

class Exercice
{
	public static void main(String[] args)
	{
		System.out.println("Saisir un entier :");

		Scanner clav = new Scanner(System.in);
		int cin = clav.nextInt();
		if(cin > 0)
		{
			System.out.print("L'entier saisi est positif");
		}
		else if(cin < 0)
		{
			System.out.print("L'entier saisi est negatif");
		}
		else
		{
			System.out.print("Vous avez saisi 0");
		}
	}
}