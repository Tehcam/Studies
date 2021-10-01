package transport;
import personne.*;

public class VoitureSurface implements IVoiture
{
	private Personne conducteur = null;
	private final Moteur moteur;
	private final Reservoir reserve;

	public VoitureSurface(Moteur moteur, Reservoir reserve) throws IllegalArgumentException
	{
		if(moteur == null)
			throw new IllegalArgumentException("Le moteur ne peut etre null.");
		if(reserve == null)
			throw new IllegalArgumentException("Le reservoir ne peut etre null.");
		this.moteur = moteur;
		this.reserve = reserve;
	}

	public VoitureSurface(VoitureSurface ref)
	{
		this.moteur = ref.moteur;
		this.reserve = ref.reserve;
	}

	public Personne getConducteur()
	{
		return conducteur;
	}

	public Moteur getMoteur()
	{
		return moteur;
	}

	public Reservoir getReserve()
	{
		return reserve;
	}

	public void setConducteur(Personne c) throws ArithmeticException
	{
		if(c.getAge() < 18)
			throw new ArithmeticException("Le conducteur doit etre majeur.");
		conducteur = c;
	}

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

	public double faireLePlein()
	{
		double r = reserve.getCapacite() - reserve.getContenu();
		reserve.remplir(r);
		return r;
	}

	public double getContenuReservoir()
	{
		return reserve.getContenu();
	}

	public String toString()
	{
		return "Voiture : [moteur] " + moteur.toString() + " [reservoir] " + reserve.toString();
	}

	public void afficher()
	{
		System.out.println(this);
	}
}