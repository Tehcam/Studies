class Binaire
{
	public static void main(String[] args)
	{
		affiche("Le binaire de 60 :");
		affiche(int2bin(60));
		System.out.print("\n>>> ");
		affiche(int2bin(60, 8));
		affiche("Le decimal de 100101 :");
		int bin[] = new int[6];
		bin[0] = 1;
		bin[1] = 0;
		bin[2] = 0;
		bin[3] = 1;
		bin[4] = 0;
		bin[5] = 1;
		affiche(bin2int(bin));
		affiche("Le double de 100101 :");
		affiche(sommeBin(bin, bin));
		System.out.print("\n>>> ");
		affiche(bin2int(sommeBin(bin, bin)));
		affiche("Le complement a 2 de 100101 :");
		affiche(complementA2(bin));
	}

	// Question 1
	// Conversion d'un entier vers son binaire
	// sur un nombre de bytes imposés
	private static int[] int2bin(int val, int nb)
	{
		int bin[] = new int[nb];
		for(int i=bin.length-1; i>=0; i--)
		{
			bin[i] = val%2;
			val = (val - val%2)/2;
		}
		return bin;
	}

	// Amélioration de la question 1
	// Conversion d'un entier vers son binaire
	// sur un nombre de bytes dynamique
	private static int[] int2bin(int val)
	{
		int[] bin;
		if(val == positif(val))
		{
			bin = new int[nbBytes(val)];
			for(int i=bin.length-1; i>=0; i--)
			{
				bin[i] = val%2;
				val = (val - val%2)/2;
			}
		}else{
			val = positif(val);
			bin = new int[nbBytes(val)+1];
			for(int i=bin.length-1; i>0; i--)
			{
				bin[i] = val%2;
				val = (val - val%2)/2;
			}
			bin[0] = 1;
		}
		return bin;
	}

	// Question 2
	// Conversion d'un binaire vers un entier
	private static int bin2int(int[] bin)
	{
		int result = 0;
		for(int i=0; i<bin.length; i++)
		{
			result += pwr2(bin.length - 1 - i) * bin[i];
		}
		return result;
	}

	// Question 3
	// Somme de deux binaires
	private static int[] sommeBin(int[] bin1, int[] bin2)
	{
		return int2bin(bin2int(bin1) + bin2int(bin2));
	}

	// Complément à 1 d'un binaire
	// Nécessaire à la question 4
	private static int[] complementA1(int[] bin)
	{
		int comp[] = new int[bin.length];
		for(int i=0; i<bin.length; i++)
		{
			comp[i] = bin[i]==0 ? 1 : 0;
		}
		return comp;
	}

	// Question 4
	// Complément à 2 d'un binaire
	private static int[] complementA2(int[] bin)
	{
		bin = complementA1(bin);
		int index = bin.length - 1;
		if(bin[index] + 1 > 1)
		{
			do
			{
				bin[index] = 0;
				index--;
			}while(bin[index] + 1 > 1 && index >= 0);
			if(index >= 0)
				bin[index] = 1;
		}else{
			bin[index] = 1;
		}
		return bin;
	}

	// Puissance de 2 d'exposant passé en paramètre
	// Nécessaire à la question 2
	private static int pwr2(int exp)
	{
		int result = 1;
		for(int i=0; i<exp; i++)
		{
			result *= 2;
		}
		return result;
	}

	// Renvoi du nombre de 'bytes' (cases du tableau)
	// nécessaire à la conversion améliorée d'un entier
	// vers son binaire
	private static int nbBytes(int val)
	{
		int i=1;
		while(val/2 > 0)
		{
			val /= 2;
			i++;
		}
		return i;
	}

	private static int positif(int val)
	{
		return val<0 ? -val : val;
	}

	private static void affiche(int[] tab)
	{
		for(int i=0; i<tab.length; i++)
		{
			System.out.print(tab[i] + " ");
		}
	}

	private static void affiche(String str)
	{
		System.out.println("\n" + str);
		System.out.print(">>> ");
	}

	private static void affiche(int val)
	{
		System.out.print(val);
	}
}