import animalerie.*;

public class TestAnimalerie
{
	public static void main(String[] args)
	{
		Animal animal = new Animal("MyPet", 4);
		animal.crier();
		animal.afficher();

		Animal animal2 = new Animal(animal);
		animal2.afficher();

		Mammifere m = new Mammifere("Mamie fer");
		m.crier();
		m.afficher();
		m.setNom("Mammifere evolue");
		m.afficher();

		Chien dog = new Chien("Medor");
		dog.crier();
		dog.afficher();

		Chat cat = new Chat("Hello Kitty");
		cat.crier();
		cat.afficher();

		Mammifere m2 = new Chien("Rex");
		m2.crier();
		m2.afficher();
		Chien m3 = (Chien) m2;
		m3.crier();
	}
}