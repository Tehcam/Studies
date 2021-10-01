import animalerie.Chat;
import animalerie.Chien;
import animalerie.Pigeon;
import animalerie.Abeille;
import animalerie.AAnimal;

public class Test
{
	public static void main(String[] args) 
	{
		AAnimal[] tab = new AAnimal[5];
		tab[0] = new Chat("Azrael");
		tab[1] = new Chien("Medor");
		tab[2] = new Pigeon("Hector");
		tab[3] = new Abeille("Maya", 4);
		tab[4] = new Abeille("Willy", 4);

		tab[0].arracherPatte();
		tab[1].arracherAile();
		tab[2].arracherPatte();
		tab[3].arracherPatte();
		tab[3].arracherAile();

		for(int i=0; i<5; i++)
		{
			System.out.println(tab[i]);
		}

		System.out.println("fin du programme...");
	}
}