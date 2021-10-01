import animalerie.Zoo;
import animalerie.Chien;
import animalerie.Chat;
import animalerie.Pigeon;
import animalerie.Abeille;
import java.util.Scanner;

public class TestZoo
{
	private static Zoo zoo = new Zoo();

	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		// zoo = new Zoo();
		int rep;
		System.out.println("BIENVENU AU ZOO !");
		zoo.afficher();
		System.out.println();

		do
		{
			System.out.println("Que souhaitez vous faire ?");
			System.out.println("1. Afficher le zoo");
			System.out.println("2. Ajouter un animal");
			System.out.println("3. Supprimer un animal");
			System.out.println("4. Faire crier les animaux");
			System.out.println("5. Faire un desastre");
			System.out.println("6. Connaitre le nombre de pattes total");
			System.out.println("7. Connaitre le nombre d'ailes total");
			System.out.print(">>> ");
			rep = cin.nextInt();
		}while(menu(rep));
		System.out.println("Fin du programme.");
	}

	public static boolean menu(int rep)
	{
		Scanner cin = new Scanner(System.in);

		switch(rep)
		{
			case 1: zoo.afficher(); break;
			case 2: ajouter(); break;
			case 3: suppr(); break;
			case 4: zoo.faireCrier(); break;
			case 5: zoo.desastre(); break;
			case 6: System.out.println("Nombre total de pattes : " + zoo.getNombrePattes()); break;
			case 7: System.out.println("Nombre total d'ailes : " + zoo.getNombreAiles()); break;
			default : System.out.println("Cette action n'est pas possible."); 
		}

		System.out.println("Voulez vous continuer ? o/n");
		System.out.print(">>> ");
		char c = cin.nextLine().charAt(0);
		if(c == 'o')
			return true;
		else
			return false;
	}

	public static void ajouter()
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Dans quelle cage voulez vous ajouter l'animal ?");
		System.out.print(">>> ");
		int i = cin.nextInt();
		System.out.println("Quel nom lui donneriez vous ?");
		System.out.print(">>> ");
		String n = cin.nextLine();
		System.out.println("Est-ce un chien (1), un chat (2), un pigeon (3) ou une abeille (4) ?");
		System.out.print(">>> ");
		switch(cin.nextInt())
		{
			case 1: 
				try
				{
					zoo.ajouterAnimal(new Chien(n), i);
				}
				catch(ArithmeticException e)
				{
					System.out.println(e.getMessage());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 2: 
				try
				{
					zoo.ajouterAnimal(new Chat(n), i);
				}
				catch(ArithmeticException e)
				{
					System.out.println(e.getMessage());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try
				{
					zoo.ajouterAnimal(new Pigeon(n), i);
				}
				catch(ArithmeticException e)
				{
					System.out.println(e.getMessage());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try
				{
					zoo.ajouterAnimal(new Abeille(n, 2), i);
				}
				catch(ArithmeticException e)
				{
					System.out.println(e.getMessage());
				}
				catch(IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			default: System.out.println("Requete impossible.");
		}
	}

	public static void suppr()
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Dans quelle cage se trouve l'animal ?");
		System.out.print(">>> ");
		int i = cin.nextInt();
		try
		{
			zoo.supprimerAnimal(i);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}
	}
}