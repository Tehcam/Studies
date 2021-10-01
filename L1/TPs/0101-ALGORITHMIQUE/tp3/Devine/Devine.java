import java.util.Scanner;

class Devine
{
	public static void main(String[] args)
	{
		System.out.println("LE JEU DU NOMBRE SECRET\n");

		Scanner cin = new Scanner(System.in);
		int a, b;
		do
		{
			System.out.println("Choisissez l'interval dans lequel vous souhaitez jouer.");
			System.out.println("Borne inferieure :");
			System.out.print(">>> ");
			a = cin.nextInt();
			System.out.println("Borne superieure :");
			System.out.print(">>> ");
			b = cin.nextInt();

			if(a>=b)
			{
				System.out.println("\n/!\\ Erreur de syntaxe /!\\\n");
			}
		}
		while(a>=b);

		int move = initMoves(b-a);
		int secret = choiseRandom(a, b);
		int user, tmp_min = a, tmp_max = b;
		boolean win = false;

		System.out.println("\nDevinez le nombre secret :\n");
		do
		{
			System.out.println("Il vous reste " + move + " tour(s).");
			System.out.print(">>> ");
			user = cin.nextInt();
			if(user < secret)
			{
				if(user > tmp_min)
				{
					System.out.println("Trop petit !\n");
					tmp_min = user;
				}
				else
				{
					System.out.println("Trop petit, je te l'ai deja dit...\n");
				}
			}
			else if(user > secret)
			{
				if(user < tmp_max)
				{
					System.out.println("Trop grand !\n");
					tmp_max = user;
				}
				else
				{
					System.out.println("Trop grand, je te l'ai deja dit...\n");
				}
			}
			else
				win = true;
			move--;
		}
		while(!win && move >= 0);

		if(win)
			System.out.println("Bravo, vous avez trouve le nombre secret !");
		else
			System.out.println("Dommage, vous avez perdu...");
	}

	private static int choiseRandom(int min, int max)
	{
		return (int)(Math.random()*(max-min)+min);
	}

	private static int initMoves(int x)
	{
		if(x%2 == 0)
			return (int)(Math.log(x)/Math.log(2));
		else
			return (int)(Math.log(x+1)/Math.log(2));
	}
}