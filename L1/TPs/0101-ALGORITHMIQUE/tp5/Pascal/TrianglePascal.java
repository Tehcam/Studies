import java.util.Scanner;

class TrianglePascal
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Afficher le triangle de Pascal jusque quelle ligne ? ");
		afficheTriangle(cin.nextInt());
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

	private static void afficheLigne(int n, int digit, int nbd)
	{
		afficheVal(coeffBinomial(n, 0), digit);
		for(int i=1; i<=n; i++)
		{
			afficheVal(coeffBinomial(n, i), nbd*2-1);
		}
	}

	private static void afficheTriangle(int n)
	{
		int nbd = nbDigits(coeffMax(n));
		int nbDigitMax;
		for(int i=0; i<=n; i++)
		{
			nbDigitMax = nbd*(n-i);
			afficheLigne(i, nbDigitMax, nbd);
			System.out.println();
		}
	}

	private static int nbDigits(int a)
	{
		int i=1;
		while(a >= 10)
		{
			a /= 10;
			i++;
		}
		return i;
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

	private static void afficheEspace(int a)
	{
		for(int i=0; i<=a; i++)
		{
			System.out.print(" ");
		}
	}

	private static void afficheVal(int val, int digit)
	{
		afficheEspace(digit - nbDigits(val));
		System.out.print(val);
	}
}