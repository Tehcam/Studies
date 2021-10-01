import java.util.Scanner;

class Exo1
{
	public static void main(String[] args)
	{
		Vector v1 = new Vector("MyVec", 1, 3);
		Vector v2 = new Vector();
		System.out.println(v1);
		v1.setAbs(0);
		v1.setOrd(0);
		System.out.println(v2.toString());
		if(v1.egalA(v2))
			System.out.println("Les vecteurs sont égaux.");
		else
			System.out.println("Ils sont differents.");
	}
}