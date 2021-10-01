import java.util.Scanner;

class Exercice
{
	public static void main(String[] args)
	{
		Scanner clav = new Scanner(System.in);
		int a, b, rep;
		System.out.println("Exercice 1:");

		System.out.print("Valeur a: ");
		a = clav.nextInt();

		System.out.print("Valeur b: ");
		b = clav.nextInt();

		rep = a+b;
		System.out.println("La somme de " + a + " + " + b + " est " + rep);
	}
}