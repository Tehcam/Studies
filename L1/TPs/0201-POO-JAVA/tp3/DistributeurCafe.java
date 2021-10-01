/**
 * Classe <strong>DistributeurCafe</strong> qui impl&eacute;mente 
 * l'interface <i>IDistributeur</i>.
 * @author Corentin MACHET
 * @version 1.0
 */

public class DistributeurCafe implements IDistributeur
{
	// Prix commun a tous les distributeur pour un cafe court.
	private static double prixCourt = 0.80;

	// Prix commun a tous les distributeur pour un cafe long.
	private static double prixLong = 1.0;

	// La capacite totale de dosettes que peut comprendre la machine.
	private final int capaciteDosettes;

	// La capacite totale du reservoir d'eau de la machine.
	private final double capaciteEau;

	// Le nombre de dosettes restantes.
	private int nbDosettes = 0;

	// La quantite d'eau restante.
	private double nbEau = 0;

	// Valeur de l'argent dans la machine.
	private double cagnotte = 0;

	/**
	 * Constructeur par <i>d&eacute;aut</i>.<br>
	 * La capacit&eacute; totale de dosette est fix&eacute;e &agrave; 10,
	 * et la capacit&eacute; du r&eacute;servoir &agrave; 2L.
	 */
	public DistributeurCafe()
	{
		capaciteDosettes = 10;
		capaciteEau = 2;
	}

	/**
	 * Constructeur par <i>initialisation</i>.<br>
	 * Les capacit&eacute;s des dosettes et du r&eacute;servoir
	 * d'eau sont pass&eacute;es en param&egrave;tres.
	 * @param capaciteDosettes capacit&eacute; totale de dosettes.
	 * @param capaciteEau capacit&eacute; totale du r&eacute;servoir d'eau.
	 */
	public DistributeurCafe(int capaciteDosettes, double capaciteEau) throws IllegalArgumentException
	{
		if(capaciteDosettes < 1)
			throw new IllegalArgumentException("Le nombre maximum de dosettes doit etre au moins de 1");
		if(capaciteEau < 0.25)
			throw new IllegalArgumentException("Le reservoir d'eau doit avoir une capacite d'au moins 0.25L.");
		this.capaciteDosettes = capaciteDosettes;
		this.capaciteEau = capaciteEau;
	}

	/** 
	 * Constructeur par <i>copie</i>.<br>
	 * Les capacit&eacute;s totales de l'objet en r&eacute;f&eacute;rence
	 * sont copi&eacute;es dans l'objet courant.
	 * @param ref l'objet de r&eacute;f&eacute;rence.
	 */
	public DistributeurCafe(DistributeurCafe ref)
	{
		this.capaciteDosettes = ref.capaciteDosettes;
		this.capaciteEau = ref.capaciteEau;
	}

	/** 
	 * Getter : renvoie le prix d'un caf&eacute; court.
	 * @return prix d'un caf&eacute; court.
	 */
	public static double getPrixCourt()
	{
		return prixCourt;
	}

	/** 
	 * Getter : renvoie le prix d'un caf&eacute; long.
	 * @return prix d'un caf&eacute; long.
	 */
	public static double getPrixLong()
	{
		return prixLong;
	}

	/**
	 * Getter : renvoie la capacit&eacute; totale de dosettes.
	 * @return capacit&eacute; totale de dosettes.
	 */
	public int getCapaciteDosettes()
	{
		return capaciteDosettes;
	}

	/**
	 * Getter : renvoie la capacit&eacute; totale du r&eacute;servoir d'eau.
	 * @return capacit&eacute; totale du reservoir.
	 */
	public double getCapaciteEau()
	{
		return capaciteEau;
	}

	/**
	 * Getter : renvoie le nombre courant de dosettes.
	 * @return nombre de dosettes.
	 */
	public int getNbDosettes()
	{
		return nbDosettes;
	}

	/**
	 * Getter : renvoie la quantit&eacute; courante d'eau.
	 * @return quantit&eacute; d'eau
	 */
	public double getNbEau()
	{
		return nbEau;
	}

	/**
	 * Getter : renvoie la valeur de la cagnotte.
	 * @return valeur de la cagnotte.
	 */
	public double getCagnotte()
	{
		return cagnotte;
	}

	/**
	 * Setter : modifie la valeur du prix d'un caf&eacute; court 
	 * commun &agrave; tous les distributeurs.
	 * @param prixCourt nouveau prix.
	 * @see getPrixCourt() prix d'un caf&eacute; court.
	 */
	public static void setPrixCourt(double prixCourt) throws IllegalArgumentException
	{
		if(prixCourt <= 0)
			throw new IllegalArgumentException("Le prix ne peut pas etre negatif ou nul.");
		DistributeurCafe.prixCourt = prixCourt;
	}

	/**
	 * Setter : modifie la valeur du prix d'un caf&eacute; long
	 * commun &agrave; tous les distributeurs.
	 * @param prixLong nouveau prix.
	 * @see getPrixLong() prix d'un caf&eacute; long.
	 */
	public static void setPrixLong(double prixLong) throws IllegalArgumentException
	{
		if(prixLong <= 0)
			throw new IllegalArgumentException("Le prix ne peut pas etre negatif ou nul.");
		DistributeurCafe.prixLong = prixLong;
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
			if(montant < prixCourt)
				throw new ArithmeticException("Le montant n'est pas suffisant.");
			if(nbDosettes < 1)
				throw new ArithmeticException("Il n'y a plus de dosette.");
			if(nbEau < 0.10)
				throw new ArithmeticException("Il n'y a plus assez d'eau.");
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
			System.out.println("La machine vous rend votre argent.");
			return montant;
		}

		nbDosettes--;
		nbEau -= 0.10;
		cagnotte += prixCourt;
		return montant - prixCourt;
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
			if(montant < prixLong)
				throw new ArithmeticException("Le montant n'est pas suffisant.");
			if(nbDosettes < 1)
				throw new ArithmeticException("Il n'y a plus de dosette.");
			if(nbEau < 0.25)
				throw new ArithmeticException("Il n'y a plus assez d'eau.");
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
			System.out.println("La machine vous rend votre argent.");
			return montant;
		}

		nbDosettes--;
		nbEau -= 0.25;
		cagnotte += prixLong;
		return montant - prixLong;
	}

	/**
	 * Ajoute des dosettes dans le distributeur.
	 * @param nbDosettes le nombre de dosettes &agrave; ajouter
	 */
	public void ajouterDosettes(int nbDosettes)
	{
		if((this.nbDosettes + nbDosettes) <= this.capaciteDosettes)
			this.nbDosettes += nbDosettes;
		else
			this.nbDosettes = this.capaciteDosettes;
	}

	/**
	 * Rempli le r&eacute;servoir d'eau du distributeur
	 * @param quantite la quantit&eacute; d'eau &agrave; ajouter
	 */
	public void remplirReservoir(double quantite)
	{
		if((this.nbEau + quantite) <= this.capaciteEau)
			this.nbEau += quantite;
		else
			this.nbEau = this.capaciteEau;
	}

	/** 
	 * Augmente tous les prix des caf&eacute;s selon le pourcentage
	 * indiqu&eacute; (entre 0 et 100);
	 * @param pourcentage pourcentage d'augmentation.
	 */
	public static void augmenter(double pourcentage) throws IllegalArgumentException
	{
		if(pourcentage < 0 || pourcentage > 100)
			throw new IllegalArgumentException("Le pourcentage d'augmentation doit etre compris entre 0 et 100.");
		prixCourt *= ((100 + pourcentage)/100);
		prixLong *= ((100 + pourcentage)/100);
	}

	/**
	 * Renvoie la description du distributeur sous forme d'une chaine
	 * de caract&egrave;res.
	 * @return Desciption.
	 */
	public String toString()
	{
		return "Distributeur de cafe : " + nbEau + "/" + capaciteEau + " L ; " + nbDosettes + "/" + capaciteDosettes + " doses ; " + cagnotte + " eur.";
	}

	/** 
	 * Fonction d'affichage &agrave; l'&eacute;cran.
	 * @see toString() Description.
	 */
	public void afficher()
	{
		System.out.println(this);
	}
}