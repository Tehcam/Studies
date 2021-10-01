import java.util.Scanner;

class Facturation
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		boolean again = false;
		int e, b;
		do
		{
			e = setErable(cin);
			b = setBleuet(cin);
			afficheFacture(e, b);
			System.out.println("Souhaitez-vous recommencer ? o/n");
			switch(cin.next().charAt(0))
			{
				case 'o' :
					break;
				case 'n' :
					again = true;
					break;
				default :
					System.out.println("Syntax Error. Program ends.");
					again = true;
			}
		}while(!again);
	}

	private static int setErable(Scanner cin)
	{
		int n;
		do
		{
			System.out.print("Saisir le nombre de cruchon(s) de sirop d'erable : ");
			n = cin.nextInt();
			if(n<3 || n%3 != 0)
			{
				System.out.println("Le nombre d'articles est incorrect. Reessayez SVP.");
			}
		}while(n<3 || n%3 != 0);

		return n;
	}

	private static int setBleuet(Scanner cin)
	{
		int n;
		do
		{
			System.out.print("Saisir le nombre de bouteille(s) de sirop de bleuets : ");
			n = cin.nextInt();
			if(n<1)
			{
				System.out.println("Le nombre d'articles est incorrect. Reessayez SVP.");
			}
		}while(n<1);

		return n;
	}

	private static double getFraisTransport(int erable, int bleuet)
	{
		double total = 0;
		if(erable >= 3)
		{
			if(erable >= 12)
			{
				if(erable > 24)
				{
					total += 0;
				}
				total += (double) erable;
			}
			total += (double) erable * 1.5;
		}
		total += (double) bleuet * 0.5;

		return total;
	}

	private static double getFrais(int erable, int bleuet)
	{
		return (double)(erable*28 + bleuet*12);
	}

	private static void afficheFacture(int erable, int bleuet)
	{
		double total = getFrais(erable, bleuet) + getFraisTransport(erable, bleuet);
		System.out.println("\nLe total de vos achats est de " + total + " euros.");
	}
}