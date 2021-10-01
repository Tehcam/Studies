import java.io.*;

public class TestToutou
{
	public static void main(String[] args)
	{
		System.out.println("Creation du chien : Milou");
		Toutou milou = null;
		try
		{
			milou = new Toutou("Milou", 4);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println(milou.getNom() + " a " + milou.getNbPuces() + " puces.");
		Toutou rex = new Toutou();
		try
		{
			rex.setNbPuces(-1);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println(rex);
		}
		Toutou medor = null;
		try
		{
			medor = new Toutou("Medor", -11);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(medor != null)
				System.out.println(medor);
		}
		System.out.println(milou.egalA(rex));
	}
}