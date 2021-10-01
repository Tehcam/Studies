package animalerie;

public abstract class AInsecte extends AAnimal
{
	public AInsecte(String nom, int nbAiles)
	{
		super(nom, 6, nbAiles);
	}

	@Override
	public String toString()
	{
		return getNom() + ", insecte a " + getNbPattes() + " pattes et " + getNbAiles() + " ailes.";
	}
}