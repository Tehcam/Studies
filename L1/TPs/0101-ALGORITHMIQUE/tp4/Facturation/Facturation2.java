import java.util.Scanner;

class Facturation2
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		boolean again = false, isTypeValid = false;
		String type;
		do
		{
			do
			{
				System.out.println("Quel type de sirop d'erable souhaitez-vous ? (extra-clair, clair ou medium)");
				type = cin.nextLine();
				if(type.equals("extra-clair") || type.equals("clair") || type.equals("medium"))
				{
					isTypeValid = true;
				}
				else
				{
					System.out.println("/!\\ incorrect type /!\\");
				}
			}while(!isTypeValid);

			afficheFacture(type, setErable(type, cin), setBleuet(cin));
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

	private static int setErable(String type, Scanner cin)
	{
		int n;
		do
		{
			System.out.print("Saisir le nombre de cruchon(s) de sirop d'erable " + type + " : ");
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

	private static double getFrais(String type, int erable, int bleuet)
	{
		double prix = 0;
		switch(type)
		{
			case "extra-clair" :
				prix = 28.0;
				break;
			case "clair" :
				prix = 23.5;
				break;
			case "medium" :
				prix = 21.4;
		}
		return (double)(erable*prix + bleuet*12);
	}

	private static void afficheFacture(String type, int erable, int bleuet)
	{
		double total = getFrais(type, erable, bleuet) + getFraisTransport(erable, bleuet);
		System.out.println("\nLe total de vos achats est de " + total + " euros.");
	}
}