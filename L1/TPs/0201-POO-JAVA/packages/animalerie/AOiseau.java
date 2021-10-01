package animalerie;

public abstract class AOiseau extends AAnimal
{
	public AOiseau(String nom)
	{
		super(nom, 2, 2);
	}

	@Override
	public String toString()
	{
		return getNom() + ", oiseau a " + getNbPattes() + " pattes et " + getNbAiles() + " ailes.";
	}
}