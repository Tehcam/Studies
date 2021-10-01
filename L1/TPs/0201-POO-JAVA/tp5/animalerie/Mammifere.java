package animalerie;

public class Mammifere extends Animal
{
	public Mammifere(String nom)
	{
		super();
		this.setNom(nom);
	}

	@Override
	public String toString()
	{
		return getNom() + ", mammifere a " + getNbPattes() + " pattes.";
	}
}