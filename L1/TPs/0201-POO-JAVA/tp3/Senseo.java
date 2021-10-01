/**
 * Classe <strong>Senseo</strong> qui impl&eacute;mente l'interface
 * <i>IDistributeur</i>.
 * G&egrave;re les cafeti&egrave;res Senseo pour particuliers.
 * @see IDistributeur interface impl&eacute;ment&eacute;e.
 * @author Corentin MACHET
 * @version 1.0
 */

public class Senseo implements IDistributeur
{
	// Nombre maximum de dosette que peut contenir une machine Senseo
	private static final int capaciteDosettes = 1;

	// Quantite maximum d'eau dans le reservoir de la machine (en L)
	private static final double capaciteEau = 1;

	// Nombre de dosettes restantes
	private int nbDosettes = 0;

	// Quantite d'eau restante
	private double nbEau = 0;

	/** 
	 * Getter : renvoie le nombre max de dosettes que peut contenir la machine.
	 * @return nombre max de dosettes.
	 */
	public static int getCapaciteDosettes()
	{
		return capaciteDosettes;
	}

	/** 
	 * Getter : renvoie la quantit&eacute; max d'eau que peut contenir
	 * le r&eacute;servoir.
	 * @return quantit&eacute; d'eau max.
	 */
	public static double getCapaciteEau()
	{
		return capaciteEau;
	}

	/**
	 * Getter : renvoie le nombre de dosettes restantes dans la machine.
	 * @return nombre de dosettes restantes.
	 */
	public int getNbDosettes()
	{
		return nbDosettes;
	}

	/** 
	 * Getter : renvoie la quantit&eacute; d'eau restante dans
	 * le r&eacute;servoir.
	 * @return quantit&eacute; d'eau restante.
	 */ 
	public double getNbEau()
	{
		return nbEau;
	}

	/**
	 * Permet de boire un caf&eacute; court.
	 * @param montant le montant ins&eacute;r&eacute; par l'utilisateur 
	 * @return la monnaie rendue
	 */
	public double boireCafeCourt(double montant)
	{
		try
		{
			if(nbDosettes <= 0)
				throw new ArithmeticException("Il n'y a plus de dosettes.");
			if(nbEau < 0.10)
				throw new ArithmeticException("Il n'y a plus assez d'eau.");
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
			return montant;
		}
		nbDosettes--;
		nbEau -= 0.10;
		return montant;
	}

	/**
	 * Permet de boire un caf&eacute; long.
	 * @param montant le montant ins&eacute;r&eacute; par l'utilisateur 
	 * @return la monnaie rendue
	 */
	public double boireCafeLong(double montant)
	{
		try
		{
			if(nbDosettes <= 0)
				throw new ArithmeticException("Il n'y a plus de dosettes.");
			if(nbEau < 0.25)
				throw new ArithmeticException("Il n'y a plus assez d'eau.");
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
			return montant;
		}
		nbDosettes--;
		nbEau -= 0.25;
		return montant;
	}

	/**
	 * Ajoute des dosettes dans le distributeur.
	 * @param nbDosettes le nombre de dosettes &agrave; ajouter
	 */
	public void ajouterDosettes(int nbDosettes)
	{
		try
		{
			if(nbDosettes < 0)
				throw new ArithmeticException("On ne peut pas ajouter un nombre negatif de dosettes.");
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Le nombre de dosettes reste inchange.");
		}
		if(nbDosettes + this.nbDosettes <= capaciteDosettes)
			this.nbDosettes += nbDosettes;
		else
			this.nbDosettes = capaciteDosettes;
	}

	/**
	 * Rempli le r&eacute;servoir d'eau du distributeur
	 * @param quantite la quantit&eacute; d'eau &agrave; ajouter
	 */
	public void remplirReservoir(double quantite)
	{
		try
		{
			if(quantite < 0)
				throw new ArithmeticException("On ne peut pas ajouter une quantite d'eau negative.");
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
			System.out.println("La quantite d'eau reste inchangee.");
		}
		if(quantite + nbEau <= capaciteEau)
			nbEau += quantite;
		else
			nbEau = capaciteEau;
	}

	/**
	 * Renvoie la description de l'objet courant sous forme
	 * d'une chaine de caract&egrave;res.
	 * @return description
	 */
	public String toString()
	{
		return "Senseo : " + nbDosettes + "/" + capaciteDosettes + " doses ; " + nbEau + "/" + capaciteDosettes + " L.";
	}

	/**
	 * Affichage de l'objet courant &agrave; la console.
	 * @see toString() description
	 */
	public void afficher()
	{
		System.out.println(this);
	}
}