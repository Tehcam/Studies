package animalerie;

public class Abeille extends AInsecte
{
	public Abeille(String nom, int nbAiles)
	{
		super(nom, nbAiles);
	}

	@Override
	public void crier()
	{
		System.out.println("Bzzz Bzzz");
	}

	@Override
	public String toString()
	{
		return "Abeille " + super.toString();
	}
}