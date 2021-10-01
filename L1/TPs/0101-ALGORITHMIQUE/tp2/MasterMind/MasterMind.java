import java.util.Scanner;

class MasterMind
{
	public static void main(String[] args)
	{
		int master = choisitRandom();
		int user;
		Scanner clav = new Scanner(System.in);

		System.out.println("Entrez votre valeur :");
		do
		{
			System.out.print(">>> ");
			user = clav.nextInt();
			verify(user, master);
		}
		while(user != master);

		System.out.println("Bravo, vous avez resolu le MasterMind !");
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
		int tmp;

		tmp = u%10;
		if(tmp == unite || tmp == dizaine	|| tmp == centaine	|| tmp == millier)
		{
			if(tmp == unite)
				affiche(tmp, "est bien place");
			else
				affiche(tmp, "existe, mais est mal place");
		}
		else
		{
			affiche(tmp, "n'existe pas");
		}

		tmp = (u%100)/10;
		if(tmp == unite || tmp == dizaine	|| tmp == centaine	|| tmp == millier)
		{
			if(tmp == dizaine)
				affiche(tmp, "est bien place");
			else
				affiche(tmp, "existe, mais est mal place");
		}
		else
		{
			affiche(tmp, "n'existe pas");
		}

		tmp = (u%1000)/100;
		if(tmp == unite || tmp == dizaine	|| tmp == centaine	|| tmp == millier)
		{
			if(tmp == centaine)
				affiche(tmp, "est bien place");
			else
				affiche(tmp, "existe, mais est mal place");
		}
		else
		{
			affiche(tmp, "n'existe pas");
		}

		tmp = (u%10000)/1000;
		if(tmp == unite || tmp == dizaine	|| tmp == centaine	|| tmp == millier)
		{
			if(tmp == millier)
				affiche(tmp, "est bien place");
			else
				affiche(tmp, "existe, mais est mal place");
		}
		else
		{
			affiche(tmp, "n'existe pas");
		}

		System.out.println();
	}

	private static void affiche(int nb, String msg)
	{
		System.out.println("# " + nb + ": " + msg);
	}
}