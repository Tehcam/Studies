import java.util.Scanner;

public class TestPoint2
{
	public static void main(String[] args)
	{
		IPoint[] t = new IPoint[5];
		Scanner cin = new Scanner(System.in);
		int type;
		double a, b;

		for(int i=0; i<5; i++)
		{
			System.out.println("Choisir un type de point.");
			System.out.println("1 : cartesien");
			System.out.println("2 : polaire");
			do
			{
				type = cin.nextInt();
				if(type != 1 && type != 2)
					System.out.println("Valeur impossible.");
			}while(type != 1 && type != 2);
			switch(type)
			{
				case 1:
					System.out.print("Abscisse : ");
					a = cin.nextDouble();
					System.out.print("Ordonnee : ");
					b = cin.nextDouble();
					t[i] = new PointCartesien(a, b);
					break;
				case 2:
					System.out.print("Longueur : ");
					a = cin.nextDouble();
					System.out.print("Angle : ");
					b = cin.nextDouble();
					t[i] = new PointPolaire(a, b);
					break;
			}
			System.out.println();
		}

		for(int i=0; i<5; i++)
		{
			System.out.println("Point " + (i+1));
			t[i].afficher();
			System.out.println(t[i].distanceALOrigine());
		}
	}
}