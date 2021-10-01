import java.util.Scanner;

class Map
{
	public static void main(String[] args)
	{
		String[] villes = saisirVille();
		int[][] distances = saisirDistance(villes);
		System.out.println();
		afficheDistance(distances);
		System.out.println();
		int[] parcours = saisirParcours(villes, distances);
		System.out.println();
		afficheParcours(parcours, villes);
		System.out.print("Distance totale parcourue pour ce parcours : " + distanceParcours(parcours, distances) + " km.");
	}

	private static String[] saisirVille()
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Combien de villes voulez-vous saisir ?");
		int n;
		do
		{
			System.out.print(">>> ");
			n = cin.nextInt();
		}while(n<1);
		String[] villes = new String[n];
		System.out.println("Saisissez les villes :");
		for(int i=0; i<n; i++)
		{
			if(i==0)
				cin.nextLine(); // Permet de replacer le curseur sur la bonne ligne avant de saisir les villes
			System.out.print(i + ": ");
			villes[i] = cin.nextLine();
		}
		return villes;
	}

	private static void afficheVille(String[] villes)
	{
		for(int i=0; i<villes.length; i++)
		{
			System.out.println(i + " " + villes[i]);
		}
	}

	private static int[][] saisirDistance(String[] villes)
	{
		Scanner cin = new Scanner(System.in);
		int[][] distances = new int[villes.length][villes.length];
		for(int i=0; i<villes.length; i++)
		{
			for(int j=i; j<villes.length; j++)
			{
				if(i==j)
					distances[i][j] = 0;
				else
				{
					System.out.println("Entrez la distance entre " + villes[i] + " et " + villes[j] + " :");
					do
					{
						System.out.print(">>> ");
						distances[i][j] = cin.nextInt();
					}while(distances[i][j] < 0);
				}
			}
		}
		for(int i=0; i<villes.length; i++)
		{
			for(int j=0; j<i; j++)
			{
				// possible car distances est un matrice carrée
				distances[i][j] = distances[j][i];
			}
		}
		return distances;
	}

	private static void afficheDistance(int[][] distances)
	{
		for(int i=0; i<distances.length; i++)
		{
			for(int j=0; j<distances[i].length; j++)
			{
				System.out.print(distances[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[] saisirParcours(String[] villes, int[][] distances)
	{
		int n;
		Scanner cin = new Scanner(System.in);
		System.out.println("Combien de villes souhaitez-vous visiter ? (au moins 2)");
		do
		{
			System.out.print(">>> ");
			n = cin.nextInt();
			if(n<2)
				System.out.println("Valeur interdite. Reessayer.");
		}while(n<2);
		int[] parcours = new int[n];
		System.out.println("Entrez votre parcours parmi ces villes (numeros uniquement) :");
		afficheVille(villes);
		System.out.println();
		boolean	bool;
		do
		{
			System.out.print(">>> ");
			for(int i=0; i<parcours.length; i++)
			{
				parcours[i] = cin.nextInt();
			}
			bool = estValide(parcours, distances);
			if(!bool)
				System.out.println("Parcours incorrect. Reessayer.");
		}while(!bool);
		return parcours;
	}

	private static boolean estValide(int[] parcours, int[][] distances)
	{
		int i=1;
		boolean bool = true;
		while(i<parcours.length && bool)
		{
			if(distances[parcours[i-1]][parcours[i]] <= 0)
				bool = false;
			i++;
		}
		return bool;
	}

	private static void afficheParcours(int[] parcours, String[] villes)
	{
		System.out.print("Votre parcours : ");
		for(int i=0; i<parcours.length; i++)
		{
			System.out.print(villes[parcours[i]] + " > ");
		}
		System.out.println();
	}

	private static int distanceParcours(int[] parcours, int[][] distances)
	{
		int result = 0;
		for(int i=1; i<parcours.length; i++)
		{
			result += distances[parcours[i-1]][parcours[i]];
		}
		return result;
	}
}