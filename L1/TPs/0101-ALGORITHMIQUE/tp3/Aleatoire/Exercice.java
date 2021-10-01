import java.util.Scanner;

class Exercice
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		double x = Math.random()*10-5;
		double min = x, max = x;

		System.out.print("Entrer un entier : ");
		int n = cin.nextInt();

		System.out.println(x);
		for(int i=1; i<n; i++)
		{
			x = Math.random()*10-5;
			if(x>max)
				max = x;
			if(x<min)
				min = x;
			System.out.println(x);
		}

		System.out.println();
		System.out.println("Le maximum de cette serie est : " + max);
		System.out.println("Le minimum de cette serie est : " + min);
	}
}