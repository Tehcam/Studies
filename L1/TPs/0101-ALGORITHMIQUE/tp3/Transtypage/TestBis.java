class TestBis
{
	public static void main(String[] args)
	{
		byte entier1 = 1;
		int entier2 = 255;
		long entier3 = 2;
		entier1 = (byte)(entier2 + entier1);
		entier3 = entier2 + entier1;
		System.out.println(entier1 + " " + entier2 + " " + entier3);
	}
}