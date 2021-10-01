import java.util.Scanner;

class TwoPlayers
{
	public static void main(String[] args)
	{
		int master1, master2;
		int user1, user2;
		int n = 0;
		Scanner cin = new Scanner(System.in);

		master1 = choisitRandom();
		master2 = choisitRandom();

		System.out.println("MASTERMIND - 2 PLAYERS" + '\n');
		do
		{
			System.out.println("Joueur 1 :");
			System.out.print(">>> ");
			user1 = cin.nextInt();
			verify(user1, master1);

			System.out.println("Joueur 2 :");
			System.out.print(">>> ");
			user2 = cin.nextInt();
			verify(user2, master2);

			n++;
		}
		while(user1 != master1 && user2 != master2 && n<10);

		if(user1 == master1 && user2 == master2)
		{
			System.out.println("Bravo, vous etes egalite ! Vous avez tous les deux resolu votre MasterMind.");
		}
		else if(user1 == master1)
		{
			System.out.println("Bravo, Joueur 1 ! Vous avez gagne le MasterMind.");
		}
		else if(user2 == master2)
		{
			System.out.println("Bravo, Joueur 2 ! Vous avez gagne le MasterMind.");
		}
		else
		{
			System.out.println("Dommage... Vous avez tous les deux perdu !");
		}
	}

	private static void affiche(int nb, String msg)
	{
		System.out.println("# " + nb + ": " + msg);
	}

	private static int choisitRandom()
	{
		int m=0;
		for(int i=0; i<4; i++)
		{
			m *= 10;
			m += (int)(Math.random()*10);
		}
		return m;
	}

	private static void verify(int u, int m)
	{
		int unite = m%10;
		int dizaine = (m%100)/10;
		int centaine = (m%1000)/100;
		int millier = (m%10000)/1000;
		int tmp=0, tmp_m=0;

		for(int i=0; i<4; i++)
		{
			switch(i)
			{
				case 0:
					tmp = u%10;
					tmp_m = unite;
					break;
				case 1:
					tmp = (u%100)/10;
					tmp_m = dizaine;
					break;
				case 2:
					tmp = (u%1000)/100;
					tmp_m = centaine;
					break;
				case 3:
					tmp = (u%10000)/1000;
					tmp_m = millier;
					break;
				default:
					System.out.println("Error in switch i");
			}

			if(tmp == unite || tmp == dizaine || tmp == centaine || tmp == millier)
			{
				if(tmp == tmp_m)
					affiche(tmp, "est bien place");
				else
					affiche(tmp, "existe, mais est mal place");
			}
			else
			{
				affiche(tmp, "n'existe pas");
			}
		}
		System.out.println();
	}
}