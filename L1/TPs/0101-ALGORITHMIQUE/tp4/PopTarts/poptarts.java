import java.util.Scanner;

class poptarts
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		int table[] = new int[1];
		int tmp;
		do
		{
			tmp = jouer(cin);
			if(tmp == 0)
				System.out.println("Vous avez perdu !");
			else
				System.out.println("Vous avez gagne !");
			table = addTab(table, tmp);
		}while(menu(table, cin) != 0);
	}

	private static int jeuOrdi(int n)
	{
		int ordi = 0;
		if(n>1)
		{
			do
			{
				ordi = (int)(Math.random()*2+1);
			}while(ordi >= n);
		}
		else
			ordi = 1;

		return ordi;
	}

	private static int jeuJoueur(int n, Scanner cin)
	{
		System.out.print("A vous de jouer : 1, 2 ou 3 poptarts ? ");
		int joueur = 0;
		do
		{
			joueur = cin.nextInt();
			if(joueur != 1 && joueur != 2 && joueur != 3)
				System.out.println("Il faut entrer un nombre entre 1 et 3 !");
			if(joueur > n)
				System.out.println("Vous ne pouvez pas choisir plus de poptarts qu'il y en a...");
		}while(joueur != 1 && joueur != 2 && joueur != 3 || joueur > n);

		return joueur;
	}

	private static int jouer(Scanner cin)
	{
		int poptarts = (int)(Math.random()*10+10);
		int i = 1;
		while(poptarts != 0)
		{
			i++;
			if(i%2 == 0)
			{
				System.out.println("\nIl reste " + poptarts + " poptarts.");
				poptarts -= jeuJoueur(poptarts, cin);
			}
			if(i%2 == 1)
			{
				System.out.println("\nIl reste " + poptarts + " poptarts.");
				System.out.println("A l'ordi de jouer...");
				poptarts -= jeuOrdi(poptarts);
			}
		}

		return i%2;
	}

	private static int[] addTab(int[] resultTab, int result)
	{
		int table[] = new int[resultTab.length + 1];
		for(int i=0; i<resultTab.length; i++)
		{
			table[i] = resultTab[i];
		}
		table[resultTab.length] = result;
		return table;
	}

	private static int menu(int[] resultTab, Scanner cin)
	{
		System.out.println("\n--------------- MENU ----------------");
		System.out.println("\n# exit : quitter le jeu.");
		System.out.println("# again : rejouer.");
		System.out.println("# stat : afficher les statistiques.");
		System.out.println("\nQue souhaitez vous faire ?");
		boolean isdone = false;
		int returned = 0;
		do
		{
			System.out.print(">>> ");
			String cmd = cin.next();
			if(cmd.equals("stat"))
				afficheStat(resultTab);
			else if(cmd.equals("again"))
			{
				isdone = true;
				returned = 1;
			}
			else if(cmd.equals("exit"))
			{
				isdone = true;
			}
			else
				System.out.println("Cette commande n'est pas definie.");
		}while(!isdone);

		return returned;
	}

	private static void afficheStat(int[] resultTab)
	{
		System.out.println("\n# STAT");
		System.out.println("0: perdu   1: gagne\n");
		for(int i=0; i<resultTab.length; i++)
		{
			System.out.println("Partie " + i + " ........ " + resultTab[i]);
		}
		double moyenne = 0;
		for(int i=0; i<resultTab.length; i++)
		{
			moyenne += resultTab[i];
		}
		moyenne = moyenne / resultTab.length * 100;
		System.out.println("\nVotre taux de reussite est de " + moyenne + " %\n");
	}
}