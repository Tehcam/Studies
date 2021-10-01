class Exercice
{
	public static void main(String[] args)
	{
		int tab[] = new int[3];
		tab[0] = 1;
		tab[1] = 20;
		tab[2] = 15;

		for(int i=0; i<tab.length; i++)
		{
			System.out.println(i + " => " + tab[i]);
		}

		System.out.println("\n" + tab);
	}
}