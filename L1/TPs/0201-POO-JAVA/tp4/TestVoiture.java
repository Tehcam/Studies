import transport.*;
import personne.*;

public class TestVoiture
{
	public static void main(String[] args)
	{
		System.out.println("VOITURE SURFACE");
		Moteur moteur = new Moteur();
		Reservoir reserve = new Reservoir();
		VoitureSurface v1 = new VoitureSurface(moteur, reserve);
		VoitureSurface v2 = new VoitureSurface(v1);
		v1.setConducteur(new Personne("Jean", "Michel", 20));
		v2.setConducteur(new Personne("Jean", "Eude", 36));
		v1.afficher();
		System.out.println("> " + v1.getContenuReservoir() + " L");
		v2.afficher();
		System.out.println("> " + v2.getContenuReservoir() + " L");

		v1.faireLePlein();

		v1.afficher();
		System.out.println("> " + v1.getContenuReservoir() + " L");
		v2.afficher();
		System.out.println("> " + v2.getContenuReservoir() + " L");
		// on s'attend à avoir la meme quantite de carbu dans les 2 moteurs alors que seul v1 a eu un plein.

		System.out.println(v1.avancer(30));

		System.out.println("VOITURE PROFONDE");
		VoitureProfonde v3 = new VoitureProfonde(moteur, reserve);
		VoitureProfonde v4 = new VoitureProfonde(v3);
		v3.afficher();
		System.out.println("> " + v3.getContenuReservoir() + " L");
		v4.afficher();
		System.out.println("> " + v4.getContenuReservoir() + " L");

		v3.faireLePlein();

		v3.afficher();
		System.out.println("> " + v3.getContenuReservoir() + " L");
		v4.afficher();
		System.out.println("> " + v4.getContenuReservoir() + " L");
		// cette fois ci seul v3 a bien eu son plein 

		try
		{
			v3.setConducteur(new Personne("Jean", "Michel"));
			System.out.println(v3.avancer(30));
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		// la voiture ne devrait pas parcourir de km car le conducteur n'est pas majeur
		v3.setConducteur(new Personne("Jean", "Marie", 18));
		System.out.println(v3.avancer(30));
	}
}