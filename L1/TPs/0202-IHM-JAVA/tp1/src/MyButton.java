import javax.swing.JButton;

public class MyButton extends JButton
{
	private int abs;
	private int ord;

	public MyButton(int abs, int ord)
	{
		super();
		this.abs = abs;
		this.ord = ord;
	}

	public int getAbs()
	{
		return abs;
	}

	public int getOrd()
	{
		return ord;
	}
}