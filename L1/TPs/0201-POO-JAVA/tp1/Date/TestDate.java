import java.util.Scanner;

class TestDate
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		System.out.print("Jour : ");
		int j = cin.nextInt();
		System.out.print("Mois : ");
		int m = cin.nextInt();
		System.out.print("Annee : ");
		int a = cin.nextInt();
		Date d1 = new Date(j, m, a);
		Date d2 = new Date();

		d2.setDay(d1.getDay());
		d2.setMonth(d1.getMonth());
		d2.setYear(d1.getYear());

		System.out.println(d1);
		d2.afficher();

		Date d3 = new Date(30, 2, 2003);
		d3.afficher();
		d3.setDay(29);
		d3.afficher();
		d3.setMonth(20);
		d3.afficher();
	}
}