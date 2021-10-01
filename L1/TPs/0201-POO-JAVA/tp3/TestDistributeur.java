import java.util.Scanner;

public class TestDistributeur
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		DistributeurCafe machine = null;
		int rep;
		boolean next;
		try
		{
			machine = new DistributeurCafe(20, 2.5);
			machine.ajouterDosettes(20);
			machine.remplirReservoir(2.5);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Creaction d'une machine par defaut.");
			machine = new DistributeurCafe();
			machine.ajouterDosettes(10);
			machine.remplirReservoir(2);
		}
		try
		{
			if(machine == null)
				throw new Error("La machine n'a pas pu etre creee.");
			machine.afficher();
			System.out.println("La machine est operationnelle.");
			do
			{
				menu();
				System.out.print(">>> ");
				rep = cin.nextInt();
				next = action(rep, machine);
			}while(next);
		}
		catch(Error e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Fin du programme.");
		}
	}

	private static void menu()
	{
		System.out.println("\nMENU");
		System.out.println("1) Affichage");
		System.out.println("2) Boire un cafe court");
		System.out.println("3) Boire un cafe long");
		System.out.println("4) Ajouter des dosettes");
		System.out.println("5) Remplir le reservoir");
		System.out.println("6) Prix");
		System.out.println("\nQue desirez vous ?");
	}

	private static boolean action(int rep, DistributeurCafe machine)
	{
		Scanner cin = new Scanner(System.in);
		switch(rep)
		{
			case 1 : machine.afficher(); break;
			case 2 : cafeCourt(machine); break;
			case 3 : cafeLong(machine); break;
			case 4 : ajouter(machine); break;
			case 5 : remplir(machine); break;
			case 6 : prix(machine); break;
			default : System.out.println("Vous n'avez selectionne aucune action valide.");
		}
		System.out.print("Continuer ? o/n ");
		if(cin.nextLine().charAt(0) == 'o')
			return true;
		else
			return false;
	}

	private static void cafeCourt(DistributeurCafe machine)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Inserer monnaie.");
		machine.boireCafeCourt(cin.nextDouble());
	}

	private static void cafeLong(DistributeurCafe machine)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Inserer monnaie.");
		machine.boireCafeLong(cin.nextDouble());
	}

	private static void ajouter(DistributeurCafe machine)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Combien de dosettes voulez vous ajouter dans la machine ?");
		machine.ajouterDosettes(cin.nextInt());
	}

	private static void remplir(DistributeurCafe machine)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println	("Quelle quantite d'eau voulez vous ajouter dans le reservoir ?");
		machine.remplirReservoir(cin.nextDouble());
	}

	private static void prix(DistributeurCafe machine)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("\nPRIX DES CAFES");
		System.out.println("1) Combien coutent les cafes ?");
		System.out.println("2) Modifier les prix");
		System.out.println("3) Augmentation");
		switch(cin.nextInt())
		{
			case 1 : 
				System.out.println("Cafe court : " + DistributeurCafe.getPrixCourt() + " eur.");
				System.out.println("Cafe long : " + DistributeurCafe.getPrixLong() + " eur.");
				break;
			case 2 : 
				System.out.println("Nouveau prix cafe court :");
				try
				{
					DistributeurCafe.setPrixCourt(cin.nextDouble());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
					System.out.println("Le prix reste inchange.");
				}
				System.out.println("Nouveau prix cafe long :");
				try
				{
					DistributeurCafe.setPrixLong(cin.nextDouble());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
					System.out.println("Le prix reste inchange.");
				}
				break;
			case 3 :
				System.out.println("Pourcentage d'Augmentation : ");
				try
				{
					DistributeurCafe.augmenter(cin.nextDouble());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
					System.out.println("Les prix restent inchanges.");
				}
				break;
			default : System.out.println("Vous n'avez selectionne aucune action valide.");
		}
	}
}