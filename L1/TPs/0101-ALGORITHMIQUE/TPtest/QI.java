import java.util.Scanner;

class QI
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Entrer le nombre de chansons de l'album : ");
		int n;
		do
		{
			n = cin.nextInt();
			if(n<1)
				System.out.println("Valeur incorrecte. Saisir un nombre strictement positif.");
		}while(n<1);
		int[] album = new int[n];
		production(album);
		affichage(album);
		System.out.print("QI de depart (entre 50 et 150) : ");
		int qi;
		do
		{
			qi = cin.nextInt();
			if(qi < 50 || qi > 150)
				System.out.println("Valeur incorrecte. Saisir un nombre entre 50 et 150.");
		}while(qi < 50 || qi > 150);
		System.out.println(dureeAlbum(album));
		System.out.println("QI apres ecoute : " + (qi - 4*chansonQI(album)));
		System.out.println("Nombres de chansons pour perdre au min 10pts de QI : " + chansonQI(album));
		int[] stat = stats(album);
		System.out.println("Duree de l'album : " + stat[0] + "h" + stat[1] + "min" + stat[2] + "s");
		System.out.println("Nombre de chansons de plus de 3min : " + stat[3]);
	}

	private static void production(int[] album)
	{
		for(int i=0; i<album.length; i++)
		{
			album[i] = aleatoire(120, 240);
		}
	}

	private static int aleatoire(int inf, int sup)
	{
		return (int)(Math.random()*(sup-inf+1))+inf;
	}

	private static void affichage(int[] album)
	{
		int m, s;
		for(int i=0; i<album.length; i++)
		{
			m = album[i] / 60;
			s = album[i] % 60;
			System.out.println("Chanson " + (i+1) + " : " + m + "'" + s + "''");
		}
	}

	private static int dureeAlbum(int[] album)
	{
		int res = 0;
		for(int i=0; i<album.length; i++)
		{
			res += album[i];
		}
		return res;
	}

	private static int chansonQI(int[] album)
	{
		return dureeAlbum(album) % album.length;
	}

	private static int[] stats(int[] album)
	{
		int time = dureeAlbum(album);
		int[] stat = new int[4];
		int s = time%60;
		time = (time-s)/60;
		int m = time%60;
		int h = (time-m)/60;

		int k=0;
		for(int i=0; i<album.length; i++)
		{
			if(album[i] > 180)
				k++;
		}

		stat[0] = h;
		stat[1] = m;
		stat[2] = s;
		stat[3] = k;

		return stat;
	}
}