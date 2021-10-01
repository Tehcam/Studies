import java.util.Scanner;

class Calculatrice
{
	public static void main(String[] args)
	{
		System.out.println("Calcul entre deux entiers : ");

		Scanner clav = new Scanner(System.in);
		int a, b, rep = 0;
		char operator;

		System.out.println("Saisir l'operation (PENSER A ESPACER VOS OPERANDES !) : ");
		a = clav.nextInt();
		operator = clav.next().charAt(0);
		b = clav.nextInt();

		switch(operator)
		{
			case '+':
				rep = a+b;
				affiche(rep);
				break;
			case '-':
				rep = a-b;
				affiche(rep);
				break;
			case '*':
				rep = a*b;
				affiche(rep);
				break;
			case '/':
				if(b != 0)
				{
					rep = a/b;
					affiche(rep);
				}
				else
				{
					System.out.println("Impossible de diviser par 0");
				}
				break;
			default : 
				System.out.println("Operation non valide");
		}
	}

	private static void affiche(int x)
	{
		System.out.println("Resultat : " + x);
	}
}