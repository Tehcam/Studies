package animalerie;

public class Pigeon extends AOiseau
{
	public Pigeon(String nom)
	{
		super(nom);
	}

	@Override
	public void crier()
	{
		System.out.println("Cuicuiii");
	}

	@Override
	public String toString()
	{
		return "Pigeon " + super.toString();
	}
}