/**
 * Classe <strong>Rationnel</strong>, impl&eacute;mente l'interface IRationnel
 * @author Corentin MACHET
 * @version 1.0
 */

public class Rationnel implements IRationnel, IAffiche
{
	private int numerateur;
	private int denominateur;

	/** 
	 * 
	 */
	public Rationnel()
	{

	}

	/** 
	 * 
	 */
	public Rationnel(int numerateur, int denominateur)
	{

	}

	/** 
	 * 
	 */
	public Rationnel(Rationnel ref)
	{

	}

	/** 
	 * 
	 */
	public int getNumerateur()
	{
		return numerateur;
	}

	/** 
	 * 
	 */
	public int getDenominateur()
	{
		return denominateur;
	}

	/** 
	 * 
	 */
	public void setNumerateur(int numerateur)
	{
		this.numerateur = numerateur;
	}

	/** 
	 * 
	 */
	public void setDenominateur(int denominateur)
	{
		this.denominateur = denominateur;
	}

	/** 
	 * 
	 */
	public void changerValeur(int numerateur, int denominateur)
	{
		this.numerateur = numerateur;
		this.denominateur = denominateur;
	}

	/** 
	 * 
	 */
	public boolean egalA(Rationnel r)
	{

	}

	/** 
	 * 
	 */
	public void ajouter(Rationnel r)
	{

	}

	@Override
	/** 
	 * 
	 */
	public String toString()
	{

	}

	/** 
	 * 
	 */
	public void afficher()
	{
		System.out.println(this);
	}
}