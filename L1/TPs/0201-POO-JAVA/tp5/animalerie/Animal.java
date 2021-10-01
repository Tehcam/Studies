package animalerie;

public class Animal implements IAnimal
{
	private String nom;
	private int nbPattes;

	public Animal()
	{
		nom = "Animal";
		nbPattes = 4;
	}

	public Animal(String nom, int nbPattes)
	{
		if(nbPattes < 0)
			throw new ArithmeticException("Nombre de pattes nul.");
		this.nbPattes = nbPattes;
		this.nom = nom;
	}

	public Animal(Animal ref)
	{
		this.nom = ref.nom;
		this.nbPattes = ref.nbPattes;
	}

	public String getNom()
	{
		return nom;
	}

	public int getNbPattes()
	{
		return nbPattes;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void crier()
	{
		System.out.println("Hum hum");
	}

	@Override
	public String toString()
	{
		return nom + ", animal a " + nbPattes + " pattes.";
	}

	public void afficher()
	{
		System.out.println(this);
	}
}