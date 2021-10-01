import java.util.Scanner;

class Calculatrice
{
	public static void main(String[] args)
	{
		System.out.println("Calcul entre deux entiers : ");

		Scanner clav = new Scanner(System.in);
		int a, b, rep = 0;
		char operator;

		System.out.print("val a : ");
		a = clav.nextInt();
		System.out.print("operation : ");
		operator = clav.next().charAt(0);
		System.out.print("val b : ");
		b = clav.nextInt();

		if(operator == '+')
		{
			rep = a+b;
			System.out.println("Resultat : " + a + " + " + b + " = " + rep);
		}
		else if(operator == '-')
		{
			rep = a-b;
			System.out.println("Resultat : " + a + " - " + b + " = " + rep);
		}
		else if(operator == '*')
		{
			rep = a*b;
			System.out.println("Resultat : " + a + " * " + b + " = " + rep);
		}
		else if(operator == '/' && b != 0)
		{
			rep = a/b;
			System.out.println("Resultat : " + a + " / " + b + " = " + rep);
		}
		else
		{
			System.out.println("L'operation n'est pas valide.");
		}
	}
}