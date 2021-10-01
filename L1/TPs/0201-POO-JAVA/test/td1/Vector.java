public class Vector
{
	private String name;
	private int abs;
	private int ord;

	public Vector(String name, int abs, int ord)
	{
		this.name = name;
		this.abs = abs;
		this.ord = ord;
	}

	public Vector()
	{
		this("Vector", 0, 0);
	}

	public String getName()
	{
		return this.name;
	}

	public int getAbs()
	{
		return this.abs;
	}

	public int getOrd()
	{
		return this.ord;
	}

	public void setAbs(int a)
	{
		this.abs = a;
	}

	public void setOrd(int o)
	{
		this.ord = o;
	}

	public String toString()
	{
		return "Les coordonnees du vecteur " + this.name + " sont (" + this.abs + ";" + this.ord + ").";
	}

	public boolean egalA(Vector v)
	{
		return (this.abs == v.getAbs() && this.ord == v.getOrd());
	}
}