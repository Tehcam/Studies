import animalerie.Zoo;
import animalerie.Chien;
import animalerie.Chat;
import java.util.Scanner;

public class TestZoo
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		Zoo zoo = new Zoo();
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
			System.out.print(">>> ");
			rep = cin.nextInt();
		}while(menu(rep, zoo));
		System.out.println("Fin du programme.");
	}

	public static boolean menu(int rep, Zoo zoo)
	{
		Scanner cin = new Scanner(System.in);

		switch(rep)
		{
			case 1: zoo.afficher(); break;
			case 2: ajouter(zoo); break;
			case 3: suppr(zoo); break;
			case 4: zoo.faireCrier(); break;
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

	public static void ajouter(Zoo zoo)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Dans quelle cage voulez vous ajouter l'animal ?");
		System.out.print(">>> ");
		int i = cin.nextInt();
		System.out.println("Quel nom lui donneriez vous ?");
		System.out.print(">>> ");
		String n = cin.nextLine();
		System.out.println("Est-ce un chien (1) ou chat (2) ?");
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
				break;
			default: System.out.println("Requete impossible.");
		}
	}

	public static void suppr(Zoo zoo)
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