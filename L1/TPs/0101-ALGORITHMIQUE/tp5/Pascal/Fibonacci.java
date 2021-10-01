import java.util.Scanner;

class Fibonacci
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Quel mois ? ");
		fibonacci(cin.nextInt());
	}

	private static int factorielle(int n)
	{
		int result = 1;
		for(int i=2; i<=n; i++)
		{
			result *= i;
		}
		return result;
	}

	private static int coeffBinomial(int n, int p)
	{
		return factorielle(n)/(factorielle(n-p)*factorielle(p));
	}

	private static int coeffMax(int n)
	{
		int max = coeffBinomial(n, 0);
		for(int i=1; i<=n; i++)
		{
			if(coeffBinomial(n, i) > max)
			{
				max = coeffBinomial(n, i);
			}
		}
		return max;
	}

	private static int ligneMax(int limit)
	{
		boolean isOver = false;
		int n=0;
		while(!isOver)
		{
			if(coeffMax(n) >= limit)
				isOver = true;
			else
				n++;
		}
		return n;
	}

	private static int puissance2(int n)
	{
		int result = 0;
		for(int i=0; i<=n; i++)
		{
			result += coeffBinomial(n, i);
		}
		return result;
	}

	private static int sommeCoeff(int n)
	{
		int result = 0;
		for(int i=0; i<=n; i++)
		{
			result += puissance2(i);
		}
		return result;
	}

	private static int nbLapins(int mois)
	{
		int n = mois - 1;
		int p = 0;
		int result = coeffBinomial(n, p);
		while(n>=0 && n>=p)
		{
			n--; p++;
			if(n>=0 && n>=p)
				result += coeffBinomial(n, p);
		}
		return result;
	}

	private static void fibonacci(int mois)
	{
		for(int i=1; i<=mois; i++)
		{
			System.out.print(nbLapins(i) + " ");
		}
	}
}