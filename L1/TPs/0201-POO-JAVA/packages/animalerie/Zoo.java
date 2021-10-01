package animalerie;

public class Zoo implements IZoo
{
	private final int nbCage;
	private AAnimal[] cages;

	public Zoo()
	{
		nbCage = (int)(Math.random() * 10 + 1) + 10;
		cages = new AAnimal[nbCage];
	}

	public Zoo(final int nbCage)
	{
		if(nbCage < 10)
			throw new ArithmeticException("Nombre de cages < 10.");
		if(nbCage > 20)
			throw new ArithmeticException("Nombre de cages > 20.");
		this.nbCage = nbCage;
		cages = new AAnimal[nbCage];
	}

	public void ajouterAnimal(AAnimal a, int i)
	{
		if(i<0 || i>cages.length-1)
			throw new ArithmeticException("Cage inexistante.");
		if(cages[i] != null)
			throw new IllegalArgumentException("Il y a deja un animal dans cette cage.");
		cages[i] = a;
	}

	public AAnimal getAnimal(int i)
	{
		if(i<0 || i>cages.length-1)
			throw new ArithmeticException("Cage inexistante.");
		return cages[i];
	}

	public void supprimerAnimal(int i)
	{
		if(i<0 || i>cages.length-1)
			throw new ArithmeticException("Cage inexistante.");
		cages[i] = null;
	}

	public void faireCrier()
	{
		for(int i=0; i<cages.length; i++)
		{
			if(cages[i] != null)
				cages[i].crier();
		}
	}

	public void desastre()
	{
		int c = (int)(Math.random()*nbCage);
		int patteOuAile = (int)(Math.random()*2+1);
		switch(patteOuAile)
		{
			case 1:
				if(cages[c] != null) cages[c].arracherPatte();
				break;
			case 2:
				if(cages[c] != null) cages[c].arracherAile();
				break;
		}
	}

	public int getNombrePattes()
	{
		int n=0;
		for(int i=0; i<cages.length; i++)
		{
			if(cages[i] != null)
			{
				n += cages[i].getNbPattes();
			}
		}
		return n;
	}

	public int getNombreAiles()
	{
		int n=0;
		for(int i=0; i<cages.length; i++)
		{
			if(cages[i] != null)
			{
				n += cages[i].getNbAiles();
			}
		}
		return n;
	}

	@Override
	public String toString()
	{
		String res = "";
		int nb = 0;
		for(int i=0; i<cages.length; i++)
		{
			if(cages[i] != null)
			{
				nb++;
				res += "\nCage " + i + " : " + cages[i].toString();
			}
		}
		return getClass().getName() + " contient " + nb + " animaux parmi " + nbCage + " cages." + res;
	}

	public void afficher()
	{
		System.out.println(this);
	}
}