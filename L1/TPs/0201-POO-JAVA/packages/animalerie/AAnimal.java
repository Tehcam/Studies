package animalerie;

public abstract class AAnimal implements IAnimal
{
	private String nom;
	private int nbPattes;
	private int nbAiles;

	public AAnimal(String nom, int nbPattes, int nbAiles)
	{
		if(nbPattes < 0)
			throw new ArithmeticException("Nombre de pattes < 0.");
		if(nbAiles < 0)
			throw new ArithmeticException("Nombre d'ailes < 0.");
		this.nbPattes = nbPattes;
		this.nbAiles = nbAiles;
		this.nom = nom;
	}

	public AAnimal(AAnimal ref)
	{
		this.nom = ref.nom;
		this.nbPattes = ref.nbPattes;
		this.nbAiles = ref.nbAiles;
	}

	public String getNom()
	{
		return nom;
	}

	public int getNbPattes()
	{
		return nbPattes;
	}

	public int getNbAiles()
	{
		return nbAiles;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void arracherPatte()
	{
		if(nbPattes > 0)
		{
			nbPattes--;
			crier();
		}
	}

	public void arracherAile()
	{
		if(nbAiles > 0)
		{
			nbAiles--;
			crier();
		}
	}

	public abstract void crier();

	@Override
	public String toString()
	{
		return nom + ", animal a " + nbPattes + " pattes et " + nbAiles + " ailes.";
	}

	public void afficher()
	{
		System.out.println(this);
	}
}