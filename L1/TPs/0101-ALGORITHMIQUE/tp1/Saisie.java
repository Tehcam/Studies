import java.util.Scanner;

class Saisie
{
	public static void main(String[] args)
	{
		System.out.print("Bonjour ");
		System.out.println("tout le monde !");

		Scanner clavier = new Scanner(System.in);

		int a;
		System.out.print("Saisir un entier : ");
		a = clavier.nextInt();
		
		System.out.print("Vous avez saisi l'entier : " + a);
	}
}