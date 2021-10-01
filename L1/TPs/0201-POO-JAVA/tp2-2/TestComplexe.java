public class TestComplexe
{
	public static void main(String[] args)
	{
		Complexe c1 = new Complexe();
		Complexe c2 = new Complexe(1.5, 2);
		Complexe c3 = new Complexe(c2);

		c1.afficher();
		c2.afficher();
		c3.afficher();

		System.out.println(c2.egalA(c3));
		c3.changerValeur(4, 3);
		c1.setPartieImaginaire(4);
		c1.setPartieReelle(3);

		c1.afficher();
		c2.afficher();
		c3.afficher();

		c1.ajouter(c3);
		c1.afficher();

		c2.setPartieImaginaire(-5);
		c2.afficher();

		System.out.println(Complexe.somme(c1, c2));
	}
}