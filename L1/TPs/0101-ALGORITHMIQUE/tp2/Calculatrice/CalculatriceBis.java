import java.util.Scanner;

class CalculatriceBis
{
	public static void main(String[] args)
	{
		System.out.println("Calcul entre deux entiers : ");

		Scanner clav = new Scanner(System.in);
		int a, b;
		char operator;
		char continu = 'y';

		System.out.println("Saisir l'operation (PENSER A ESPACER VOS OPERANDES !) : ");
		
		int i=0;
		while(continu == 'y' && i<5)
		{
			a = clav.nextInt();
			operator = clav.next().charAt(0);
			b = clav.nextInt();
			calcule(a, b, operator);
			i++;
			if(i!=5)
			{
				System.out.println("Continuer ? y/n");
				continu = clav.next().charAt(0);
			}
		}
	}

	private static void calcule(int a, int b, char operator)
	{
		int rep=0;
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