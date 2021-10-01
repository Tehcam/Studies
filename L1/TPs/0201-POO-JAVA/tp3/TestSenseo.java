import java.util.Scanner;

public class TestSenseo
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		Senseo senseo = new Senseo();
		senseo.afficher();
		do
		{
			System.out.println("\nMENU");
			System.out.println("1) Affichage");
			System.out.println("2) Mettre dosette");
			System.out.println("3) Mettre eau");
			System.out.println("4) Boire cafe court");
			System.out.println("5) Boire cafe long");
			System.out.println("Que voulez vous faire ?");
			System.out.print(">>> ");
		}while(menu(cin.nextInt(), senseo));
	}

	public static boolean menu(int rep, Senseo senseo)
	{
		Scanner cin = new Scanner(System.in);
		switch(rep)
		{
			case 1: senseo.afficher(); break;
			case 2: senseo.ajouterDosettes(1); break;
			case 3: senseo.remplirReservoir(Senseo.getCapaciteEau()); break;
			case 4: senseo.boireCafeCourt(0); break;
			case 5: senseo.boireCafeLong(0); break;
			default : System.out.println("Cette action n'est pas repertoriee !");
		}
		System.out.println("\nVoulez vous continuer ? o/n");
		System.out.print(">>> ");
		char b = cin.nextLine().charAt(0);
		return b == 'o';
	}
}