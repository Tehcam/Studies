package animalerie;

public abstract class AMammifere extends AAnimal
{
	public AMammifere(String nom)
	{
		super(nom, 4, 0);
	}

	@Override
	public String toString()
	{
		return getNom() + ", mammifere a " + getNbPattes() + " pattes et " + getNbAiles() + " ailes.";
	}
}