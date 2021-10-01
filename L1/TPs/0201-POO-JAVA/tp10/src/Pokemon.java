/**
 * Classe Pokemon
 * @author Jessica Jonquet
 * @version 25/03/2019
 */
import java.io.*;
import java.util.Scanner;
public class Pokemon{
	public static void main (String[] args){

		DataInputStream clavier = new DataInputStream(System.in);

		int deux = 0;
		System.out.println("Entrez un nombre...");
		try
		{
			deux = clavier.readInt();
		}
		catch(IOException e)
		{
			System.err.println("IOException !");
		}
		System.out.println(deux);

		try
		{
			FileOutputStream f = new FileOutputStream("toto.txt");
			f.write(deux);
			f.write(2000);
			f.close();
		}
		catch(FileNotFoundException e)
		{
			System.err.println("FileNotFoundException !");
		}
		catch(IOException e)
		{
			System.err.println("IOException !");
		}

		int[] u = new int[1];
		try
		{
			u[2] = 33;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("ArrayIndexOutOfBoundsException !");
		}
		u = new int[7];
		try
		{
			u[7] = 99/deux;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("ArrayIndexOutOfBoundsException !");
		}
		catch(ArithmeticException e)
		{
			System.err.println("ArithmeticException !");
		}
	}
}