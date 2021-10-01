import java.io.*;

public class Toutou
{
	private String nom;
	private int nbPuces;

	public Toutou()
	{
		nom = "Rex";
		nbPuces = 0;
	}

	public Toutou(String nom, int nbPuces) throws IOException
	{
		if(nom == null || nom == "")
			throw new IOException("Le nom du toutou ne doit pas etre vide.");
		if(nbPuces < 0)
			throw new IOException("Le nombre de puces ne peut pas etre negatif.");
		this.nom = nom;
		this.nbPuces = nbPuces;
	}

	public String getNom()
	{
		return nom;
	}

	public int getNbPuces()
	{
		return nbPuces;
	}

	public void setNbPuces(int n) throws IOException
	{
		if(n < 0)
			throw new IOException("Le nombre de puces ne peut pas etre negatif.");
		nbPuces = n;
	}

	public String toString()
	{
		return "Ce toutou s'appelle " + nom + " et a " + nbPuces + " puces.";
	}

	public boolean egalA(Toutou ref)
	{
		return (this.nom.equals(ref.nom) && this.nbPuces == ref.nbPuces);
	}
}