import java.util.Scanner;

public class TestMorpionIHM
{
	public static void main(String[] args)
    {
    	Scanner cin = new Scanner(System.in);
    	System.out.println("BIENVENU SUR LE JEU DU MORPION !");
    	System.out.println("Entrer le nom des joueurs :");
    	System.out.print("Joueur 1 > ");
    	String j1 = cin.nextLine();
    	System.out.print("Joueur 2 > ");
    	String j2 = cin.nextLine();
        var windows = new MorpionIHM(j1, j2, "Morpion");
        // System.out.println(windows);
    }
}