import java.util.Scanner;

class TestPersonne
{
	public static void main(String[] args)
	{
		Personne p1 = new Personne("M", "MACHET", "Corentin", 18, 1.60, 55.0);
		p1.setTaille(1.50);
		p1.setPoids(55);
		p1.vieillir();
		p1.afficher();
		Personne p2 = saisirPerso();
		p2.afficher();
		p2.interpreter();
	}

	private static Personne saisirPerso()
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("### CREATION D'UN PROFIL ###");
		String civilite, nom, prenom;
		int age;
		double taille, poids;
		Personne p;

		do{
			System.out.print("De quelle civilite est cette personne ? ");
			civilite = cin.nextLine();
			System.out.print("Quel est son nom ? ");
			nom = cin.nextLine();
			System.out.print("Quel est son prenom ? ");
			prenom = cin.nextLine();
			System.out.print("Precisez son age (en annees) : ");
			age = cin.nextInt();
			System.out.print("Sa taille : ");
			taille = cin.nextDouble();
			System.out.print("Son poids : ");
			poids = cin.nextDouble();
			p = new Personne(civilite, nom, prenom, age, taille, poids);
		}while(!confirm(p));
		System.out.println("Profil valide avec succes.");

		return p;
	}

	private static boolean confirm(Personne p)
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Voici le details du profil :");
		System.out.println(p.getCivilite()+", "+p.getNom()+", "+p.getPrenom()+", "+p.getAge()+"ans, "+p.getTaille()+"m, "+p.getPoids()+"kg.");
		System.out.print("Confirmer ? (o/n) ");
		char rep = cin.nextLine().charAt(0);
		return rep == 'o';
	}
}