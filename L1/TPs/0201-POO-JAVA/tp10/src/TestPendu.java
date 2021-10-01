/**
 * Classe TestPendu
 * @author Jessica Jonquet
 * @version 25/03/2019
 */
import java.util.Scanner;
public class TestPendu{
	public static void main(String[] args) {    
		Scanner clavier = new Scanner(System.in);
		boolean fini = true;
		boolean invalide = false;

		char lettre;
		Pendu p = null;
		String mot;

		do
		{
			System.out.println("\nSaisir un mot d'au moins 4 lettres a deviner : ");
			mot = clavier.nextLine();
			try
			{
				p = new Pendu(mot);
				invalide = false;
			}
			catch(PenduException e)
			{
				System.out.println(e.getMessage());
				invalide = true;
			}
		}while(invalide);

		if(p == null)
		{
			System.err.println("Une erreur est survenue...");
			return;
		}
		
		do
		{
			p.afficherEssais();
			System.out.print("\nEntrez une lettre : ");
			lettre = clavier.nextLine().charAt(0);
		}while(p.jouer(lettre) && !p.estFini());
		p.afficherEssais();
		if(p.estFini())
			System.out.println("Gagne !!!!!");
		else{
			System.out.println("Perdu :-(");
			System.out.print("\nLa solution est : "+p.getMot());
		}
	}
}