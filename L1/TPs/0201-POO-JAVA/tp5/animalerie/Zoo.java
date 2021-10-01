package animalerie;

public class Zoo implements IZoo
{
	private final int nbCage;
	private Animal[] cages;

	public Zoo()
	{
		nbCage = (int)(Math.random() * 10 + 1) + 10;
		cages = new Animal[nbCage];
	}

	public Zoo(final int nbCage)
	{
		if(nbCage < 10)
			throw new ArithmeticException("Nombre de cages < 10.");
		if(nbCage > 20)
			throw new ArithmeticException("Nombre de cages > 20.");
		this.nbCage = nbCage;
		cages = new Animal[nbCage];
	}

	public void ajouterAnimal(Animal a, int i)
	{
		if(i<0 || i>cages.length-1)
			throw new ArithmeticException("Cage inexistante.");
		cages[i] = a;
	}

	public Animal getAnimal(int i)
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

	@Override
	public String toString()
	{
		return getClass().getName() + " contient " + nbCage + " animaux.";
	}

	public void afficher()
	{
		System.out.println(this);
	}
}