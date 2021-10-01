import java.util.Scanner;

class Exercice
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		double result = -1;
		boolean isTrue = false;

		System.out.println("Entrer la valeur du rayon :");
		double r = cin.nextDouble();

		while(!isTrue)
		{
			if(r>0)
			{
				result = 2*r*Math.PI;
				isTrue = true;
			}
			else
			{
				System.out.println("Erreur de syntaxe. Entrer la valeur du rayon :");
				r = cin.nextDouble();
			}
		}
		
		System.out.println("Le perimetre d'un cercle de rayon " + r + " est : " + result);
	}
}