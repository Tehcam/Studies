package animalerie;

public class Chien extends Mammifere
{
	public Chien(String nom)
	{
		super(nom);
	}

	@Override
	public void crier()
	{
		System.out.println("Ouaf ouaf");
	}

	@Override
	public String toString()
	{
		return "Chien " + super.toString();
	}
}