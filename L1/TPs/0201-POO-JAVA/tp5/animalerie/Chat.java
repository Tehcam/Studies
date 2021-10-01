package animalerie;

public class Chat extends Mammifere
{
	public Chat(String nom)
	{
		super(nom);
	}

	@Override
	public void crier()
	{
		System.out.println("Miaou miaou");
	}

	@Override
	public String toString()
	{
		return "Chat " + super.toString();
	}
}