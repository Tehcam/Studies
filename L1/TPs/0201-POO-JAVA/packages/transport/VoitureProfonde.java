package transport;
import personne.*;

/**
 * Classe <strong>Voiture Profonde</strong> qui impl&eacute;mente l'interface
 * <i>Ivoiture</i>. Son moteur et son r&eacute;servoir sont affect&eacute;s 
 * par copie profonde.
 * @author Corentin MACHET
 * @version 1.0
 */
public class VoitureProfonde implements IVoiture
{
	/**
	 * Conducteur de la voiture. Null par d&eacute;faut.
	 * @see Personne type Personne du conducteur.
	 */
	private Personne conducteur = null;

	/** 
	 * Moteur de la voiture.
	 * @see Moteur type Moteur du moteur.
	 */
	private final Moteur moteur;

	/** 
	 * R&eacute;servoir de la voiture.
	 * @see Reservoir type Reservoir du r&eacute;servoir.
	 */
	private final Reservoir reserve;

	/**
	 * Constructeur par <i>initialisation.</i>
	 * Affecte une copie du moteur et du r&eacute;servoir pass&eacute;s
	 * en param&egrave;tre.
	 * @param moteur Moteur &agrave; copier.
	 * @param reserve R&eacute;servoir &agrave; copier.
	 * @throws IllegalArgumentException propage l'exception si moteur
	 * ou reserve sont null.
	 */
	public VoitureProfonde(Moteur moteur, Reservoir reserve) throws IllegalArgumentException
	{
		if(moteur == null)
			throw new IllegalArgumentException("Le moteur ne peut etre null.");
		if(reserve == null)
			throw new IllegalArgumentException("Le reservoir ne peut etre null.");
		this.moteur = new Moteur(moteur);
		this.reserve = new Reservoir(reserve);
	}

	/** 
	 * Constructeur par <i>copie.</i>
	 * @see VoitureProfonde(Moteur, Reservoir) constructeur par initialisation
	 * @param ref Voiture &agrave; copier.
	 */
	public VoitureProfonde(VoitureProfonde ref)
	{
		this.moteur = new Moteur(ref.moteur);
		this.reserve = new Reservoir(ref.reserve);
	}

	/** 
	 * Conducteur getter.
	 * @return la r&eacute;f&eacute;rence vers le conducteur.
	 */
	public Personne getConducteur()
	{
		return conducteur;
	}

	/**
	 * Moteur getter.
	 * @return la r&eacute;f&eacute;rence vers le moteur de la voiture.
	 */
	public Moteur getMoteur()
	{
		return moteur;
	}

	/**
	 * Reserve getter.
	 * @return la r&eacute;f&eacute;rence vers le r&eacute;servoir de la voiture.
	 */
	public Reservoir getReserve()
	{
		return reserve;
	}

	/**
	 * Conducteur setter.
	 * @param c la r&eacute;f&eacute;rence vers le nouveau conducteur.
	 * @throws ArithmeticException si le conducteur est mineur.
	 */
	public void setConducteur(Personne c) throws ArithmeticException
	{
		if(c.getAge() < 18)
			throw new ArithmeticException("Le conducteur doit etre majeur.");
		conducteur = c;
	}

	/**
	 * Fait avancer la voiture de la distance souhait&eacute;e, selon s'il
	 * reste suffisamment de carburant.
	 * @param distance distance souhait&eacute;e, pass&eacute;e en param&egrave;tre.
	 * @return la distance parcourue.
	 */
	public double avancer(double distance)
	{
		try
		{
			if(conducteur == null)
				throw new IllegalArgumentException("Il n'y a pas de conducteur");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			return 0;
		}
		double kilometres = (reserve.getContenu()*100)/moteur.getConsommation();
		if(kilometres <= distance)
		{
			reserve.vider(reserve.getContenu());
			return kilometres;
		}
		else
		{
			double baisseDeCarbu = (distance*moteur.getConsommation())/100;
			reserve.vider(baisseDeCarbu);
			return distance;
		}
	}

	/** 
	 * Remplit le r&eacute;servoir au maximum.
	 * @return total de carburant ajout&eacute; dans la voiture.
	 */
	public double faireLePlein()
	{
		double r = reserve.getCapacite() - reserve.getContenu();
		reserve.remplir(r);
		return r;
	}

	/**
	 * Retourne la quantit&eacute; de carburant restant.
	 * @return quantit&eacute; de carburant dans le r&eacute;servoir.
	 */
	public double getContenuReservoir()
	{
		return reserve.getContenu();
	}

	/** 
	 * Description de l'objet.
	 * @return la description sous forme de chaine de caract&egrave;res.
	 */
	public String toString()
	{
		return "Voiture : [moteur] " + moteur.toString() + " [reservoir] " + reserve.toString();
	}

	/**
	 * Affiche la description de l'objet &agrave; la console.
	 * @see toString() description.
	 */
	public void afficher()
	{
		System.out.println(this);
	}
}