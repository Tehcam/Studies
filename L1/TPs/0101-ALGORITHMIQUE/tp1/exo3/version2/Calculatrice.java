import java.util.Scanner;

class Calculatrice
{
	public static void main(String[] args)
	{
		System.out.println("Calcul entre deux entiers : ");

		Scanner clav = new Scanner(System.in);
		int a, b, rep = 0;
		String operator;

		System.out.print("val a : ");
		a = clav.nextInt();
		System.out.print("operation : ");
		operator = clav.next();
		System.out.print("val b : ");
		b = clav.nextInt();

		switch(operator)
		{
			case "+" :
				rep = a+b;
				System.out.println("Resultat : " + a + " + " + b + " = " + rep);
				break;
			case "-" :
				rep = a-b;
				System.out.println("Resultat : " + a + " - " + b + " = " + rep);
				break;
			case "*" :
				rep = a*b;
				System.out.println("Resultat : " + a + " * " + b + " = " + rep);
				break;
			case "/" :
				if(b != 0)
				{
					rep = a/b;
					System.out.println("Resultat : " + a + " / " + b + " = " + rep);
				}else{
					System.out.println("Erreur : impossible de diviser par 0");
				}
				break;
			default :
				System.out.println("Erreur : l'operateur n'est pas valide");
		}
	}
}